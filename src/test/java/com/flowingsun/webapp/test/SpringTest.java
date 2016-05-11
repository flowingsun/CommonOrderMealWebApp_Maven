package com.flowingsun.webapp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flowingsun.webapp.dao.*;
import com.flowingsun.webapp.domain.*;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring.xml"})
public class SpringTest {

	@Autowired
	private MealMenuDao mealMenuDao;

	@Test
	public void test() {
		// fail("Not yet implemented");
		Assert.assertEquals(1, 1);
		;
	}

	// private static String configLocation =
	// "classpath:src/main/resources/spring.xml";
	private static String configLocation = "classpath:applicationContext.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

	@Test
	public void testBean() {
		Canteen canteen = ctx.getBean(Canteen.class);
		// Canteen canteen = SpringContext.GetContext().getBean(Canteen.class);
		Assert.assertNotNull(canteen);
	}

	@Test
	public void testSP() {
		List<Integer> list = mealMenuDao.GetAvailableMealMenuIds();
		System.out.print(list);
		Assert.assertTrue(!list.isEmpty() && list.size() > 1);
	}
}
