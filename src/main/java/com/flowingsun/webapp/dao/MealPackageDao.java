package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.MealPackage;

public interface MealPackageDao {

	/**
	 * @return 套餐信息列表
	 * @author flowingsun
	 * @description 获取所有套餐信息
	 */
	public List<MealPackage> FindAllMealPackages();

	
	/**
	 * @return 套餐信息
	 * @author flowingsun
	 * @description 获取菜单信息
	 */
	public MealPackage FindMealPackageById(int Id);

	/**
	 * @param mealPackage 套餐信息
	 * @author flowingsun
	 * @description 更新
	 */
	public void Update(MealPackage mealPackage);
	
	/**
	 * @param mealPackage 套餐
	 * @author flowingsun
	 * @description 新增
	 */
	public void Save(MealPackage mealPackage);


	/**
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author flowingsun
	 * @description 获取套餐列表
	 */
	public List<MealPackage> GetPagingMealPackages(Map<String, Object> params, int page,
			int pageSize);
}
