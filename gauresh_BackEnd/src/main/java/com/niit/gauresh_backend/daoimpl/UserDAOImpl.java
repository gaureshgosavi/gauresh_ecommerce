package com.niit.gauresh_backend.daoimpl;



import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.UserDAO;
import com.niit.gauresh_backend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdate(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		
/*		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
*/	}

	@Override
	@Transactional
	public Boolean delete(int userId) {
		try {
			sessionFactory.getCurrentSession().delete(userId);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	@Transactional
	public User getByUsername(String username) {
		
		String hql="FROM User WHERE username = :username";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("username", username);
		try {
			return (User) query.getSingleResult();	
		}
		catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public User getById(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

}