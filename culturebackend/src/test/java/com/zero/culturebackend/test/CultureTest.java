package com.zero.culturebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zero.culturebackend.dao.CategoryDao;
import com.zero.culturebackend.dto.Registered_category;

public class CultureTest {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Registered_category registered_category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.zero.culturebackend");
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	@Test
	public void testAddCategory() {
		
		registered_category = new Registered_category();
		registered_category.setName("Literature");
		registered_category.setDescription("This is description of literature.");
		
		assertEquals("Failed to add registered_category", true, categoryDao.addCategory(registered_category));/*
		assertEquals("Failed to add registered_category", 1, categoryDao.categoryList().size());
		assertEquals("Failed to add registered_category", true, categoryDao.updateCategory(registered_category));
		assertEquals("Failed to add registered_category", true, categoryDao.deleteCategory(registered_category));*/
	}

}
