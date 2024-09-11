package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private EntityManager entityManager;

	// Create a new customer
	public void createCustomer(Customer customer) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(customer);
		entityTransaction.commit();
	}	

	// Read a customer by ID
	public Customer readCustomer(int id) {
		return entityManager.find(Customer.class, id);
	}
	
	public Customer getCustomerByEmail(String mail) {
		String query = "SELECT c FROM Customer c WHERE c.email = :email";
		
		 try {
			 Customer customer=  entityManager.createQuery(query, Customer.class).setParameter("email", mail).getSingleResult();
			 System.out.println(customer.getName());
			 return customer;
		 }catch(NoResultException e) {
			 return null;
		 }
		
	}

	// Update an existing customer
	public void updateCustomer(Customer customer) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Customer customer2 = readCustomer(customer.getId());
		
		customer2.setName(customer.getName());
		customer2.setPhone(customer.getPhone());
		customer2.setEmail(customer.getEmail());
		customer2.setPassword(customer.getPassword());

		entityTransaction.commit();
	}

	// Delete a customer
	public void deleteCustomer(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			entityManager.remove(customer);
		}
		
		entityTransaction.commit();
	}

	// Read all customers
	public List<Customer> readAllCustomer() {
		String query = "SELECT c FROM Customer c";
		return entityManager.createQuery(query, Customer.class).getResultList();
	}

}
