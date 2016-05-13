package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.dao.common.BaseDao;
import com.flowingsun.webapp.domain.MealMenu;

public interface MealMenuDao extends BaseDao<MealMenu>  {

	/**
	 * @return 菜单信息列表
	 * @author flowingsun
	 * @description 获取所有菜单信息
	 */
	public List<MealMenu> FindAllMealEntities();

	/**
	 * @return
	 * @author flowingsun
	 * @description 获取当前可用菜单id
	 */
	public List<Integer> GetAvailableMealMenuIds();

	/**
	 * @return
	 * @author flowingsun
	 * @description 获取当前可用菜单
	 */
	public List<MealMenu> GetAvailableMealMenus();
}
