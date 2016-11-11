package com.niit.gauresh_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.model.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Product Product;
	
	@Autowired
	static ProductDAO ProductDAO;
	
	@BeforeClass
	public static void init() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.gauresh_backend");
		context.refresh();
		
		Product = (Product)context.getBean(Product.class);
		
		ProductDAO= (ProductDAO)context.getBean(ProductDAO.class);
		
	}
	
	@Test
	public void createProductTestCase() {
		Product.setCategoryId(100);
		Product.setSupplierId(100);
		Product.setName("Accessories");
		Product.setDescription("This is Accessories Product");
		Product.setUnitPrice(25000);
		Product.setQuantity(1);
		Assert.assertEquals("create accessories test case", true, ProductDAO.create(Product));
	}
	
	@Test
	public void updateProductTestCase() {
		Product.setProductId(4);
		Product.setDescription("This is instrumental Product");
		
	    Assert.assertEquals("Update Product test case", true, ProductDAO.update(Product));
	}
	
	@Test
	public void deleteProductTestCase() {
		Product.setProductId(4);
		
		Assert.assertEquals("Delete Product test case", true, ProductDAO.delete(Product));
	}
	
	@Test
	public void getProductTestCase() {
		
		Assert.assertEquals("Get Product test case", null, ProductDAO.get(8));
	}
	
	@Test
	public void getAllProductTestCase() {
		
		Assert.assertEquals("Get all Product test case", null, ProductDAO.list().size());
	}

}
