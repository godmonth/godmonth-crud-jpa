package com.godmonth.crud.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.godmonth.crud.jpa.po.LongIdPo;

@Repository
public abstract class CrudDaoImpl<T extends LongIdPo> implements CrudDao<T> {
	protected EntityManager entityManager;
	protected Class<T> poClass;

	@Override
	public void persist(T t) {
		entityManager.persist(t);
	}

	@Override
	public void merge(T t) {
		entityManager.merge(t);
	}

	@Override
	public void delete(Long id) {
		T t = get(id);
		entityManager.remove(t);
	}

	@Override
	public T get(Long id) {
		return entityManager.find(poClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return entityManager.createQuery("FROM " + poClass.getName()).getResultList();
	}

	@Required
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPoClass() {
		return poClass;
	}

	public void setPoClass(Class<T> poClass) {
		this.poClass = poClass;
	}

}
