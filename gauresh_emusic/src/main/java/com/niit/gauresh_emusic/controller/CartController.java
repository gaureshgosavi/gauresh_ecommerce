package com.niit.gauresh_emusic.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	private CartItem cartItem;

	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/viewCart")
	public ModelAndView viewCart(Model model, @RequestParam(value = "msg", required = false) String msg,
			Principal principal) {
		ModelAndView mv = new ModelAndView("page");
		if (msg != null) {
			if (msg.equals("addfailure")) {
				model.addAttribute("addfailure", "Failed to add the product to the cart.");
			} else if (msg.equals("removefailure")) {
				model.addAttribute("removefailure", "Failed to remove item from the cart");
			} else if (msg.equals("out of stock")) {
				model.addAttribute("out of stock",
						"Sorry, Quantity of product you are trying to update is unavailable in our stock");
			}
		}

		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		List<CartItem> Items = cart.getCartItem();
		if (Items.size() == 0) {
			mv.addObject("noProduct", "Your cart is empty!!!");
		} else {
			user = userDAO.getByUsername(principal.getName());
			cart = user.getCart();
			cartItem = new CartItem();
			mv.addObject("cartItems", cartItemDAO.listCartItems(cart.getCartId()));
			mv.addObject("cart", user.getCart());
			mv.addObject("product", cartItem.getProduct());
		}
		mv.addObject("ifUserClickedMyCart", true);
		return mv;
	}

	@RequestMapping("/add/{productId}")
	public String addToCart(@PathVariable("productId") int id, Principal principal) {
		ModelAndView mv = new ModelAndView("page");

		product = productDAO.get(id);
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		List<CartItem> Items = cart.getCartItem();
		String msg = null;

		if (Items.size() != 0) {
			for (CartItem item : Items) {
				if (product.getProductId() == item.getProduct().getProductId()) {
					cartItem = cartItemDAO.getCartItem(item.getCartItemId());
					item.setQuantity(cartItem.getQuantity() + 1);
					item.setTotalPrice((cartItem.getQuantity()+1) * product.getUnitPrice());
					boolean flag = cartItemDAO.saveOrUpdate(item);

					if (flag == true) {
						msg = "addsuccess";
					} else {
						msg = "addfailure";

					}
					
					List<CartItem> updatedItems = cartItemDAO.listCartItems(cart.getCartId());
					int t = 0;
					for (CartItem updatedItem : updatedItems) {
						t += updatedItem.getTotalPrice();
					}
					cart.setGrandTotal(t);
					cart.setNoOfProducts(updatedItems.size());
					cartItemDAO.updateCart(cart);
					session.setAttribute("noOfCartItems", cart.getNoOfProducts());
					return "redirect:/user/cart/viewCart?msg=" + msg;
				}

			}
		}
		cartItem = new CartItem();

		cartItem.setQuantity(1);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getUnitPrice());
		cartItem.setCart(cart);
		boolean flag = cartItemDAO.saveOrUpdate(cartItem);
		if (flag == true) {
			msg = "addsuccess";
		} else {
			msg = "addfailure";
		}
		
		int t = 0;
		
		List<CartItem> updatedItems = cartItemDAO.listCartItems(cart.getCartId());
		for (CartItem item : updatedItems) {
			t += item.getTotalPrice();
		}
		cart.setGrandTotal(t);
		cart.setNoOfProducts(updatedItems.size());
		cartItemDAO.updateCart(cart);
		session.setAttribute("noOfCartItems", cart.getNoOfProducts());
		return "redirect:/user/cart/viewCart?msg=" + msg;

	}

	@RequestMapping("/remove/all")
	public String removeAllItems(Principal principal) {
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		List<CartItem> Items = cart.getCartItem();
		for (CartItem item : Items) {
			cartItemDAO.delete(item);
		}
		
		
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		
		
		cart.setGrandTotal(0);
		cart.setNoOfProducts(0);
		cartItemDAO.updateCart(cart);
		session.setAttribute("noOfCartItems", cart.getNoOfProducts());
		return "redirect:/user/cart/viewCart";

	}

	@RequestMapping("/remove/{cartItemId}")
	public String removeCartItems(@PathVariable("cartItemId") int cartItemId, Model model, Principal principal) {
		ModelAndView mv = new ModelAndView();
		String msg = null;
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		cartItem = cartItemDAO.getCartItem(cartItemId);
		boolean flag = cartItemDAO.delete(cartItem);
		if (flag == true) {
			msg = "removesuccess";
		} else {
			msg = "removefailure";
		}
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		List<CartItem> Items = cart.getCartItem();
		int t = 0;
		for (CartItem item : Items) {
			t += item.getTotalPrice();
		}
		cart.setGrandTotal(t);
		cart.setNoOfProducts(Items.size());
		cartItemDAO.updateCart(cart);
		session.setAttribute("noOfCartItems", cart.getNoOfProducts());
		return "redirect:/user/cart/viewCart?msg=" + msg;
	}

	@RequestMapping("/change")
	public String updateCartItemQuantity(HttpServletRequest Id, HttpServletRequest Qnt, Principal principal) {
		user = userDAO.getByUsername(principal.getName());
		cart = user.getCart();
		String id = Id.getParameter("cartItemId");
		String qnt = Qnt.getParameter("quantity");
		int cartItemId = Integer.parseInt(id);
		int quantity = Integer.parseInt(qnt);
		cartItem = cartItemDAO.getCartItem(cartItemId);
		if (quantity > cartItem.getProduct().getQuantity()) {
			String msg = "out of stock";
			return "redirect:/user/cart/viewCart?msg=" + msg;
		} else {
			cartItem.setQuantity(quantity);
			cartItem.setTotalPrice(quantity * cartItem.getProduct().getUnitPrice());
			cartItemDAO.saveOrUpdate(cartItem);
			user = userDAO.getByUsername(principal.getName());
			cart = user.getCart();
			List<CartItem> Items = cart.getCartItem();
			int t = 0;
			for (CartItem item : Items) {
				t += item.getTotalPrice();
			}
			cart.setGrandTotal(t);
			cart.setNoOfProducts(Items.size());
			cartItemDAO.updateCart(cart);
			session.setAttribute("noOfCartItems", cart.getNoOfProducts());
			return "redirect:/user/cart/viewCart";
		}
	}
}