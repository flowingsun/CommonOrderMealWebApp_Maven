package com.flowingsun.webapp.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowingsun.webapp.domain.MealOrder;
import com.flowingsun.webapp.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User FindUserByid(Long id) {
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session
				.createQuery("from User as u where u.id=?");
		query.setParameter(0, id);
		User user = null;
		if (query.list() != null && query.list().size() > 0) {
			user = (User) query.list().get(0);
		}
		return user;
	}

	@Override
	public User FindUserByUserName(String userName) {

		return null;
	}

	@Override
	public User FindUserByLoginName(String loginname) {
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session
				.createQuery("from User as u where u.loginname=?");
		query.setParameter(0, loginname);
		User user = null;
		if (query.list() != null && query.list().size() > 0) {
			user = (User) query.list().get(0);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> FindAllUsers() {
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session.createQuery("from User");
		return (List<User>) query.list();
	}

	@Override
	public List<User> GetPagingUsers(Map<String, Object> params, int page,
			int pageSize) {
		Session session = sessionFactory.openSession();
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
		List<User> result = cri.list();
		return result;
	}

	@Override
	public void Update(User user) {
		// this.update(user);
	}

	@Override
	public void Delete(User user) {
		// this.remove(user);
	}

	@Override
	public void Save(User user) {
		// this.create(user);
		sessionFactory.getCurrentSession().save(user);
	}

}
