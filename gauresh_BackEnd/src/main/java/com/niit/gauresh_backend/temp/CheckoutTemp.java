package com.niit.gauresh_backend.temp;

import java.io.Serializable;

import com.niit.gauresh_backend.model.BillingAddress;
import com.niit.gauresh_backend.model.Cart;
import com.niit.gauresh_backend.model.CartItem;
import com.niit.gauresh_backend.model.OrderDetails;
import com.niit.gauresh_backend.model.PaymentDetails;
import com.niit.gauresh_backend.model.ShippingAddress;
import com.niit.gauresh_backend.model.User;

public class CheckoutTemp  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ShippingAddress shippingAddress;
	private BillingAddress billingAddress;
	private PaymentDetails paymentDetails;
	private OrderDetails orderDetails;
	private Cart cart;
	private CartItem cartItem;
	private User user;
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


}
