package com.flowingsun.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flowingsun.webapp.service.SysBaseService;
import com.flowingsun.webapp.service.UserService;
import com.flowingsun.webapp.util.Encryption;



@Controller
public class UserPlatform_MainController {

	@Autowired
	UserService userService;
	@Autowired
	SysBaseService sysBaseService;
	


	@RequestMapping("/userplatform/index")
	public ModelAndView indexAction() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "首页");
		mav.setViewName("/userPlatform/index");
		return mav;
	}
	
	@RequestMapping("/userplatform/test")
	public ModelAndView testAction() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/userPlatform/test");
		mav.addObject("testmd5", Encryption.getMD5("test"));
		return mav;
	}
}
