package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.CustomerDao;
import com.jsp.dao.OrdersDao;
import com.jsp.entity.Customer;
import com.jsp.entity.Menu;
import com.jsp.entity.User;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	OrdersDao ordersDao;

	public ModelAndView viewCustomer(User validUser) {
		ModelAndView modelAndView = new ModelAndView();
		Customer customer = customerDao.getCustomerByEmail(validUser.getEmail());
		if (customer != null) {

			modelAndView.addObject("customer", customer);
			modelAndView.addObject("ordersList", ordersDao.getCustomerOrders(customer));
			modelAndView.setViewName("customer/customer.jsp");
		} else {
			modelAndView.addObject("user", validUser);
			modelAndView.addObject("customer", new Customer());
			modelAndView.setViewName("customer/createCustomer.jsp");
		}
		return modelAndView;
	}

	@PostMapping("saveCustomer")
	public ModelAndView saveCustomerDetails(@ModelAttribute Customer customer) {
		// save to table user
		customerDao.createCustomer(customer);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customer", customerDao.readCustomer(customer.getId()));
		modelAndView.addObject("ordersList", ordersDao.getCustomerOrders(customer));
		modelAndView.setViewName("customer/customer.jsp");
		return modelAndView;
	}
	
	@RequestMapping("customerHome")
	public ModelAndView customerHome(@RequestParam int customerId) {
		ModelAndView modelAndView = new ModelAndView();

		Customer customer = customerDao.readCustomer(customerId);

		modelAndView.addObject("customer", customer);
		modelAndView.addObject("ordersList", ordersDao.getCustomerOrders(customer));
		modelAndView.setViewName("customer/customer.jsp");
		return modelAndView;
	}
	
	@RequestMapping("editCustomer")
	public ModelAndView editCustomer(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();

		Customer customer = customerDao.readCustomer(id);

		modelAndView.addObject("editCustomer", customer);
		modelAndView.setViewName("customer/editCustomer.jsp");
		return modelAndView;
	}
	
	@RequestMapping("updateCustomer")
	public ModelAndView mergeMenu(@ModelAttribute Customer customer) {
		
		customerDao.updateCustomer(customer);
		ModelAndView modelAndView = new ModelAndView();


		modelAndView.addObject("customer", customer);
		modelAndView.addObject("ordersList", ordersDao.getCustomerOrders(customer));
		modelAndView.setViewName("customer/customer.jsp");
		return modelAndView;

	}

}
