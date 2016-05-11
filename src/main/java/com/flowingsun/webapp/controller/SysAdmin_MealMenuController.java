package com.flowingsun.webapp.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowingsun.webapp.domain.ExtjsPaging;
import com.flowingsun.webapp.domain.FormMessage;
import com.flowingsun.webapp.domain.MealMenu;
import com.flowingsun.webapp.service.MealMenuService;

@Controller
@RequestMapping("/admin/mealMenuManage")
public class SysAdmin_MealMenuController {

	@Autowired
	MealMenuService mealMenuService;

	@RequestMapping("/GetPagingMealMenus")
	@ResponseBody
	public Object GetPagingUsers(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("ExtjsPaging") ExtjsPaging model) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> iterator = request.getParameterMap().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) iterator.next();
			String key = entry.getKey();
			String val = entry.getValue()[0];
			params.put(key, val);
		}
		List<MealMenu> userList = mealMenuService.GetPagingMealMenus(params, model.getPage(), model.getPageSize());
		return userList;
	}

	@RequestMapping("/addMealMenu")
	@ResponseBody
	public Object AddUser(HttpServletRequest request, MealMenu mealMenu) {
		FormMessage result = new FormMessage();
		try {
			mealMenuService.Save(mealMenu);
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

	@RequestMapping("/updateMealMenu")
	@ResponseBody
	public Object UpdateUser(HttpServletRequest request, MealMenu mealMenu) {
		FormMessage result = new FormMessage();
		try {
			mealMenuService.Update(mealMenu);
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

	// @RequestMapping("/freezeMealMenus")
	// @ResponseBody
	// public Object FreezeUsers(HttpServletRequest request,String mealMenuIds)
	// {
	// FormMessage result = new FormMessage();
	// try {
	// mealMenuService.FreezeUsers(userIds);
	// } catch (Exception e) {
	// e.printStackTrace();
	// result.setSuccess(false);
	// result.setMsg(e.getMessage());
	// return result;
	// }
	// result.setSuccess(true);
	// result.setMsg("修改成功");
	// return result;
	// }

}
