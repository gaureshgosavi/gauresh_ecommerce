package com.niit.gauresh_emusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Supplier;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("/{id}")
	public @ResponseBody Supplier getProductById(@PathVariable("id") int id) {
		
		Supplier s= supplierDAO.get(id);
		return s;
	}
	
	@RequestMapping("/all")
	public @ResponseBody List<Supplier> getAllSupplier(){
		List<Supplier> suppList= supplierDAO.list();
		return suppList;
	}
}
