package com.godmonth.crud.jpa;

import com.godmonth.crud.jpa.dao.CrudDaoImpl;

public class CarDao extends CrudDaoImpl<Car> {
	{
		setPoClass(Car.class);
	}
}
