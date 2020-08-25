package com.m2m.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.m2m.shoppingbackend.dao.CategoryDAO;
import com.m2m.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.m2m.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("Here all what you want to know about Mobiles");
		category.setImageURL("Cat_2.png");
		
		/* Test add first category. */
		assertEquals("Failed To Add A New Category", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Here all what you want to know about Laptops");
		category.setImageURL("Cat_3.png");
		//Test add second category.
		assertEquals("Failed To Add A New Category", true, categoryDAO.add(category));
				
		//Test get single category.
		category = categoryDAO.get(1);
		assertEquals("Failed To Get Single Category", "Television", category.getName());
		
		//Test update category.
		category.setName("TVs");
		assertEquals("Failed To Update Existing Category", true, categoryDAO.update(category));
		
		//Test delete category.
		assertEquals("Failed To Delete Existing Category", true, categoryDAO.delete(category));
		
		//Test Retrieve all active categories.
		assertEquals("Failed To Retreive All Active Categories", 2, categoryDAO.list().size());
	}

}
