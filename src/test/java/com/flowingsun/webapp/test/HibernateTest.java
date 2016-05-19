package com.flowingsun.webapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flowingsun.webapp.dao.MealMenuDao;
import com.flowingsun.webapp.domain.MealMenu;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-hibernate.xml" })
public class HibernateTest {

	@Autowired
	private MealMenuDao mealMenuDao;

	@Test
	public void testPoToVo() {
		for (int i = 0; i < 20; i++) {//40 times in jam?
			MealMenu mm = mealMenuDao.FindEnityById(1L);
			System.out.println(mm.getMealPackages().size() + "");
		}
		Assert.assertTrue(true);
	}
}
