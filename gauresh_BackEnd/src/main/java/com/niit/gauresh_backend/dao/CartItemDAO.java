package com.niit.gauresh_backend.dao;

import java.util.List;

import com.niit.gauresh_backend.model.CartItem;

public interface CartItemDAO {

	public boolean saveOrUpdate(CartItem cartItem);

	public boolean delete(int cartItemId);

	public CartItem getCartItem(int cartItemId);
	
	public List<CartItem> listCartItems(int cartId);
	
}
