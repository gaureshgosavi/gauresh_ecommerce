package com.niit.gauresh_emusic.exceptions;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandling {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request,Exception exception,Model model){
		ModelAndView mv = new ModelAndView("page");
		model.addAttribute("error", exception);
		mv.addObject("ifAnyError", "true");
		return mv;
	}
}
