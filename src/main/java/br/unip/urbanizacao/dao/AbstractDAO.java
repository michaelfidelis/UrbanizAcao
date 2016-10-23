package br.unip.urbanizacao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public abstract class AbstractDAO<T, K> implements DAO<T, K> {

	protected EntityManager manager;

	public AbstractDAO(final EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public T persist(final T entity) throws PersistenceException {
		this.manager.getTransaction().begin();
		this.manager.persist(entity);
		this.manager.getTransaction().commit();
		return entity;
	}

	@Override
	public T find(final Class<T> clazz, final K key) throws NoResultException {
		return this.manager.find(clazz, key);
	}

	@Override
	public void remove(final T entity) throws PersistenceException {
		this.manager.getTransaction().begin();
		this.manager.remove(entity);
		this.manager.getTransaction().commit();
	}

	@Override
	public void merge(final T entity) throws PersistenceException {
		this.manager.getTransaction().begin();
		this.manager.merge(entity);
		this.manager.getTransaction().commit();
	}
}