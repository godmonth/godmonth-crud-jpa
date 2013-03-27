package com.godmonth.crud.test;

import com.godmonth.crud.model.LongIdModel;

public class UserModel extends LongIdModel {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
