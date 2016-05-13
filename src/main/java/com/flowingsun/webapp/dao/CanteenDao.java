package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.dao.common.BaseDao;
import com.flowingsun.webapp.domain.Canteen;

public interface CanteenDao extends BaseDao<Canteen> {

	/**
	 * @return 餐厅信息列表
	 * @author flowingsun
	 * @description 获取所有餐厅信息
	 */
	public List<Canteen> FindAllEntities();
}
