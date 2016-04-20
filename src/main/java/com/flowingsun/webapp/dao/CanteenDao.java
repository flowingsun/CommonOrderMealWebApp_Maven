package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.Canteen;
import com.flowingsun.webapp.domain.User;

public interface CanteenDao {

	/**
	 * @return 餐厅信息列表
	 * @author flowingsun
	 * @description 获取所有餐厅信息
	 */
	public List<Canteen> FindAllCanteens();

	
	/**
	 * @return 餐厅信息
	 * @author flowingsun
	 * @description 获取餐厅信息
	 */
	public Canteen FindCanteenById(int Id);

	/**
	 * @param canteen餐厅信息
	 * @author flowingsun
	 * @description 更新
	 */
	public void Update(Canteen canteen);
	
	/**
	 * @param canteen
	 * @author flowingsun
	 * @description 新增
	 */
	public void Save(Canteen canteen);


	/**
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author flowingsun
	 * @description 
	 */
	public List<Canteen> GetPagingCanteens(Map<String, Object> params, int page,
			int pageSize);
}
