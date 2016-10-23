package br.unip.urbanizacao.dao;

public interface DAO<T, K> {

	public T persist(T entity);

	public T find(Class<T> clazz, K key);

	public void remove(T entity);

	public void merge(T entity);

}