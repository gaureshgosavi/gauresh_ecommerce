package com.niit.gauresh_backend.dao;

import java.util.List;

import com.niit.gauresh_backend.model.Product;

public interface ProductDAO {
	
	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public Product get(Product id);

	public List<Product> list();

}
