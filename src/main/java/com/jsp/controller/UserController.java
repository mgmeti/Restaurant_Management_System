package com.jsp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.UserDao;
import com.jsp.entity.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CustomerController customerController;

	@GetMapping("home")
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}

	@GetMapping("createUser")
	public ModelAndView getCreateUser() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("user/user.jsp");
		return modelAndView;
	}

	@PostMapping("saveUser")
	public ModelAndView saveUserDetails(@ModelAttribute User user ) {
		// save to table user
		userDao.saveUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/registrationSuccess.jsp");
		return modelAndView;
	}

	@GetMapping("login")
	public ModelAndView getLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("user/login.jsp");
		return modelAndView;
	}

	@GetMapping("validateUser")
	public ModelAndView validateUserDetails(HttpServletRequest req ) {
		ModelAndView modelAndView = new ModelAndView();
		User validUser = userDao.getUserByEmail(req.getParameter("email"));

		if (validUser != null) {
			if (validUser.getPassword().equals(req.getParameter("password"))) {
				if (validUser.getRole().equals("admin")) {
					modelAndView.setViewName("admin/admin.jsp");
				} else if (validUser.getRole().equals("customer")) {
					return customerController.viewCustomer(validUser);
				}
			} else {
				modelAndView.addObject("error", "Wrong Password for " + req.getParameter("email"));
				modelAndView.setViewName("user/validateError.jsp");
			}
		} else {
			modelAndView.addObject("error", "User Not Found for " + req.getParameter("email"));
			modelAndView.setViewName("user/validateError.jsp");
		}

		return modelAndView;
	}

}
