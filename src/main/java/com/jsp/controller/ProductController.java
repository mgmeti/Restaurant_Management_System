package com.jsp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.ItemDao;
import com.jsp.dao.MenuDao;
import com.jsp.dao.OrdersDao;
import com.jsp.dao.ProductDao;

@Controller
public class ProductController {

	@Autowired
	ItemDao itemDao;

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	MenuDao menuDao;

	@RequestMapping("addItemToOrder")
	public ModelAndView addItemToOrder(@RequestParam int customerId, @RequestParam int orderId,
			@RequestParam int itemId) {

//		// Extract item IDs and quantities from the request parameters
//		int quantityToAdd = Integer.parseInt(quantity);

		productDao.addProduct(customerId, orderId, itemId, 1);

		ModelAndView modelAndView = new ModelAndView();
		if (orderId < 1) {

			int lastOrderId = ordersDao.readAllOrders().get(ordersDao.readAllOrders().size() - 1).getId();
			modelAndView.addObject("order", ordersDao.readOrder(lastOrderId));
		} else {
			modelAndView.addObject("order", ordersDao.readOrder(orderId));
		}
		modelAndView.addObject("customerId", customerId);
		modelAndView.addObject("items", menuDao.getMenuById(13).getItems());
		modelAndView.setViewName("customer/createOrder.jsp");
		return modelAndView;

	}

}
