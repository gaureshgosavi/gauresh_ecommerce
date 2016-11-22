package com.niit.gauresh_emusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Category;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.Supplier;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private Product product;
	
	@RequestMapping("/all")
	public ModelAndView getAll(){
		ModelAndView model= new ModelAndView("page");
		model.addObject("category", category);
		model.addObject("categoryList", categoryDAO.list());
		model.addObject("product", product);
		model.addObject("productList", productDAO.list());
		model.addObject("supplier", supplier);
		model.addObject("supplierList", supplierDAO.list());
		model.addObject("ifUserClickedAdmin",true);
		return model;
	}
	
}
