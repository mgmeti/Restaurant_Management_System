package com.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Item;
import com.jsp.entity.Orders;
import com.jsp.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	ItemDao itemDao;

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	CustomerDao customerDao;

	// Add or update product quantity in the order
	public void addProduct(int customerId, int orderId, int itemId, int quantityToAdd) {

		// Get order to add item
		Orders order = orderId > 0 ? ordersDao.readOrder(orderId) : new Orders();

		// Fetch item details from ItemDao
		Item item = itemDao.getItemById(itemId);

		if (order.getProducts() == null) {
			// no products in order cart
			order.setProducts(new ArrayList<Product>());

			// create new product
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Product product = new Product();
			product.setName(item.getName());
			product.setCategory(item.getCategory());
			product.setPrice(item.getPrice());
			product.setQuantity(quantityToAdd);

			entityManager.persist(product);
			entityTransaction.commit();

			order.getProducts().add(product);
			order.setTotalCost(quantityToAdd * product.getPrice());
			order.setCustomerDetails(customerDao.readCustomer(customerId));
			ordersDao.createOrder(order);
		} else {
			List<Product> products = order.getProducts();
			
			boolean itemflag = false;
			for (Product p : products) {
				if (p.getName().equals(item.getName())) {
					EntityTransaction entityTransaction = entityManager.getTransaction();
					entityTransaction.begin();
					Product updateProduct = getProductById(p.getId());
					updateProduct.setQuantity(quantityToAdd + updateProduct.getQuantity());

					entityTransaction.commit();
					
					itemflag = true;
					order.setTotalCost(order.getTotalCost() + (quantityToAdd * updateProduct.getPrice()));
					ordersDao.updateOrder(order);
				}
			}
			
			if(!itemflag) {
				// create new product
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				Product product = new Product();
				product.setName(item.getName());
				product.setCategory(item.getCategory());
				product.setPrice(item.getPrice());
				product.setQuantity(quantityToAdd);

				entityManager.persist(product);
				entityTransaction.commit();

				order.getProducts().add(product);
				order.setTotalCost(order.getTotalCost() + (quantityToAdd * product.getPrice()));
				ordersDao.updateOrder(order);
			}

		}

	}

	public Product getProductById(int id) {
		return entityManager.find(Product.class, id);
	}
}
