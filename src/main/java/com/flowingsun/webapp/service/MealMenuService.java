package com.flowingsun.webapp.service;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.MealMenu;

public interface MealMenuService {


	public List<MealMenu> FindAllMealMenus();
	
	/**
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author flowingsun
	 * @description 获取餐厅分页信息
	 */
	public List<MealMenu> GetPagingCanteens(Map<String, Object> params, int page,
			int pageSize);

	public void Update(MealMenu user);

	public void Save(MealMenu user) throws Exception;
}
