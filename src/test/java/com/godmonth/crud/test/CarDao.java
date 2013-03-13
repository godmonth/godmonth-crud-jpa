package com.godmonth.crud.test;

import com.godmonth.crud.jpa.dao.CrudDaoImpl;

public class CarDao extends CrudDaoImpl<Car> {
	{
		setPoClass(Car.class);
	}
}
