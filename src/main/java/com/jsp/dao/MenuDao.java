package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Menu;

@Repository
public class MenuDao {
	
	@Autowired
	EntityManager entityManager;

	public  void saveMenu(Menu menu) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
	}
	
	public  void updateMenu(Menu menu) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Menu updateMenu = getMenuById(menu.getId());
		updateMenu.setName(menu.getName());
		entityTransaction.commit();
	}
	
	public List<Menu> getAllMenu(){
		Query query = entityManager.createQuery("select m from Menu m");
		return query.getResultList();
	}
	
	public Menu getMenuById(int id) {
		return entityManager.find(Menu.class, id);
	}
	
	public void deleteById(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(getMenuById(id));
		entityTransaction.commit();
		
	}
	
	

}
