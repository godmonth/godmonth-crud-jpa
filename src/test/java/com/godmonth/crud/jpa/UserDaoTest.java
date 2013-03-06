package com.godmonth.crud.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import com.godmonth.crud.jpa.dao.CrudDao;

@ContextConfiguration({ "classpath:/test-dao.xml", "classpath*:/test-env.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private CrudDao<User123> userDao;

	@Test
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
	public void getNull() {
		User123 user123 = userDao.get(331l);
	}

}
