package com.niit.gauresh_backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.PaymentDetailsDAO;
import com.niit.gauresh_backend.model.PaymentDetails;

@Repository("PaymentDetailsDAO")
public class PaymentDetailsDAOImpl implements PaymentDetailsDAO{

	@Autowired
	SessionFactory sessionFactory;

	public PaymentDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdate(PaymentDetails paymentDetails) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(paymentDetails);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
	
}
	

