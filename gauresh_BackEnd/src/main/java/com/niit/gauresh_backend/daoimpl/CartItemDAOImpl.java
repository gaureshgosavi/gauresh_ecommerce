package com.niit.gauresh_backend.daoimpl;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.CartItemDAO;
import com.niit.gauresh_backend.model.Cart;
import com.niit.gauresh_backend.model.CartItem;

@Repository("CartItemDAO")
public class CartItemDAOImpl implements CartItemDAO{

	@Autowired
	SessionFactory sessionFactory;

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public boolean saveOrUpdate(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}
	
	@Override
	@Transactional
	public boolean delete(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			//sessionFactory.getCurrentSession().flush();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
	
	@Override
	@Transactional
	public List<CartItem> listCartItems(int cartId) {
		String hql = "FROM CartItem WHERE cart_id = :cartId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cartId", cartId);
		List<CartItem> cartItems = query.getResultList();
		return cartItems;
	}
	
	@Override
	@Transactional
	public CartItem getCartItem(int cartItemId) {
		return (CartItem) sessionFactory.getCurrentSession().get(CartItem.class, cartItemId);
	}

	@Override
	@Transactional
	public boolean updateCart(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
		return false;
	}
	
}
