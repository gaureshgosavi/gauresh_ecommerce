package com.niit.gauresh_backend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.model.Category;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean create(Category category) {
		// if(get(category.getId()) == null){
		// return false;
		// }
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public Category get(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}
