package com.niit.gauresh_backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.BillingAddressDAO;
import com.niit.gauresh_backend.model.BillingAddress;

@Repository("billingAddressDAO")
public class BillingAddressDAOImpl implements BillingAddressDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BillingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdate(BillingAddress billingAddress) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
