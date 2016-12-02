package com.niit.gauresh_backend.dao;

import java.util.List;

import com.niit.gauresh_backend.model.Product;

public interface ProductDAO {
	
	public boolean create(Product product);

	public boolean saveOrUpdate(Product product);

	public boolean delete(Product product);

	public Product get(int id);

	public List<Product> list();
	
	public List<Product> getSimilarProducts(String searchText);

}
