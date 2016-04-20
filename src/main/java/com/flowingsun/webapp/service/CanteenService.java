package com.flowingsun.webapp.service;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.Canteen;
import com.flowingsun.webapp.domain.User;

public interface CanteenService {

	public List<Canteen> FindAllCanteens();
	
	/**
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author flowingsun
	 * @description 获取餐厅分页信息
	 */
	public List<Canteen> GetPagingCanteens(Map<String, Object> params, int page,
			int pageSize);

	public void Update(Canteen user);

	public void Save(Canteen user) throws Exception;

}
