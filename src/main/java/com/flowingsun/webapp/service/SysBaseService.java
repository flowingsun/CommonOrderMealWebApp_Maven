package com.flowingsun.webapp.service;

import java.util.List;

import com.flowingsun.webapp.domain.SysMenu;

public interface SysBaseService {
	/**
	 * @return
	 * @author flowingSum
	 * @description 获取所有系统菜单
	 */
	public List<SysMenu> GetAllSysMenu();
}
