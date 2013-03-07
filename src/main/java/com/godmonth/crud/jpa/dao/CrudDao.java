package com.godmonth.crud.jpa.dao;

import java.util.List;

import com.godmonth.crud.jpa.po.LongIdPo;

public interface CrudDao<T extends LongIdPo> {
	void persist(T t);

	void merge(T t);

	void delete(Long id);

	T get(Long id);

	List<T> list();

	Class<T> getPoClass();
}
