package com.godmonth.crud.jpa.service;

import java.util.List;

import com.godmonth.crud.jpa.model.LongIdModel;

public interface CrudService<T extends LongIdModel> {
	void save(T t);

	void delete(Long id);

	T get(Long id);

	List<T> list();
}
