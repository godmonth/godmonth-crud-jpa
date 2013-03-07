package com.godmonth.crud.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.godmonth.crud.jpa.po.LongIdPo;

@Repository
public class CrudDaoImpl<T extends LongIdPo> implements CrudDao<T> {
	private EntityManager entityManager;
	private Class<T> clazz;

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
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
	}

	@Required
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

}
