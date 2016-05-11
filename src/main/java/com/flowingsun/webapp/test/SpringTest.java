package com.flowingsun.webapp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flowingsun.webapp.dao.MealMenuDao;
import com.flowingsun.webapp.domain.Canteen;

import junit.framework.Assert;

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
		Assert.assertTrue(!list.isEmpty() && list.size() > 1);
	}
}
