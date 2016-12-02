package com.niit.gauresh_emusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.model.Product;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	public ModelAndView getProducts(@PathVariable("searchString") String searchString){
		
		List<Product> products= productDAO.getSimilarProducts(searchString);
		ModelAndView mv = new ModelAndView("page");
		if(products.isEmpty())
			mv.addObject("msg", "No products found.");
		else
			mv.addObject("productList", "products");
		return mv;
	}
}
