package com.m2m.shoppingbackend.dao;

import java.util.List;

import com.m2m.shoppingbackend.dto.Product;


public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Business Methods.
	
	List<Product> listAllActiveProducts();
	List<Product> listAllActiveProductsByCatgory(int categoryId);
	List<Product> listLatestActiveProduct(int count);
}
