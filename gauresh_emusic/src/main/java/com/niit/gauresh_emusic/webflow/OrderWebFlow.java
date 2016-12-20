package com.niit.gauresh_emusic.webflow;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.gauresh_backend.dao.BillingAddressDAO;
import com.niit.gauresh_backend.dao.CartItemDAO;
import com.niit.gauresh_backend.dao.OrderDetailsDAO;
import com.niit.gauresh_backend.dao.OrderItemsDAO;
import com.niit.gauresh_backend.dao.PaymentDetailsDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.ShippingAddressDAO;
import com.niit.gauresh_backend.dao.UserDAO;
import com.niit.gauresh_backend.model.BillingAddress;
import com.niit.gauresh_backend.model.Cart;
import com.niit.gauresh_backend.model.CartItem;
import com.niit.gauresh_backend.model.OrderDetails;
import com.niit.gauresh_backend.model.OrderItems;
import com.niit.gauresh_backend.model.PaymentDetails;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.ShippingAddress;
import com.niit.gauresh_backend.model.User;
import com.niit.gauresh_backend.temp.CheckoutTemp;

@Component
public class OrderWebFlow {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderDetails orderDetails;

	@Autowired
	private ShippingAddressDAO shippingAddressDAO;

	@Autowired
	private BillingAddressDAO billingAddressDAO;

	@Autowired
	private OrderDetailsDAO orderDetailsDAO;


	@Autowired
	private UserDAO userDAO;


	@Autowired
	private OrderItemsDAO orderItemsDAO;

	@Autowired
	private CartItemDAO cartItemDAO;

	@Autowired
	private HttpSession session;

	CheckoutTemp checkoutTemp = null;

	public CheckoutTemp initFlow() {
		checkoutTemp = new CheckoutTemp();
		User user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		Cart cart = user.getCart();
		checkoutTemp.setUser(user);
		checkoutTemp.setCart(cart);
		return checkoutTemp;
	}

	public String addShippingAddress(CheckoutTemp checkoutTemp, ShippingAddress shippingAddress) {
		System.out.println(shippingAddress.toString());
		shippingAddress.setUserId(checkoutTemp.getUser().getUserId());
		checkoutTemp.setShippingAddress(shippingAddress);
		return "success";
	}

	public String addBillingAddress(CheckoutTemp checkoutTemp, BillingAddress billingAddress) {
		System.out.println(billingAddress.toString());
		billingAddress.setUserId(checkoutTemp.getUser().getUserId());
		checkoutTemp.setBillingAddress(billingAddress);
		return "success";
	}

	public String addPaymentMethod(CheckoutTemp checkoutTemp) {
		/*System.out.println(paymentDetails.toString());
		user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user.toString());
		paymentDetails.setUserId(user.getUserId());
		checkoutTemp.setPaymentDetails(paymentDetails);*/
		addOrderDetails(checkoutTemp);
		return "success";
	}

	public String addOrderDetails(CheckoutTemp checkoutTemp) {
		
		System.out.println(orderDetails.toString());
		User user = checkoutTemp.getUser();
		System.out.println(user.toString());
		Cart cart = user.getCart();
		
		shippingAddressDAO.saveOrUpdate(checkoutTemp.getShippingAddress());
		billingAddressDAO.saveOrUpdate(checkoutTemp.getBillingAddress());
		//paymentDetailsDAO.saveOrUpdate(checkoutTemp.getPaymentDetails());
		
		orderDetails.setShippingId(checkoutTemp.getShippingAddress().getShippingAddressId());
		orderDetails.setBillingId(checkoutTemp.getBillingAddress().getBillingAddressId());
		//orderDetails.setPaymentId(paymentDetails.getPaymentId());
		orderDetails.setUserId(user.getUserId());
		orderDetails.setGrandTotal(cart.getGrandTotal());
		orderDetails.setNoOfItems(cart.getNoOfProducts());
		orderDetailsDAO.saveOrUpdate(orderDetails);
		
		cart.setGrandTotal(0);
		cart.setNoOfProducts(0);
		cartItemDAO.updateCart(cart);
		session.setAttribute("noOfCartItems", 0);

		Product product = null;
		
		List<CartItem> CartItems = cartItemDAO.listCartItems(cart.getCartId());
		List<OrderItems> Items = new ArrayList<>();
		for (CartItem item : CartItems) {

			product = item.getProduct();
			System.out.println(product.toString());
			product.setQuantity(product.getQuantity() - item.getQuantity());
			productDAO.saveOrUpdate(product);

			if (product.getQuantity() <= 0) {
				product = productDAO.get(item.getProduct().getProductId());
				product.setQuantity(0);
				productDAO.saveOrUpdate(product);
			}

			OrderItems orderItems = new OrderItems();
			orderItems.setUserId(user.getUserId());
			orderItems.setProductName(item.getProduct().getName());
			orderItems.setProductId(item.getProduct().getProductId());
			orderItems.setUnitPrice(item.getProduct().getUnitPrice());
			orderItems.setQuantity(item.getQuantity());
			orderItems.setOrderDetails(orderDetails);
			orderItems.setTotalPrice(item.getTotalPrice());
			product = productDAO.get(item.getProduct().getProductId());
			int q = product.getStock();
			q += item.getQuantity();
			product.setStock(q);
			productDAO.saveOrUpdate(product);
			orderItemsDAO.saveOrUpdate(orderItems);
			Items.add(orderItems);
			cartItemDAO.delete(item);
		}
		
		orderDetails.setOrderItems(Items);
		checkoutTemp.setOrderDetails(orderDetails);
		/*cart.setGrandTotal(0);
		cart.setNoOfProducts(0);
		cartItemDAO.updateCart(cart);
		session.setAttribute("noOfCartItems", 0);*/
		return "success";
	}

}
