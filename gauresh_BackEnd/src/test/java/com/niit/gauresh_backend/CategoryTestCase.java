package com.niit.gauresh_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
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
	
	@BeforeClass
	public static void init() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.gauresh_backend");
		context.refresh();
		
		category = (Category)context.getBean(Category.class);
		
		categoryDAO= (CategoryDAO)context.getBean(CategoryDAO.class);
		
	}
	
	@Test
	public void createCategoryTestCase() {
		//category.setId(100);
		category.setName("Accessories");
		category.setDescription("This is Accessories category");
				Assert.assertEquals("create accessories test case", true, categoryDAO.create(category));
	}
	
	@Test
	public void updateCategoryTestCase() {
		category.setId(4);
		category.setDescription("This is instrumental category");
		
	Assert.assertEquals("Update category test case", true, categoryDAO.saveOrUpdate(category));
	}
	
	@Test
	public void deleteCategoryTestCase() {
		category.setId(4);
		
		Assert.assertEquals("Delete category test case", true, categoryDAO.delete(category));
	}
	
	@Test
	public void getCategoryTestCase() {
		
		Assert.assertEquals("Get category test case", null, categoryDAO.get(8));
	}
	
	@Test
	public void getAllCategoryTestCase() {
		
		Assert.assertEquals("Get all category test case", null, categoryDAO.list().size());
	}

}
