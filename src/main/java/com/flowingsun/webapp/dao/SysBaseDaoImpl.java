package com.flowingsun.webapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowingsun.webapp.domain.SysMenu;

@Repository("sysBaseDaoImpl")
public class SysBaseDaoImpl implements SysBaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysMenu> GetAllSysMenu() {
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session
				.createQuery("from SysMenu order by sort asc");
		List<SysMenu> result = null;
		if (query.list() != null && query.list().size() > 0) {
			result = (List<SysMenu>) query.list();
		}
		return result;
	}
	
}
