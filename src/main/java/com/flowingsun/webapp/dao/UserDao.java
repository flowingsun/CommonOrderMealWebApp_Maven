package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;

import com.flowingsun.webapp.domain.User;

public interface UserDao {

	/**
	 * @param 用户ID
	 * @return User object
	 * @description 根据ID获取用户
	 */
	public User FindUserByid(Long id);
	
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
	 * @return
	 * @author flowingsun
	 * @description 获取分页用户数据
	 */
	public List<User> GetPagingUsers(Map<String, Object> params, int page,
			int pageSize);
		
	/**
	 * @param 用户对象
	 * @description 根据用户对象更新数据
	 */
	public void Update(User user);
	
	
	/**
	 * @param 用户对象
	 * @description 根据用户对象删除数据
	 */
	public void Delete(User user);
	
	
	/**
	 * @param 用户对象
	 * @description 根据用户对象新增数据
	 */
	public void Save(User user); 
}