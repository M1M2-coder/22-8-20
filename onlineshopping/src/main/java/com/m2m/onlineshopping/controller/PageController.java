package com.m2m.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.m2m.onlineshopping.exceptions.ProductNotFoundException;
import com.m2m.shoppingbackend.dao.CategoryDAO;
import com.m2m.shoppingbackend.dao.ProductDAO;
import com.m2m.shoppingbackend.dto.Category;
import com.m2m.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("INSIDE PAGE CONTROLLER INDEX METHOD - INFO");
		logger.debug("INSIDE PAGE CONTROLLER INDEX METHOD - DEBUG");
		
		mv.addObject("title", "Home");
		mv.addObject("userClicksHome",true);
		
		mv.addObject("categories", categoryDAO.list());
		
		
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClicksAboutUs", true);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClicksContactUs", true);
		
		
		return mv;
	}
	
	/*
	 * View Products.
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClicksShowAllProducts", true);
		
		
		return mv;
	}
	/*
	 * View Category Products.
	 */
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		// Get the category.
		Category category = null;
		category = categoryDAO.get(id);
		//----------------------------------------
		
		mv.addObject("title", category.getName());
		mv.addObject("category", category);
		mv.addObject("categoryName",category.getName().toUpperCase());
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClicksShowCategoryProducts", true);
		
		return mv;
	}
	
	/*
	 * Show Single Product
	 * */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		
		// Update View Product.
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//------------------------------------------
		
		mv.addObject("title", product.getName());
		
		mv.addObject("product", product);
		mv.addObject("userClicksShowProduct", true);
		
		return mv;
	}
		
	
}
