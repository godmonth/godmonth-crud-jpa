package com.godmonth.crud.test;

import org.springframework.transaction.annotation.Transactional;

import com.godmonth.crud.jpa.dao.CrudDao;

public class CarService {
	private CrudDao<Car> carDao;
	private CrudDao<User123> userDao;

	@Transactional(readOnly = true)
	public void get() {
		System.out.println(carDao.get(1l));
	}

	@Transactional
	public void save() {
		User123 u = new User123();
		u.setName("f12341ff");
		userDao.persist(u);

		User123 u2 = new User123();
		u2.setName("ffwerqf");
		userDao.persist(u2);
		Car car = new Car();
		car.setUser123(u2);
		carDao.merge(car);

	}

	public void setCarDao(CrudDao<Car> carDao) {
		this.carDao = carDao;
	}

	public void setUserDao(CrudDao<User123> userDao) {
		this.userDao = userDao;
	}

}
