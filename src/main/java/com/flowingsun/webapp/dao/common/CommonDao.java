package com.flowingsun.webapp.dao.common;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.stereotype.Repository;

import com.flowingsun.webapp.dao.common.HSerchEntity;

@Repository("commonDao")
public class CommonDao<T> extends HibernateDaoSupport {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	// @Autowired
	// private SessionFactory sessionFactory;

	public List<T> LoadAllEntities(Class<T> clazz) {
		Session session = super.getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(clazz);
		@SuppressWarnings("unchecked")
		List<T> result = cri.list();
		return result;
	}

	public List<T> LoadTopEntities(Class<T> clazz, int topNum) {
		Session session = super.getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(clazz);
		cri.setMaxResults(topNum);
		@SuppressWarnings("unchecked")
		List<T> result = cri.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public T LoadEntityById(Class<T> clazz, Object id, String idName) {
		Session session = super.currentSession();
		Criteria cri = session.createCriteria(clazz);
		if (null == idName || idName.length() <= 0) {
			idName = getClass().getName() + "Id";
		}
		cri.add(Restrictions.eq(idName, id));
		List<T> result = cri.list();
		if (null != result && result.size() > 0) {
			return (T) cri.list().get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public T LoadEntityByHql(org.hibernate.Query query) {
		List<Object> result = query.list();
		if (null != result && result.size() > 0) {
			return (T) (result.get(0));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> LoadEntitiesByHql(org.hibernate.Query query) {
		return (List<T>) query.list();
	}

	public List<T> LoadPagingEntities(Class<T> clazz, List<HSerchEntity> params, int page, int pageSize) {
		Session session = super.getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(clazz);
		if (params != null && params.size() > 0) {
			for (HSerchEntity hse : params) {
				if (hse.HMachMode == null) {
					cri.add(Restrictions.eq(hse.ColumnName, hse.ColumnValue));
					// cri.add(Restrictions
					// .sqlRestriction(clazz.getName() + "." + hse.ColumnName +
					// "=?" , hse.ColumnValue + "'",new Type().));
				} else {
					cri.add(Restrictions.like(hse.ColumnName, (String) hse.ColumnValue, hse.HMachMode));
				}
			}
		}
		cri.setFirstResult((page - 1) * pageSize);
		cri.setMaxResults(pageSize);
		@SuppressWarnings("unchecked")
		List<T> result = cri.list();
		return result;
	}

	// protected List<T> LoadPagingEntities(String hql, int page, int pageSize)
	// {
	// Session session = super.getSessionFactory().getCurrentSession();
	// Criteria cri = session.createCriteria(getClass());
	// cri.addQueryHint(hql);
	// cri.setFirstResult((page - 1) * pageSize);
	// cri.setMaxResults(pageSize);
	// @SuppressWarnings("unchecked")
	// List<T> result = cri.list();
	// return result;
	// }

	public void SaveEntity(T entity) {
		super.getSessionFactory().getCurrentSession().save(entity);
	}

	public void UpdateEntity(T entity) {
		super.getSessionFactory().getCurrentSession().update(entity);
	}

	public void DeleteEntity(T entity) {
		super.getSessionFactory().getCurrentSession().delete(entity);
	}

}
