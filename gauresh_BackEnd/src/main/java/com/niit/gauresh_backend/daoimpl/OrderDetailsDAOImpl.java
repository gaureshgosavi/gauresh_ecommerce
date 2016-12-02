package com.niit.gauresh_backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.OrderDetailsDAO;
import com.niit.gauresh_backend.model.OrderDetails;

@Repository("orderDetailsDAO")
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public OrderDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdate(OrderDetails orderDetails) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(orderDetails);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
	
}
