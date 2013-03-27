package com.godmonth.crud.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import com.godmonth.crud.jpa.dao.CrudDao;

@ContextConfiguration({ "classpath:/test-dao.xml", "classpath*:/test-env.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	@Resource(name = "userDao")
	private CrudDao<User123> userDao;
	@Resource(name = "carDao")
	private CrudDao<Car> carDao;

	@Test(enabled = true)
	public void save() {
		System.out.println(userDao);
		User123 u = new User123();
		u.setName("fff");
		userDao.persist(u);

		User123 u2 = new User123();
		u2.setName("www");
		try {
			userDao.persist(u2);
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		List<User123> list = userDao.list();
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void many() {
		User123 u = new User123();
		u.setName("fff22");
		userDao.persist(u);
		Car car = new Car();
		car.setUser123(u);
		carDao.merge(car);
	}

	@Test(dependsOnMethods = "many")
	public void get() {
		System.out.println(carDao.get(1l));
	}

}
