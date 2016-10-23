package br.unip.urbanizacao.provider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMProvider {

	private static EntityManager entityManager;

	private EMProvider() {
		super();
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			final EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("urbanizacao_pu");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
