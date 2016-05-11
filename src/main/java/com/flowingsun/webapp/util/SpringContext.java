package com.flowingsun.webapp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

	//private static ApplicationContext context;
	private static String configLocation = "classpath:spring.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		context = applicationContext;
//	}
	public static ApplicationContext GetContext(){
		//return context;
		return ctx;
	}

}
