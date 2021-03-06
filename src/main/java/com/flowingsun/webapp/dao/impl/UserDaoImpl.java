package com.flowingsun.webapp.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.UserDao;
import com.flowingsun.webapp.domain.User;

@Repository("userDao")
@Transactional(rollbackFor=Throwable.class)
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User FindUserByUserName(String userName) {

		return null;
	}

	@Override
	public User FindUserByLoginName(String loginname) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session
				.createQuery("from User as u where u.loginname=?");
		query.setParameter(0, loginname);
		@SuppressWarnings("unchecked")
		List<User> templist = query.list();
		User user = null;
		if (templist != null && templist.size() > 0) {
			user = (User) templist.get(0);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> FindAllUsers() {
		// Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();// 改为getCurrentSession防止查询死锁
		org.hibernate.Query query = session.createQuery("from User");
		return (List<User>) query.list();
	}

	@Override
	public void Update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void Save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void UpdateUserStateByUserIds(String userIds, int state) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update User set userState=? where userID in (?)";
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter(0, state);
		query.setParameter(1, userIds);
		session.getTransaction().commit();
	}

	@Override
	public User FindEnityById(Long Id) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session
				.createQuery("from User as u where u.id=?");
		query.setParameter(0, Id);
		@SuppressWarnings("unchecked")
		List<User> templist = query.list();
		User user = null;
		if (templist != null && templist.size() > 0) {
			user = (User) templist.get(0);
		}
		return user;
	}

	@Override
	public void ChangeState(int id, int state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> GetPagingEntities(Map<String, Object> params, int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(User.class);
		if (params.get("username") != null && params.get("username") != "")
			cri.add(Restrictions.like("userName", params.get("username")
					.toString(), MatchMode.ANYWHERE));
		if (params.get("userLocation") != null
				&& params.get("userLocation") != "")
			cri.add(Restrictions.like("userLocation", params
					.get("userLocation").toString(), MatchMode.ANYWHERE));
		cri.setFirstResult((page - 1) * pageSize);
		cri.setMaxResults(pageSize);
		@SuppressWarnings("unchecked")
		List<User> result = cri.list();
		return result;
	}
}
