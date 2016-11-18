package com.niit.gauresh_emusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.model.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/{id}")
	public @ResponseBody Category getProductById(@PathVariable("id") int id) {
		
		Category c= categoryDAO.get(id);
		return c;
	}
	@RequestMapping("/list")
	public @ResponseBody List<Category> getAllProducts() {
		
		Category c= (Category) categoryDAO.list();
		return (List<Category>) c;
	}
}
