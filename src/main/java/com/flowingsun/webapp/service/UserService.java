package com.flowingsun.webapp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flowingsun.webapp.domain.User;


/**
 * @author flowingsun
 * @description 用户逻辑层
 */
public interface UserService {
		
		
		/**
		 * @param 用户ID
		 * @return User object
		 * @description 根据ID获取用户
		 */
		public User FindUserByid(Long id);
		
		/**
		 * @param 用户信息
		 * @return
		 * @throws Exception 
		 * @description 判断用户登陆
		 */
		public String CheckUserLogin(User user,HttpSession session) throws Exception;
		
		
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
		public List<User> GetPagingUsers(Map<String,Object> params,int page,int pageSize);
		
			
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
