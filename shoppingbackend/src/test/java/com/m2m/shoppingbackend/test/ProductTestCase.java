package com.m2m.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.m2m.shoppingbackend.dao.ProductDAO;
import com.m2m.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.m2m.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testProductCRUD() {
		
/*		product = new Product();
		
		product.setName("Oppo Selfie SS3");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobiles");
		product.setUnitPrice(34000);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(2);
		assertEquals("Failed To Add A New Product", true, productDAO.add(product));*/
		
		//Test get product
		/*
		 * product = productDAO.get(2); assertEquals("Failed To Get Product",
		 * "Samsung s7",product.getName());
		 * 
		 * product.setName("Samsung Galaxy S7");
		 * assertEquals("Failed To Update Product", true, productDAO.update(product));
		 * 
		 * assertEquals("Failed To Delete Product", true, productDAO.delete(product));
		 */
		
		assertEquals("Failed To Retrieve All Products", 6, productDAO.list().size());
		
	}
	
	
	@Test
	public void testListAllActiveProducts() {
		assertEquals("Faild To Retrieve all active products", 5, productDAO.listAllActiveProducts().size());
	}
	
	@Test
	public void testListAllActiveProductsByCategory() {
		assertEquals("Faild To Retrieve all active products", 3, productDAO.listAllActiveProductsByCatgory(1).size());
		assertEquals("Faild To Retrieve all active products", 2, productDAO.listAllActiveProductsByCatgory(3).size());
	}
	
	
	
	
}
