package com.flowingsun.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.UserDao;
import com.flowingsun.webapp.domain.User;
import com.flowingsun.webapp.service.UserService;
import com.flowingsun.webapp.util.Encryption;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User FindUserByid(Long id) {
		return userDao.FindEnityById(id);
	}

	@Override
	public String CheckUserLogin(User user, HttpSession session) throws Exception {
		User tempUser = userDao.FindUserByLoginName(user.getLoginname());
		if (tempUser == null) {
			return "没有找到对应用户";
		} else if (!tempUser.getUserPassword().equals(Encryption.getMD5(user.getUserPassword()))) {
			return "用户名与密码不匹配";
		} else if (tempUser.getUserState() == 0) {
			return "账户已停用";
		} else if (tempUser.getAdminLevelID() == 0) {
			return "无权限进入系统后台";
		} else {
			session.setAttribute("user", tempUser);
			return "success";
		}
	}

	@Override
	public List<User> FindAllUsers() {
		return userDao.FindAllUsers();
	}

	@Override
	public List<User> GetPagingUsers(Map<String, Object> params, int page, int pageSize) {
		List<User> list = userDao.GetPagingEntities(params, page, pageSize);
		List<User> result = new ArrayList<User>();
		for (User user : list) {
			if (user != null) {
				result.add(user);
			}
		}
		return result;
	}

	@Override
	public void Update(User user) {
		User userTemp = FindUserByid(user.getUserID());
		if ((!(user.getCleartextPassword() != null && user.getCleartextPassword() != ""))
				|| user.getCleartextPassword().equals("密码未曾修改")) {
			user.setCleartextPassword(userTemp.getCleartextPassword());
		}
		if ((!(user.getUserPassword() != null && user.getUserPassword() != ""))
				|| user.getUserPassword().equals("密码未曾修改")) {
			user.setUserPassword(userTemp.getUserPassword());
		} else {
			try {
				if (!user.getUserPassword().equals(user.getCleartextPassword())) {
					throw new Exception("密码不一致，请核对后再试");
				}
				user.setUserPassword(Encryption.getMD5(user.getUserPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		user.setLastEditTime(new Date());
		userDao.Update(user);
	}

	@Override
	public void Save(User user) throws Exception {
		User tempUser = userDao.FindUserByLoginName(user.getLoginname());
		if (tempUser != null) {
			throw new Exception("用户登陆账号重复，请修改后重新添加该用户。。。");
		} else {
			user.setUserPassword(Encryption.getMD5(user.getUserPassword()));
			userDao.Save(user);
		}
	}

	@Override
	public void FreezeUsers(String userIds) throws Exception {
		userDao.UpdateUserStateByUserIds(userIds, 0);
	}

	@Override
	public void ActiveUsers(String userIds) throws Exception {
		userDao.UpdateUserStateByUserIds(userIds, 1);
	}
}
