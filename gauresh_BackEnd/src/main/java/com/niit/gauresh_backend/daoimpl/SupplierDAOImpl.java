package com.niit.gauresh_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		
	}

	@Override
	@Transactional
	public boolean save(Supplier supplier) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplier get(Supplier id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
