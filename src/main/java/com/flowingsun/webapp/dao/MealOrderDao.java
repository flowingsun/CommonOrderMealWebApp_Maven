package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.MealOrder;

public interface MealOrderDao {

	/**
	 * @return 订单信息列表
	 * @author flowingsun
	 * @description 获取所有订单信息
	 */
	public List<MealOrder> FindAllMealOrders();

	
	/**
	 * @return 订单信息
	 * @author flowingsun
	 * @description 获取菜单信息
	 */
	public MealOrder FindMealOrderById(int Id);

	/**
	 * @param mealMenu 订单信息
	 * @author flowingsun
	 * @description 更新
	 */
	public void Update(MealOrder mealOrder);
	
	/**
	 * @param mealMenu 订单
	 * @author flowingsun
	 * @description 新增
	 */
	public void Save(MealOrder mealOrder);


	/**
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author flowingsun
	 * @description 获取订单列表
	 */
	public List<MealOrder> GetPagingMealOrders(Map<String, Object> params, int page,
			int pageSize);
}
