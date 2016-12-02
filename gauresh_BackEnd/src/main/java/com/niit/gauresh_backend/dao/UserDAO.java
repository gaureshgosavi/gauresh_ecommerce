package com.niit.gauresh_backend.dao;

import com.niit.gauresh_backend.model.User;

public interface UserDAO {

	public Boolean saveOrUpdate(User user);

	public Boolean delete(int userId);
	
	public User getByUsername(String username);
	
	public User getById(int userId);
	
}
