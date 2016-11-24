package com.niit.gauresh_backend.dao;

import java.util.List;

import com.niit.gauresh_backend.model.Category;

public interface CategoryDAO {

	public boolean create(Category category);

	public boolean saveOrUpdate(Category category);

	public boolean delete(Category category);

	public Category get(int id);

	public List<Category> list();

}
