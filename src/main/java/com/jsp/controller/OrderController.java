package com.jsp.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.ItemDao;
import com.jsp.dao.MenuDao;
import com.jsp.dao.OrdersDao;
import com.jsp.entity.Item;
import com.jsp.entity.Orders;
import com.jsp.entity.Product;

@Controller
public class OrderController {
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	MenuDao menuDao;
	
	
	@RequestMapping("createOrder")
	public ModelAndView createOrder(@RequestParam int customerId) {
		ModelAndView modelAndView = new ModelAndView();
		Orders order  = new Orders();
		order.setProducts(new ArrayList<Product>());
		modelAndView.addObject("order", order);
		modelAndView.addObject("customerId", customerId);
		modelAndView.addObject("items", menuDao.getMenuById(13).getItems());
		modelAndView.setViewName("customer/createOrder.jsp");
		return modelAndView;
	}
	

}
