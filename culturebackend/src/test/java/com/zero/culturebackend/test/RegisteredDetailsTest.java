package com.zero.culturebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zero.culturebackend.dao.RegDetailsDao;
import com.zero.culturebackend.dto.Registered_details;

public class RegisteredDetailsTest {
	
	private static AnnotationConfigApplicationContext context;
	private static RegDetailsDao regDetailsDao;
	private Registered_details registered_details;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.zero.culturebackend");
		context.refresh();
		
		regDetailsDao = (RegDetailsDao) context.getBean("regDetailsDao");
	}

	@Test
	public void testAddCategory() {
		
		registered_details = regDetailsDao.getByRegId(22);
		
		registered_details.setAbout("this is about registered!");
		
		
		assertEquals("Failed to add registered", true, regDetailsDao.updateRegDetails(registered_details));/*
		assertEquals("Failed to add registered", 1, registeredDao.registeredList().size());
		assertEquals("Failed to add registered", true, registeredDao.updateRegistered(registered));
		assertEquals("Failed to add registered", true, registeredDao.deleteRegistered(registered));*/
	}


}
