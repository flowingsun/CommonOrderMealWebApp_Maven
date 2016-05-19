package com.flowingsun.webapp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SpringTest.class, HibernateTest.class })
public class AllTests {

}
