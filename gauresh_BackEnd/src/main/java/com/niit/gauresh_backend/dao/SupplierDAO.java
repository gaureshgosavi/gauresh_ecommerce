package com.niit.gauresh_backend.dao;

import java.util.List;

import com.niit.gauresh_backend.model.Supplier;

public interface SupplierDAO {

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(Supplier supplier);

	public Supplier get(Supplier id);

	public List<Supplier> list();

}
