package com.flowingsun.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.common.SysBaseDao;
import com.flowingsun.webapp.domain.SysMenu;
import com.flowingsun.webapp.service.SysBaseService;

@Service("sysBaseService")
@Transactional
public class SysBaseServiceImpl implements SysBaseService {

	@Autowired
	private SysBaseDao sysBaseDao;
	private List<SysMenu> menuList;

	/**
	 * @return
	 * @author flowingSum
	 * @description 获取所有系统菜单
	 */
	@Override
	public List<SysMenu> GetAllSysMenu() {
		menuList = sysBaseDao.GetAllSysMenu();
		List<SysMenu> newMenuList = GetMenuList(0L);
		return newMenuList;
	}

	
	/**
	 * @param list原始菜单
	 * @param previousNodeID上级节点
	 * @return
	 * @author 
	 * @description 
	 */
	private List<SysMenu> GetMenuList(Long previousNodeID) {
		List<SysMenu> newList = new ArrayList<SysMenu>();
		for (int i = 0; i < menuList.size(); i++) {
			SysMenu item = menuList.get(i);
			if (item.getPreviousNodeID() == previousNodeID) {
				item.setChildren(GetMenuList(item.getID()));
				newList.add(item);
			}
		}
		return newList;
	}
}
