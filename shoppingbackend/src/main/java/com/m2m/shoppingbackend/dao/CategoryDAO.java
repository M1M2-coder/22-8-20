package com.m2m.shoppingbackend.dao;

import java.util.List;

import com.m2m.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

}
