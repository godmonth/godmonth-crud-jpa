package com.godmonth.crud.test;

import org.springframework.transaction.annotation.Transactional;

public class CarService {
	private CarDao carDao;
	private UserDao userDao;

	@Transactional(readOnly = true)
	public void get() {
		System.out.println(carDao.get(1l));
	}

	@Transactional
	public void save() {
		User123 u = new User123();
		u.setName("fff");
		userDao.persist(u);

		User123 u2 = new User123();
		u2.setName("eee");
		userDao.persist(u2);
		Car car = new Car();
		car.setUser123(u2);
		carDao.merge(car);

	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
