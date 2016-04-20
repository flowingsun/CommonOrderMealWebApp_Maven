package com.flowingsun.webapp.dao;

import java.util.List;

import com.flowingsun.webapp.domain.SysMenu;

public interface SysBaseDao {
	/**
	 * @return 所有系统菜单
	 */
	public List<SysMenu> GetAllSysMenu();
}