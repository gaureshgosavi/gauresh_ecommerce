package com.niit.gauresh_backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Supplier;
import com.niit.gauresh_backend.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean create(Supplier Supplier) {
		// if(get(Supplier.getId()) == null){
		// return false;
		// }
		try {
			sessionFactory.getCurrentSession().save(Supplier);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean update(Supplier Supplier) {
		try {
			sessionFactory.getCurrentSession().update(Supplier);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean delete(Supplier Supplier) {
		try {
			sessionFactory.getCurrentSession().delete(Supplier);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public Supplier get(int id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	
}
