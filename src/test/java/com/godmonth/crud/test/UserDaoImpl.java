package com.godmonth.crud.test;

import com.godmonth.crud.jpa.dao.CrudDaoImpl;

public class UserDaoImpl extends CrudDaoImpl<User123> {
	{
		setPoClass(User123.class);
	}
}
