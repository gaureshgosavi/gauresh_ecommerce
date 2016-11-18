package com.niit.gauresh_emusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		
		Product p= productDAO.get(id);
		return p;
	}
}
