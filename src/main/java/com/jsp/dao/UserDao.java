package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.entity.User;

@Repository
public class UserDao {

	@Autowired
	EntityManager entityManager;

	public void saveUser(User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User getUserByEmail(String email) {
		Query query = entityManager.createQuery("select u from User u  where u.email = ?1");
		query.setParameter(1, email);
		List<User> user = query.getResultList();

		if (user.isEmpty()) {
			return null;
		}
		return user.get(0);
	}
}
