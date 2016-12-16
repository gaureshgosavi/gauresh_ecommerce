package com.niit.gauresh_backend.dao;

import com.niit.gauresh_backend.model.OrderItems;

public interface OrderItemsDAO {
	public boolean saveOrUpdate(OrderItems orderItems);
	
	public boolean delete(OrderItems orderedItem);
	
}
