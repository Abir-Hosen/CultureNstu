package com.zero.culturebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zero.culturebackend.dao.RegisteredDao;
import com.zero.culturebackend.dto.Registered;

public class RegisteredTest {
	
	private static AnnotationConfigApplicationContext context;
	private static RegisteredDao registeredDao;
	private Registered registered;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.zero.culturebackend");
		context.refresh();
		
		registeredDao = (RegisteredDao) context.getBean("registeredDao");
	}

	@Test
	public void testAddCategory() {
		
		registered = registeredDao.getByEmail("abir71.hosen@gmail.com");
		registered.setName("Abir Hosen");
		registered.setEmail("abir040995,hosen@gmail.com");
		registered.setPassword("12345");
		registered.setCategory(9);
		
		
		assertEquals("Failed to add registered", true, registeredDao.updateRegistered(registered));/*
		assertEquals("Failed to add registered", 1, registeredDao.registeredList().size());
		assertEquals("Failed to add registered", true, registeredDao.updateRegistered(registered));
		assertEquals("Failed to add registered", true, registeredDao.deleteRegistered(registered));*/
	}

}
