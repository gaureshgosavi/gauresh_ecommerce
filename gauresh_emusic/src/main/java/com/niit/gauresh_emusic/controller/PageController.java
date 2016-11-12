package com.niit.gauresh_emusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedHome", true);
		mv.addObject("title", "index");
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedAbout", true);
		mv.addObject("title", "about");
		return mv;
	}

	@RequestMapping(value ="/contact")
    public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedContact", true);
		mv.addObject("title", "contact");
		return mv;
	}

	@RequestMapping(value = "/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedAdmin", true);
		mv.addObject("title", "admin");
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedLogin", true);
		mv.addObject("title", "login");
		return mv;
	}
	
	@RequestMapping(value = "/product")
	public ModelAndView product() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedProduct", true);
		mv.addObject("title", "product");
		return mv;
	}
	
	@RequestMapping(value = "/productDetail")
	public ModelAndView productDetail() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedProductDetail", true);
		mv.addObject("title", "productDetail");
		return mv;
	}
	
}
