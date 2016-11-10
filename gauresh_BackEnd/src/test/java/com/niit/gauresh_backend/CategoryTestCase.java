package com.niit.gauresh_backend;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Category category;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	public static void init() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.gauresh_backend");
		context.refresh();
		
		category = (Category)context.getBean(Category.class);
		
		categoryDAO= (CategoryDAO)context.getBean(CategoryDAO.class);
	}
	
	@Test
	public void saveCategoryTestCase() {
		
		category.setName("intruments");
		category.setDescription("This is instrument category");
		
		Assert.assertEquals("Save category test case", true, categoryDAO.save(category));
	}

}
