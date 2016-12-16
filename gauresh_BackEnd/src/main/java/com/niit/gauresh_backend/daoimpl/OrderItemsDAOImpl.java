package com.niit.gauresh_backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.OrderItemsDAO;
import com.niit.gauresh_backend.model.OrderItems;

@Repository("orderItemsDAO")
public class OrderItemsDAOImpl implements OrderItemsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public OrderItemsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(OrderItems orderItems) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(OrderItems orderItem) {
		
		try {
			sessionFactory.getCurrentSession().delete(orderItem);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
