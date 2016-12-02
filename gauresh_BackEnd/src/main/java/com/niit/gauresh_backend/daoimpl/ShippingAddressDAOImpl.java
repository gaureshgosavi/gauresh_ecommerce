package com.niit.gauresh_backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.ShippingAddressDAO;
import com.niit.gauresh_backend.model.ShippingAddress;

@Repository("shippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public ShippingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdate(ShippingAddress shippingAddress) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

}
