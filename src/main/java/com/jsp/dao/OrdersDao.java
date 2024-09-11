package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Customer;
import com.jsp.entity.Orders;

@Repository
public class OrdersDao {

    @Autowired
    private EntityManager entityManager;

    // Create a new order
    public void createOrder(Orders order) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(order);
        
        entityTransaction.commit();
    }    

    // Read an order by ID
    public Orders readOrder(int id) {
        return entityManager.find(Orders.class, id);
    }

    // Update an existing order
    public void updateOrder(Orders order) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Orders existingOrder = readOrder(order.getId());
        
        existingOrder.setCustomerDetails(order.getCustomerDetails()); 
        existingOrder.setTotalCost(order.getTotalCost()); 

        entityTransaction.commit();
    }

    // Delete an order
    public void deleteOrder(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Orders order = entityManager.find(Orders.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
        
        entityTransaction.commit();
    }

    // Read all orders
    public List<Orders> readAllOrders() {
        String query = "SELECT o FROM Orders o";
        return entityManager.createQuery(query, Orders.class).getResultList();
    }
    
    // get all orders of customer
    public List<Orders> getCustomerOrders(Customer searchCustomer){
    	String query = "SELECT o FROM Orders o WHERE o.customerDetails =:searchCustomer";
    	
        return entityManager.createQuery(query, Orders.class).setParameter("searchCustomer", searchCustomer).getResultList();
    }
}
