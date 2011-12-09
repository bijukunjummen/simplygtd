package org.bk.simplygtd.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class JpaDao<K, E> implements BaseDao<K, E> {
	protected Class<E> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public JpaDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional
	public E update(E entity){
		return this.entityManager.merge(entity);
	}
	@Transactional
	public E persist(E entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	@Transactional
	public void remove(E entity) {
		this.entityManager.remove(entity);
	}

	public E findById(K id) {
		return this.entityManager.find(this.entityClass, id);
	}

	/**
	 * @return the entityManager
	 */
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}