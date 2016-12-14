package com.niit.gauresh_emusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.UserDAO;
import com.niit.gauresh_backend.dao.UserRoleDAO;
import com.niit.gauresh_backend.model.Cart;
import com.niit.gauresh_backend.model.User;
import com.niit.gauresh_backend.model.UserRole;

@Controller
public class AuthController {

	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRole userRole;

	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Autowired
	private Cart cart;

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * ModelAndView login(@ModelAttribute User user,
	 * 
	 * @RequestParam(value = "errorMessage", required = false) String
	 * errorMessage,
	 * 
	 * @RequestParam(value = "logoutMessage", required = false) String
	 * logoutMessage, Model model) { ModelAndView mv = new
	 * ModelAndView("/page"); mv.addObject("user", new User());
	 * 
	 * if (errorMessage != null) { model.addAttribute("error",
	 * "Oops! Invalid username or password,Please try again!!!"); } if
	 * (logoutMessage != null) { model.addAttribute("msg",
	 * "You're successfully logged out"); }
	 * 
	 * // to match username and password boolean flag =
	 * userDAO.isValidUser(user);
	 * 
	 * // if login successful if (flag == true) { user =
	 * userDAO.getById(user.getUserId()); session.setAttribute("User", user); //
	 * if admin has logged in if (userRole.getRole().equals("ADMIN")) {
	 * mv.addObject("admin", "true"); session.setAttribute("category",
	 * category); session.setAttribute("supplier", supplier);
	 * session.setAttribute("product", product);
	 * session.setAttribute("categoryList", categoryDAO.list());
	 * session.setAttribute("supplierList", supplierDAO.list());
	 * session.setAttribute("productList", productDAO.list()); } // if user has
	 * logged in else { mv.addObject("admin", "false");
	 * session.setAttribute("product", product);
	 * session.setAttribute("productList", productDAO.list()); } } return mv; }
	 */

	// when username or password becomes wrong
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginError(@RequestParam(value = "error", required = false) String error, Model model) {
		ModelAndView mv = new ModelAndView("/page");
		if (error != null)
			model.addAttribute("errorMessage", "Username or password is incorrect.");
		mv.addObject("ifLoginIsClicked", true);
		return mv;
	}

	@RequestMapping(value = "/register")
	public ModelAndView register(@RequestParam(value="ae", required = false) String ae) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("user", new User());
		
		if(ae != null)
			mv.addObject("error", "user with this user name already exist");
		
		mv.addObject("ifRegisterIsClicked", true);
		mv.addObject("title", "register");
		return mv;
	}

	// when user clicks on register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {

		
		if (userDAO.getByUsername(user.getUsername()) == null) {

			userRole.setRole("ADMIN");
			user.setEnabled(true);
			userRole.setUsername(user.getUsername());
			userRole.setUser(user);
			user.setUserRole(userRole);
			cart.setNoOfProducts(0);
			cart.setGrandTotal(0);
			//cart.setCartId(user.getUserId());
			user.setCart(cart);
			//cart.setUser(user);
			userDAO.saveOrUpdate(user);

		} else {
			String ae="user exist";
			return "redirect:/register?ae"+ae;

		}
		return "redirect:/login";

	}

/*	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}*/
}
