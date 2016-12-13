package com.niit.gauresh_backend.dao;

import java.util.List;

import com.niit.gauresh_backend.model.Cart;
import com.niit.gauresh_backend.model.CartItem;

public interface CartItemDAO {

	public boolean saveOrUpdate(CartItem cartItem);
	
	public boolean updateCart(Cart cart); 

	public boolean delete(CartItem cartItem);

	public CartItem getCartItem(int cartItemId);
	
	public List<CartItem> listCartItems(int cartId);
	
}
