package com.m2m.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.shoppingbackend.dao.CategoryDAO;
import com.m2m.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
 	* Retrieve all active categories.
 	* */
	public List<Category> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Category WHERE active = :active", Category.class)
						.setParameter("active", true)
							.getResultList();
	}
	
	/*
 	* Get single category.
 	* */
	public Category get(int id) {
		Category category = null;
		try {
			category = sessionFactory
						.getCurrentSession()
							.get(Category.class, Integer.valueOf(id));
			return category;
		} catch (Exception ex) {
			ex.printStackTrace();
			return category;
		}
	}
	
	/*
 	* Add new category.
 	* */
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
 	* Update existing category.
 	* */
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	/*
 	* Delete existing category.
 	* */
	public boolean delete(Category category) {
		try {
			category.setActive(false);
			return this.update(category);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
