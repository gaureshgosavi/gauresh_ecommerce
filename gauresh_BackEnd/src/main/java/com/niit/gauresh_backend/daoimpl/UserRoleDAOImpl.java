package com.niit.gauresh_backend.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.UserRoleDAO;
import com.niit.gauresh_backend.model.UserRole;

@Repository("userRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserRoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdate(UserRole userRole) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userRole);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
