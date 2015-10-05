package com.flowingsun.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flowingsun.webapp.domain.User;
import com.flowingsun.webapp.service.UserService;

@Controller
public class IndexController {

	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public ModelAndView IndexAction() {
		ModelAndView mav = new ModelAndView("/index");
		mav.setViewName("/index");
		mav.addObject("teststr", "test");
		User user = userService.FindUserByid(Long.valueOf(1));
		mav.addObject(user);
		List<User> users =userService.FindAllUsers();
		mav.addObject("users",users);
		return mav;
	}

}
