package com.niit.gauresh_backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean create(Product Product) {
		// if(get(Product.getId()) == null){
		// return false;
		// }
		try {
			sessionFactory.getCurrentSession().save(Product);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean update(Product Product) {
		try {
			sessionFactory.getCurrentSession().update(Product);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean delete(Product Product) {
		try {
			sessionFactory.getCurrentSession().delete(Product);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public Product get(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}


