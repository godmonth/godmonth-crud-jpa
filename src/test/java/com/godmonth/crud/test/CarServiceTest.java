package com.godmonth.crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration({ "classpath:/test-dao.xml", "classpath*:/test-env.xml" })
public class CarServiceTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private CarService carService;

	@Test
	public void test() {
		carService.save();
		carService.get();
	}
}
