package com.idea.mcq.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.idea.mcq.model.Mcq;
import com.idea.mcq.util.PersistenceManager;


public class McqService {

	EntityManager entityManager;

	public McqService() {
		entityManager = PersistenceManager.INSTANCE.getEntityManager();
	}

	public Mcq add(Mcq c) {
		entityManager.getTransaction().begin();
		c = entityManager.merge(c);
		entityManager.getTransaction().commit();
		entityManager.close();
		return c;
	}

	public Mcq edit(Mcq c) {
		entityManager.getTransaction().begin();
		c = entityManager.merge(c);
		entityManager.getTransaction().commit();
		entityManager.close();
		return c;
	}

	public boolean delete(Mcq c) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(c);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Mcq> browse() {
		entityManager.getTransaction().begin();
		List<Mcq> result = entityManager.createQuery( "from Mcq", Mcq.class ).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
}
