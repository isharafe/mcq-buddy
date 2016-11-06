package com.idea.mcq.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.idea.mcq.model.Subject;
import com.idea.mcq.util.PersistenceManager;

public class SubjectService {

	EntityManager entityManager;

	public SubjectService() {
		entityManager = PersistenceManager.INSTANCE.getEntityManager();
	}

	public Subject add(Subject c) {
		entityManager.getTransaction().begin();
		c = entityManager.merge(c);
		entityManager.getTransaction().commit();
		entityManager.close();
		return c;
	}

	public Subject edit(Subject c) {
		entityManager.getTransaction().begin();
		c = entityManager.merge(c);
		entityManager.getTransaction().commit();
		entityManager.close();
		return c;
	}

	public boolean delete(Subject c) {
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

	public List<Subject> browse() {
		entityManager.getTransaction().begin();
		List<Subject> result = entityManager.createQuery( "from Subject", Subject.class ).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
}
