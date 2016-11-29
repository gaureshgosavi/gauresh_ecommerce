package com.niit.gauresh_emusic.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HttpError {

		@RequestMapping(value={"/400","/500","/404","/410"})
		public ModelAndView error(Model model){
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("ifAnyError", "true");	
			model.addAttribute("showLogin", "true");
			return mv;
		}
}
