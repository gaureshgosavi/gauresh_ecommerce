package com.niit.gauresh_emusic.webflow;

import java.security.Principal;
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
	private User user;

	@Autowired
	private Cart cart;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private Product product;

	@Autowired
	private PaymentDetails paymentDetails;

	@Autowired
	private PaymentDetailsDAO paymentDetailsDAO;

	@Autowired
	private OrderItemsDAO orderItemsDAO;

	@Autowired
	private CartItemDAO cartItemDAO;

	@Autowired
	private HttpSession session;

	CheckoutTemp checkoutTemp = new CheckoutTemp();

	public CheckoutTemp initFlow() {
		user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		cart = user.getCart();
		checkoutTemp.setUser(user);
		checkoutTemp.setCart(cart);
		return checkoutTemp;
	}

	public String addShippingAddress(CheckoutTemp checkoutTemp, ShippingAddress shippingAddress) {
		System.out.println(shippingAddress.toString());
		user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user.toString());
		shippingAddress.setUserId(user.getUserId());
		checkoutTemp.setShippingAddress(shippingAddress);
		return "success";
	}

	public String addBillingAddress(CheckoutTemp checkoutTemp, BillingAddress billingAddress) {
		System.out.println(billingAddress.toString());
		user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user.toString());
		billingAddress.setUserId(user.getUserId());
		checkoutTemp.setBillingAddress(billingAddress);
		return "success";
	}

	public String paymentDetails(CheckoutTemp checkoutTemp, PaymentDetails paymentDetails) {
		System.out.println(paymentDetails.toString());
		user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user.toString());
		paymentDetails.setUserId(user.getUserId());
		checkoutTemp.setPaymentDetails(paymentDetails);
		return "success";
	}

	public String orderDetails(CheckoutTemp checkoutTemp, OrderDetails orderDetails) {
		
		System.out.println(orderDetails.toString());
		user = userDAO.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user.toString());
		cart = user.getCart();
		
		shippingAddressDAO.saveOrUpdate(checkoutTemp.getShippingAddress());
		billingAddressDAO.saveOrUpdate(checkoutTemp.getBillingAddress());
		paymentDetailsDAO.saveOrUpdate(checkoutTemp.getPaymentDetails());
		
		orderDetails.setShippingId(shippingAddress.getShippingAddressId());
		orderDetails.setBillingId(billingAddress.getBillingAddressId());
		orderDetails.setPaymentId(paymentDetails.getPaymentId());
		orderDetails.setUserId(user.getUserId());
		orderDetails.setGrandTotal(cart.getGrandTotal());
		orderDetails.setNoOfItems(cart.getNoOfProducts());
		orderDetailsDAO.saveOrUpdate(orderDetails);

		List<CartItem> CartItems = cartItemDAO.listCartItems(cart.getCartId());

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
			orderItems.setQuantity(item.getQuantity());
			orderItems.setTotalPrice(item.getTotalPrice());
			product = productDAO.get(item.getProduct().getProductId());
			int q = product.getCount();
			q += item.getQuantity();
			product.setCount(q);
			productDAO.saveOrUpdate(product);
			orderItemsDAO.saveOrUpdate(orderItems);
			cartItemDAO.delete(item);
		}
		cart.setGrandTotal(0);
		cart.setNoOfProducts(0);
		cartItemDAO.updateCart(cart);
		session.setAttribute("noOfCartItems", cart.getNoOfProducts());
		return "success";
	}

	public String orderReceipt() {
		return "success";
	}

}
