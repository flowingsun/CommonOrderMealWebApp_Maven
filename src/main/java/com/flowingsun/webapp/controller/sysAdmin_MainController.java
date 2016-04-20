package com.flowingsun.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flowingsun.webapp.domain.ExtjsPaging;
import com.flowingsun.webapp.domain.SysMenu;
import com.flowingsun.webapp.domain.User;
import com.flowingsun.webapp.service.SysBaseService;
import com.flowingsun.webapp.service.UserService;
import com.flowingsun.webapp.util.Encryption;

@Controller
public class SysAdmin_MainController {
	@Autowired
	UserService userService;
	@Autowired
	SysBaseService sysBaseService;

	@RequestMapping("/admin_login/login")
	public ModelAndView LoginAction() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sysAdmin/login");
		mav.addObject("testmd5", Encryption.getMD5("test"));
		return mav;
	}

	@RequestMapping("/admin_ajax/checklogin")
	@ResponseBody
	public String CheckLoginAction(HttpServletRequest request,
			@RequestBody User user) throws Exception {
		HttpSession session = request.getSession();
		String message = userService.CheckUserLogin(user, session);
		Thread.sleep(300);
		return message;
	}

	@RequestMapping("/admin/logout")
	public ModelAndView Logout(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sysAdmin/login");
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return mav;
	}

	@RequestMapping("/admin/index")
	public ModelAndView IndexAction() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sysAdmin/index");
		return mav;
	}

	@RequestMapping("/admin/GetAllSysMenu")
	@ResponseBody
	public Object GetAllSysMenu() throws Exception {
		List<SysMenu> sysMenuList = sysBaseService.GetAllSysMenu();
		return sysMenuList;
	}

	@RequestMapping("/admin/GetPagingUsers")
	@ResponseBody
	public Object GetPagingUsers(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("ExtjsPaging") ExtjsPaging model) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String userLocation = request.getParameter("userLocation");
		if (username != null && username != "")
			params.put("username", new String(username.getBytes("ISO-8859-1"),
					"UTF-8"));
		if (userLocation != null && userLocation != "")
			params.put("userLocation",
					new String(userLocation.getBytes("ISO-8859-1"), "UTF-8"));
		List<User> userList = userService.GetPagingUsers(params,
				model.getPage(), model.getPageSize());
		return userList;
	}
}
