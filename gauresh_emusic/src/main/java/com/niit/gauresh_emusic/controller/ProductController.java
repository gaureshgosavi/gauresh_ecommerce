package com.niit.gauresh_emusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Category;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.Supplier;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@RequestMapping("/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		
		Product p= productDAO.get(id);
		return p;
	}
	
	@RequestMapping("/all")
	public @ResponseBody List<Product> getAllProduct(){
		List<Product> productList= productDAO.list();
		return productList;
	}
	
	@RequestMapping("/productDetail/{productId}")
	public ModelAndView productDetail(@PathVariable int productId, Model model){
		
		ModelAndView mv = new ModelAndView("/page");
		product = productDAO.get(productId);
		mv.addObject("product", product);
		category = categoryDAO.get(product.getCategoryId());
		mv.addObject("category", category);
		supplier = supplierDAO.get(product.getSupplierId());
		mv.addObject("supplier", supplier);
		mv.addObject("ifUserClickedProductDetails", true);
		return mv;
	}
	
	@RequestMapping("/productList/{categoryId}")
	public ModelAndView productList(@PathVariable int categoryId, Model model){
		ModelAndView mv = new ModelAndView("/page");
		List<Product> productList= productDAO.getByCategoryId(categoryId);
		mv.addObject("productList", productList);
		mv.addObject("ifUserSelectProductList", true);
		return mv;
	}
}
