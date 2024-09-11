package com.jsp.controller;

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
public class ItemController {

	@Autowired
	ItemDao itemDao;

	@Autowired
	MenuDao menuDao;

	@GetMapping("admin")
	public ModelAndView getAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admin.jsp");
		return modelAndView;
	}

	@RequestMapping("addItem")
	public ModelAndView createItem() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", 0);
		modelAndView.addObject("item", new Item());
		modelAndView.setViewName("admin/item.jsp");
		return modelAndView;
	}
	
	@RequestMapping("addItemToMenu")
	public ModelAndView addItemToMenu(@RequestParam int id) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", id);
		modelAndView.addObject("item", new Item());
		modelAndView.setViewName("admin/item.jsp");

		return modelAndView;

	}

	@PostMapping("saveItem")
	public ModelAndView saveItem(@ModelAttribute Item item, @RequestParam int menuId) {
		ModelAndView modelAndView = new ModelAndView();
		
		itemDao.saveItem(item);
		
		if (menuId > 0) {
			Menu menu = menuDao.getMenuById(menuId);  // Ensure this is fetched from the database
			if (menu != null) {

				menu.getItems().add(item);
			    menuDao.saveMenu(menu);  // Persist the changes to the Menu
			}
			
			modelAndView.addObject("menuList", menuDao.getAllMenu());
			modelAndView.setViewName("admin/menuList.jsp");
		} else {
			modelAndView.setViewName("admin/addItemSuccess.jsp");
		}

		return modelAndView;
	}

	@RequestMapping("itemsList")
	public ModelAndView getAllItems() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", itemDao.getAllItems());
		modelAndView.setViewName("admin/itemsList.jsp");
		return modelAndView;
	}
	
	@RequestMapping("deleteItemOfMenu")
	public ModelAndView deleteItemOfMenu(@RequestParam int menuId, @RequestParam int itemId) {
		
		Menu menu = menuDao.getMenuById(menuId);
		Item item = itemDao.getItemById(itemId);
		itemDao.getAllItems().remove(item);
		menu.getItems().remove(item);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuList", menuDao.getAllMenu());
		modelAndView.setViewName("admin/menuList.jsp");
		return modelAndView;
	}
	

	@RequestMapping("editItemOfMenu")
	public ModelAndView editItemOfMenu(@RequestParam int menuId, @RequestParam int itemId) {
		
		Menu menu = menuDao.getMenuById(menuId);
		Item item = itemDao.getItemById(itemId);
		itemDao.getAllItems().remove(item);
		menu.getItems().remove(item);
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", menuId);
		modelAndView.addObject("item", item);
		modelAndView.setViewName("admin/editItemOfMenu.jsp");
		return modelAndView;
	}


}
