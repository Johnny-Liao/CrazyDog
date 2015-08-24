package org.crazydog.utils;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelper{
	
	public static String path="CrazyDog/src/main/resources/application-config.xml";
	public static ApplicationContext context= new ClassPathXmlApplicationContext(path);
}