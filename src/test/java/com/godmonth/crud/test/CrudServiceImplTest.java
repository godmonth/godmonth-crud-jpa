package com.godmonth.crud.test;

import javax.annotation.Resource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.godmonth.crud.service.CrudService;

@ContextConfiguration({ "classpath:/test-dao.xml", "classpath*:/test-env.xml" })
public class CrudServiceImplTest extends AbstractTestNGSpringContextTests {
	@Resource(name = "userService")
	private CrudService<UserModel> userService;

	@Test
	public void f() {
		UserModel um = new UserModel();
		um.setName("a");
		userService.save(um);

		UserModel um2 = new UserModel();
		um2.setName("a");
		try {
			userService.save(um2);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		}

	}
}
