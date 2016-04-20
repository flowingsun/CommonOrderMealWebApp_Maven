package com.flowingsun.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flowingsun.webapp.domain.ExtjsPaging;
import com.flowingsun.webapp.domain.FormMessage;
import com.flowingsun.webapp.domain.User;
import com.flowingsun.webapp.service.UserService;

@Controller
@RequestMapping("/admin/userManage")
public class SysAdmin_UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/GetPagingUsers")
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

	@RequestMapping("/addUser")
	@ResponseBody
	public Object AddUser(HttpServletRequest request, User user) {
		FormMessage result = new FormMessage();
		if (!user.getUserPassword().equals(user.getCleartextPassword())) {
			result.setMsg("密码不一致，请核对后再试");
			result.setSuccess(false);
			return result;
		}
		try {
			userService.Save(user);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			return result;
		}
		result.setSuccess(true);
		result.setMsg("添加成功");
		return result;
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	public Object UpdateUser(HttpServletRequest request, User user) {
		FormMessage result = new FormMessage();
		try {
			userService.Update(user);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			return result;
		}
		result.setSuccess(true);
		result.setMsg("修改成功");
		return result;
	}
	

	@RequestMapping("/freezeUsers")
	@ResponseBody
	public Object FreezeUsers(HttpServletRequest request,String userIds) {
		FormMessage result = new FormMessage();
		try {
			userService.FreezeUsers(userIds);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			return result;
		}
		result.setSuccess(true);
		result.setMsg("修改成功");
		return result;
	}
}
