package com.flowingsun.webapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowingsun.webapp.dao.SysBaseDao;
import com.flowingsun.webapp.domain.SysMenu;

@Service("sysBaseService")
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
		List<SysMenu> newMenuList = GetMenuList(0);
		return newMenuList;
	}

	
	/**
	 * @param list原始菜单
	 * @param previousNodeID上级节点
	 * @return
	 * @author 
	 * @description 
	 */
	private List<SysMenu> GetMenuList(int previousNodeID) {
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
