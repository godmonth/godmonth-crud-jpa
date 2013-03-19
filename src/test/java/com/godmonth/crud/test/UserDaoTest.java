package com.godmonth.crud.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration({ "classpath:/test-dao.xml", "classpath*:/test-env.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CarDao carDao;

	@Test(enabled = true)
	public void save() {
		System.out.println(userDao);
		User123 u = new User123();
		u.setName("fff");
		userDao.persist(u);

		User123 u2 = new User123();
		u2.setName("eee");
		userDao.persist(u2);

		List<User123> list = userDao.list();
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void many() {
		User123 u = new User123();
		u.setName("fff");
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
