package com.flowingsun.webapp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.common.CommonDao;
import com.flowingsun.webapp.dao.common.SysBaseDao;
import com.flowingsun.webapp.domain.SysMenu;

@Repository("sysBaseDaoImpl")
@Transactional(rollbackFor=Throwable.class)
public class SysBaseDaoImpl implements SysBaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
//	@Autowired
//	private CommonDao<SysMenu> commonDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysMenu> GetAllSysMenu() {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session
				.createQuery("from SysMenu order by sort asc");
		List<SysMenu> result = query.list();
		/*if (result != null && result.size() > 0) {
			result = (List<SysMenu>) query.list();
		}*/
		return result;
	}
	
}
