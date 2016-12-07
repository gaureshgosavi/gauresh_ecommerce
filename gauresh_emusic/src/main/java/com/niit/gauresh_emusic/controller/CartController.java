package com.niit.gauresh_emusic.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.CartItemDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.UserDAO;
import com.niit.gauresh_backend.model.Cart;
import com.niit.gauresh_backend.model.CartItem;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.User;

@Controller
@RequestMapping("/user/cart")
public class CartController {

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private CartItem cartItem;

	@Autowired
	private CartItemDAO cartItemDAO;

	@RequestMapping("/viewCart")
	public ModelAndView viewCart(Model model, @RequestParam(value = "msg", required = false) String msg,
			Principal principal) {
		ModelAndView mv = new ModelAndView("page");

		if (msg.equals("addfailure")) {
			model.addAttribute("addfailure", "Failed to add the product to the cart.");
		}
		if (msg.equals("removefailure")) {
			model.addAttribute("removefailure", "Failed to remove item from the cart");
		}
		if (msg.equals("out of stock")) {
			model.addAttribute("out of stock",
					"Sorry, Quantity of product you are trying to update is unavailable in our stock");
		}
		
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		Set<CartItem> Items = cart.getCartItem();
		if (Items.size() == 0) {
			mv.addObject("noProduct", "Your cart is empty");
		} else {
			mv.addObject("cartItems", Items);
			mv.addObject("cart", user.getCart());
			mv.addObject("product", cartItem.getProduct());
		}
		mv.addObject("ifUserClickedMyCart", true);
		return mv;
	}

	@RequestMapping("/add/{productId}")
	public String addToCart(@PathVariable("productId") int id) {
		ModelAndView mv = new ModelAndView("page");

		product = productDAO.get(id);
		cart = user.getCart();
		Set<CartItem> Items = cart.getCartItem();
		String msg = null;

		for (CartItem item : Items) {
			if (product.getProductId() == item.getCartItemId()) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				int quantity = cartItem.getQuantity();
				cartItem.setTotalPrice(quantity * product.getUnitPrice());
				boolean flag = cartItemDAO.saveOrUpdate(item);
				if (flag == true) {
					msg = "addsuccess";
				} else {
					msg = "addfailure";
				}
			} else {
				boolean flag = cartItemDAO.saveOrUpdate(item);
				if (flag == true) {
					msg = "addsuccess";
				} else {
					msg = "addfailure";
				}
			}

		}
		for (CartItem item : Items) {
			cart.setGrandTotal(cart.getGrandTotal() + item.getTotalPrice());
		}
		cart.setNoOfProducts(Items.size());
		userDAO.saveOrUpdate(user);
		return "redirect:/user/cart/viewCart?msg=" + msg;

	}

	@RequestMapping("/remove/{cartItemId}")
	public String removeCartItems(@PathVariable("cartItemId") int cartItemId, Model model) {
		ModelAndView mv = new ModelAndView();
		String msg = null;
		Set<CartItem> Items = cart.getCartItem();
		boolean flag = cartItemDAO.delete(cartItemId);
		if (flag == true) {
			cart.setGrandTotal(cart.getCartId() - cartItem.getTotalPrice());
			msg = "removesuccess";
		} else {
			msg = "removefailure";
		}
		for (CartItem item : Items) {
			cart.setGrandTotal(cart.getGrandTotal() + item.getTotalPrice());
		}
		cart.setNoOfProducts(Items.size());
		userDAO.saveOrUpdate(user);
		return "redirect:/user/cart/viewCart?msg=" + msg;
	}

	@RequestMapping("/remove/all")
	public String removeAllItems() {
		Set<CartItem> Items = cart.getCartItem();
		for (CartItem item : Items) {
			cartItemDAO.delete(item.getCartItemId());
		}
		cart.setGrandTotal(0);
		cart.setNoOfProducts(0);
		userDAO.saveOrUpdate(user);
		return "redirect:/user/cart/viewCart";

	}

	@RequestMapping("/change")
	public String updateCartItemQuantity(@RequestParam(value = "cartItemId") int cartItemId,
			@RequestParam(value = "quantity") int quantity) {
		cartItem = cartItemDAO.getCartItem(cartItemId);
		product = cartItem.getProduct();
		Set<CartItem> Items = cart.getCartItem();
		if (quantity > product.getQuantity()) {
			String msg = "out of stock";
			return "redirect:/user/cart/viewCart?msg=" + msg;
		} else {
			cartItem.setQuantity(quantity);
			cartItem.setTotalPrice(quantity * product.getUnitPrice());
			cartItemDAO.saveOrUpdate(cartItem);
			for (CartItem item : Items) {
				cart.setGrandTotal(cart.getGrandTotal() + item.getTotalPrice());
			}
			cart.setNoOfProducts(Items.size());
			userDAO.saveOrUpdate(user);
			return "redirect:/user/cart/viewCart";
		}
	}
}