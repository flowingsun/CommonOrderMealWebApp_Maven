package com.flowingsun.webapp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flowingsun.webapp.dao.*;
import com.flowingsun.webapp.domain.*;
import com.flowingsun.webapp.util.SpringContextUtil;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-hibernate.xml" })
public class SpringTest {

	@Autowired
	private MealMenuDao mealMenuDao;

	//@Qualifier("canteen")
	@Autowired
	Canteen _canteen;

	@Test
	public void test() {
		// fail("Not yet implemented");
		Assert.assertEquals(1, 1);
		;
	}

	// private static String configLocation =
	// "classpath:src/main/resources/spring.xml";
	// private static String configLocation =
	// "classpath:applicationContext.xml";
	// private static ApplicationContext ctx = new
	// ClassPathXmlApplicationContext(configLocation);

	@Test
	public void testBean() {
		// Canteen canteen = ctx.getBean(Canteen.class);
		// // Canteen canteen =
		// SpringContext.GetContext().getBean(Canteen.class);
		// Assert.assertNotNull(canteen);

		// ApplicationContext ac = new FileSystemXmlApplicationContext();
		// Canteen canteen = ac.getBean(Canteen.class);
		// Assert.assertNotNull(canteen);

		// Assert.assertNotNull(SpringContextUtil.getBean("sessionFactory"));// ----error
		Assert.assertNotNull(_canteen);
	}

	@Test
	public void testSP() {
		List<Integer> list = mealMenuDao.GetAvailableMealMenuIds();
		System.out.print(list);
		Assert.assertTrue(!list.isEmpty() && list.size() > 1);
	}
	
	@Test
	public void testMealMenus() {
		List<MealMenu> list = mealMenuDao.GetAvailableMealMenus();
		for(MealMenu mm : list){
			System.out.println(mm.getMenuName());
		}
		Assert.assertTrue(!list.isEmpty() && list.size() > 1);
	}
	
	@Test
	public void testPoToVo(){
		MealMenu mm = mealMenuDao.FindEnityById(1L);
		System.out.println(mm.getMealPackages().size()+"");
		Assert.assertTrue(true);
	}
}
