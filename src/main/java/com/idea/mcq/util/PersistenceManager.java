package com.idea.mcq.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {

	INSTANCE;

	private EntityManagerFactory entityManagerFactory;

	private PersistenceManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PERSISTENT_UNIT_NAME);
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void close() {
		entityManagerFactory.close();
	}

}