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

import com.flowingsun.webapp.domain.Canteen;
import com.flowingsun.webapp.domain.ExtjsPaging;
import com.flowingsun.webapp.domain.FormMessage;
import com.flowingsun.webapp.domain.User;
import com.flowingsun.webapp.service.CanteenService;

@Controller
@RequestMapping("/admin/CanteenManage")
public class SysAdmin_CanteenController {

	@Autowired
	CanteenService canteenService;

	/**
	 * @param request请求
	 * @param response应答
	 * @param model分页实体
	 * @return json
	 * @throws Exception
	 * @author flowingsun
	 * @description 获取餐厅分页数据
	 */
	@RequestMapping("/GetPagingCanteens")
	@ResponseBody
	public Object GetPagingUsers(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("ExtjsPaging") ExtjsPaging model) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		String username = request.getParameter("canteenName");
		params.put("canteenName", username);
		List<Canteen> userList = canteenService.GetPagingCanteens(params,
				model.getPage(), model.getPageSize());
		return userList;
	}

	@RequestMapping("/addCanteen")
	@ResponseBody
	public Object AddCanteen(HttpServletRequest request, Canteen canteen) {
		FormMessage result = new FormMessage();
		try {
			canteenService.Save(canteen);
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

	@RequestMapping("/updateCanteen")
	@ResponseBody
	public Object UpdateCanteen(HttpServletRequest request, Canteen canteen) {
		FormMessage result = new FormMessage();
		try {
			canteenService.Update(canteen);
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
