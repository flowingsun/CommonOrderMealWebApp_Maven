package com.flowingsun.webapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.UserDao;
import com.flowingsun.webapp.domain.User;
import com.flowingsun.webapp.util.Encryption;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User FindUserByid(Long id) {
		return userDao.FindUserByid(id);
	}

	@Override
	public String CheckUserLogin(User user,HttpSession session) throws Exception {
		User tempUser = userDao.FindUserByLoginName(user.getLoginname());
		if(tempUser==null){
			return "没有找到对应用户";
		}
		else if(!tempUser.getUserPassword().equals(Encryption.getMD5(user.getUserPassword()))){
			return "用户名与密码不匹配";
		}
		else{
			session.setAttribute("user", tempUser);
			return "success";
		}
	}

	@Override
	public List<User> FindAllUsers() {
		return userDao.FindAllUsers();
	}

	@Override
	public List<User> GetPagingUsers(Map<String, Object> params, int page,
			int pageSize) {
		List<User> list = userDao.GetPagingUsers(params, page, pageSize);
		List<User> result = new ArrayList<User>();
		for (User user : list) {
			if(user!=null){
				result.add(user);
			}
		}
		return result;
	}

	@Override
	@Transactional
	public void Update(User user) {
		userDao.Update(user);
	}

	@Override
	@Transactional
	public void Delete(User user) {
		userDao.Delete(user);
	}

	@Override
	@Transactional
	public void Save(User user) {
		userDao.Save(user);
	}
}
