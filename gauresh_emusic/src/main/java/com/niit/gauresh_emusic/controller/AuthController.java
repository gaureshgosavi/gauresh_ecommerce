package com.niit.gauresh_emusic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gauresh_backend.dao.CategoryDAO;
import com.niit.gauresh_backend.dao.ProductDAO;
import com.niit.gauresh_backend.dao.SupplierDAO;
import com.niit.gauresh_backend.dao.UserDAO;
import com.niit.gauresh_backend.model.Category;
import com.niit.gauresh_backend.model.Product;
import com.niit.gauresh_backend.model.Supplier;
import com.niit.gauresh_backend.model.User;

@Controller
public class AuthController {

	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;

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

			user.setRole("USER");
			userDAO.saveOrUpdate(user);

		} else {
			String ae="user exist";
			return "redirect:/register?ae"+ae;

		}
		return "redirect:/login";

	}

	// when user clicks logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam("message") String message, Model model) {
		ModelAndView mv = new ModelAndView("/page");

		if (message != null)
			model.addAttribute("logoutMessage", "Successfully logged out.");

		return mv;
	}

}
