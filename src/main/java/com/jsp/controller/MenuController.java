package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.ItemDao;
import com.jsp.dao.MenuDao;
import com.jsp.entity.Item;
import com.jsp.entity.Menu;

@Controller
public class MenuController {

	@Autowired
	MenuDao menuDao;

	@Autowired
	ItemDao itemDao;

	@Autowired
	ItemController itemController;

	@GetMapping("createMenu")
	public ModelAndView createMenu() {

		Menu menu = new Menu();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu", menu);
		modelAndView.setViewName("admin/createMenu.jsp");
		return modelAndView;
	}

	@RequestMapping("saveMenu")
	public ModelAndView saveMenu(@ModelAttribute Menu menu) {
		
		menu.setItems(new ArrayList<Item>());

		menuDao.saveMenu(menu);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuList", menuDao.getAllMenu());
		modelAndView.setViewName("admin/menuList.jsp");

		return modelAndView;

	}
	
	@RequestMapping("updateMenu")
	public ModelAndView mergeMenu(@ModelAttribute Menu menu) {
		
		menuDao.updateMenu(menu);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuList", menuDao.getAllMenu());
		modelAndView.setViewName("admin/menuList.jsp");

		return modelAndView;

	}

	@GetMapping("menuList")
	public ModelAndView getMenuList() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuList", menuDao.getAllMenu());
		modelAndView.setViewName("admin/menuList.jsp");

		return modelAndView;
	}

	
	@RequestMapping("deleteMenu")
	public ModelAndView deleteMenu(@RequestParam int id) {

		menuDao.deleteById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuList", menuDao.getAllMenu());
		modelAndView.setViewName("admin/menuList.jsp");

		return modelAndView;

	}
	
	@RequestMapping("editMenu")
	public ModelAndView editMenu(@RequestParam int id) {

		
		ModelAndView modelAndView = new ModelAndView();
		// get menu by id and add to jsp
		modelAndView.addObject("editMenu", menuDao.getMenuById(id));
		modelAndView.setViewName("admin/editMenu.jsp");

		return modelAndView;

	}

}
