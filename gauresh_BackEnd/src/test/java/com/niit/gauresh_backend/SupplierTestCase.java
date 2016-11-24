package com.niit.gauresh_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Supplier Supplier;

	@Autowired
	static SupplierDAO SupplierDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.gauresh_backend");
		context.refresh();

		Supplier = (Supplier) context.getBean(Supplier.class);

		SupplierDAO = (SupplierDAO) context.getBean(SupplierDAO.class);

	}

	@Test
	public void createSupplierTestCase() {
		// Supplier.setId(100);
		Supplier.setName("Accessories");
		Supplier.setEmail("This is Accessories Supplier");
		Supplier.setContactNo("");
		
		Assert.assertEquals("create accessories test case", true, SupplierDAO.create(Supplier));
	}

	@Test
	public void updateSupplierTestCase() {
		Supplier.setId(2);
		Supplier.setEmail("This is instrumental Supplier");

		Assert.assertEquals("Update Supplier test case", true, SupplierDAO.saveOrUpdate(Supplier));
	}

	@Test
	public void deleteSupplierTestCase() {
		Supplier.setId(4);

		Assert.assertEquals("Delete Supplier test case", true, SupplierDAO.delete(Supplier));
	}

	@Test
	public void getSupplierTestCase() {

		Assert.assertEquals("Get Supplier test case", null, SupplierDAO.get(2));
	}

	@Test
	public void getAllSupplierTestCase() {

		Assert.assertEquals("Get all Supplier test case", null, SupplierDAO.list().size());
	}

}
