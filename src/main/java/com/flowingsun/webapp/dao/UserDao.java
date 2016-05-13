package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.dao.common.BaseDao;
import com.flowingsun.webapp.domain.User;

public interface UserDao extends BaseDao<User>  {

	/**
	 * @param 用户名
	 * @return 用户基本信息
	 * @description 根据用户名查找用户基本信息
	 */
	public User FindUserByUserName(String userName);
	
	/**
	 * @param 用户名
	 * @return 用户基本信息
	 * @description 根据用户名查找用户基本信息
	 */
	public User FindUserByLoginName(String loginname);
	
	
	/**
	 * @return 用户列表
	 * @description 获取所用用户
	 */
	public List<User> FindAllUsers();
	
	
	/**
	 * @param userIds用户id
	 * @param state状态代码
	 * @author flowingsun
	 * @description 根据用户ID更新用户状态
	 */
	public void UpdateUserStateByUserIds(String userIds,int state);
}