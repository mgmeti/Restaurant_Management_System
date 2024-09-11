package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Item;

@Repository
public class ItemDao {
	@Autowired
	EntityManager entityManager;
	
	public void saveItem(Item item) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}
	
	public Item getItemById(int id) {
		return entityManager.find(Item.class, id);
	}
	
	
	public List<Item> getAllItems(){
		Query query = entityManager.createQuery("from Item");
		
		return query.getResultList();
		
	}

}
