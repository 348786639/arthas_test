package com.ding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
	

	/**
	 * 首页
	 */
	@RequestMapping("/index")
	public ModelAndView index(Long categoryId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
	}
}
