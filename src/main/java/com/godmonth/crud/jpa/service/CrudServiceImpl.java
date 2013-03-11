package com.godmonth.crud.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.dozer.Mapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.godmonth.crud.jpa.dao.CrudDao;
import com.godmonth.crud.jpa.po.LongIdPo;
import com.godmonth.crud.model.LongIdModel;
import com.godmonth.crud.service.CrudService;
import com.godmonth.util.dozer.DozerTransformer;

public class CrudServiceImpl<MO extends LongIdModel, PO extends LongIdPo> implements CrudService<MO>, InitializingBean {
	private CrudDao<PO> crudDao;
	private Mapper mapper;
	private Transformer transformer;
	private Class<MO> modelClass;

	@Override
	public void afterPropertiesSet() throws Exception {
		transformer = new DozerTransformer(mapper, modelClass);
	}

	@Transactional
	@Override
	public MO save(MO t) {
		PO c = mapper.map(t, crudDao.getPoClass());
		crudDao.persist(c);
		return mapper.map(c, modelClass);
	}

	@Transactional
	@Override
	public void save2(MO t) {
		PO c = mapper.map(t, crudDao.getPoClass());
		crudDao.persist(c);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		crudDao.delete(id);
	}

	@Override
	public MO get(Long id) {
		PO po = crudDao.get(id);
		if (po != null) {
			return mapper.map(po, modelClass);
		} else {
			return null;
		}
	}

	@Override
	public List<MO> list() {
		List<PO> list = crudDao.list();
		List<MO> models = new ArrayList<MO>();
		if (CollectionUtils.isNotEmpty(list)) {
			CollectionUtils.collect(list, transformer, models);
		}
		return models;
	}

	@Required
	public void setCrudDao(CrudDao<PO> crudDao) {
		this.crudDao = crudDao;
	}

	@Required
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@Required
	public void setModelClass(Class<MO> modelClass) {
		this.modelClass = modelClass;
	}

}
