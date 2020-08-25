package com.m2m.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.shoppingbackend.dao.ProductDAO;
import com.m2m.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/* 
	 * Get Single Product 
	 * */
	public Product get(int productId) {
		try {
			return sessionFactory
						.getCurrentSession()
							.get(Product.class, Integer.valueOf(productId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/* 
	 * List All Products. 
	 * */
	public List<Product> list() {
		return sessionFactory
					.getCurrentSession()
						.createQuery("FROM Product", Product.class)
							.getResultList();
	}

	/* 
	 * Add A New Product. 
	 * */
	public boolean add(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/* 
	 * Update An Existing Product. 
	 * */
	public boolean update(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	/* 
	 * Delete An Existing Product. 
	 * */
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/* 
	 * Retrieves All Active Products. 
	 * */
	public List<Product> listAllActiveProducts() {
		String activeProductsQuery = "FROM Product WHERE active = :active";
		return sessionFactory	
					.getCurrentSession()
							.createQuery(activeProductsQuery, Product.class)
								.setParameter("active", true)
									.getResultList();
	}
	
	/* 
	 * Retrieves All Active Category Products. 
	 * */
	public List<Product> listAllActiveProductsByCatgory(int categoryId) {
		String activeProductsQuery = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory	
					.getCurrentSession()
							.createQuery(activeProductsQuery, Product.class)
								.setParameter("active", true)
									.setParameter("categoryId", categoryId)
										.getResultList();
	}

	/* 
	 * Retrieves A Specific Number Of Active Products Based On User Count. 
	 * */
	public List<Product> listLatestActiveProduct(int count) {
		return sessionFactory	
				.getCurrentSession()
						.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
							.setParameter("active", true)
								.setFirstResult(0)
									.setMaxResults(count)
										.getResultList();
	}

}
