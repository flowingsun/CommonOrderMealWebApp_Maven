package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.MealMenu;

public interface MealMenuDao {

	/**
	 * @return 菜单信息列表
	 * @author flowingsun
	 * @description 获取所有菜单信息
	 */
	public List<MealMenu> FindAllMealMenus();

	
	/**
	 * @return 菜单信息
	 * @author flowingsun
	 * @description 获取菜单信息
	 */
	public MealMenu FindCanteenById(int Id);

	/**
	 * @param mealMenu 菜单信息
	 * @author flowingsun
	 * @description 更新
	 */
	public void Update(MealMenu mealMenu);
	
	/**
	 * @param mealMenu 菜单
	 * @author flowingsun
	 * @description 新增
	 */
	public void Save(MealMenu mealMenu);


	/**
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author flowingsun
	 * @description 获取菜单列表
	 */
	public List<MealMenu> GetPagingMealMenus(Map<String, Object> params, int page,
			int pageSize);
}
