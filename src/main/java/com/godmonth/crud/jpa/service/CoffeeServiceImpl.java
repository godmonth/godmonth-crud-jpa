package com.godmonth.crud.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.dozer.Mapper;
import org.springframework.beans.factory.InitializingBean;

import com.godmonth.crud.jpa.dao.CrudDao;
import com.godmonth.crud.jpa.model.LongIdModel;
import com.godmonth.crud.jpa.po.LongIdPo;
import com.godmonth.util.dozer.DozerTransformer;

public class CoffeeServiceImpl<MO extends LongIdModel, PO extends LongIdPo> implements CrudService<MO>,
		InitializingBean {
	private CrudDao<PO> crudDao;
	private Mapper mapper;
	private Transformer transformer;
	private Class<PO> poClass;
	private Class<MO> modelClass;

	@Override
	public void afterPropertiesSet() throws Exception {
		transformer = new DozerTransformer(mapper, modelClass);
	}

	@Override
	public void save(MO t) {
		PO c = mapper.map(t, poClass);
		crudDao.persist(c);
	}

	@Override
	public void delete(Long id) {
		crudDao.delete(id);
	}

	@Override
	public MO get(Long id) {
		PO coffee = crudDao.get(id);
		if (coffee != null) {
			return mapper.map(coffee, modelClass);
		} else {
			return null;
		}
	}

	@Override
	public List<MO> list() {
		List<PO> list = crudDao.list();
		List<MO> coffees = new ArrayList<MO>();
		if (CollectionUtils.isNotEmpty(list)) {
			CollectionUtils.collect(list, transformer, coffees);
		}
		return coffees;
	}
}
