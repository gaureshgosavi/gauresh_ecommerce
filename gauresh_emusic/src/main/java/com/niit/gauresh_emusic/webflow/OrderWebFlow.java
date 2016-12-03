package com.niit.gauresh_emusic.webflow;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.gauresh_backend.dao.BillingAddressDAO;
import com.niit.gauresh_backend.dao.OrderDetailsDAO;
import com.niit.gauresh_backend.dao.PaymentDetailsDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.ShippingAddressDAO;
import com.niit.gauresh_backend.dao.UserDAO;
import com.niit.gauresh_backend.model.BillingAddress;
import com.niit.gauresh_backend.model.OrderDetails;
import com.niit.gauresh_backend.model.PaymentDetails;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.ShippingAddress;
import com.niit.gauresh_backend.model.User;

@Component
public class OrderWebFlow {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ShippingAddress shippingAddress;

	@Autowired
	private BillingAddress billingAddress;

	@Autowired
	private OrderDetails orderDetails;
	
	@Autowired
	private ShippingAddressDAO shippingAddressDAO;

	@Autowired
	private BillingAddressDAO billingAddressDAO;
	
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	Product product;
	
	@Autowired
	PaymentDetails paymentDetails;
	
	@Autowired
	PaymentDetailsDAO paymentDetailsDAO;

}
