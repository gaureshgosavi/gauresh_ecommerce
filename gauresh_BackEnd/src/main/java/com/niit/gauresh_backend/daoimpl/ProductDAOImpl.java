package com.niit.gauresh_backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

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
	public boolean saveOrUpdate(Product Product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(Product);
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

	@Override
	@Transactional
	public List<Product> getSimilarProducts(String searchText) {
		String hql = "from Product where name like %" + searchText + "%";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	@Transactional
	public List<Product> getByCategoryId(int categoryId) {
		String hql = "from Product where category_id=" + categoryId;
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	@Transactional
	public List<Product> getLatestProducts(int n) {
		String hql = "FROM Product ORDER BY productId DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(n);
		return query.list();
	}

	@Override
	@Transactional
	public List<Product> getTopProduct(int n) {
		String hql = "FROM Product ORDER BY stock DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(n);
		return query.list();
	}

}
