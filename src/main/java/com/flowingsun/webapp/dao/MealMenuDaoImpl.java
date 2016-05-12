package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.domain.Canteen;
import com.flowingsun.webapp.domain.MealMenu;
import com.mysql.jdbc.Connection;

@Repository("mealMenuDao")
@Transactional(rollbackFor = Throwable.class)
public class MealMenuDaoImpl implements MealMenuDao {

	@Autowired
	private BaseDao<MealMenu> baseDao;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MealMenu> FindAllMealMenus() {
		return baseDao.LoadAllEntities(MealMenu.class);
	}

	@Override
	public MealMenu FindCanteenById(int Id) {
		return baseDao.LoadEntityById(MealMenu.class, Id, "mealMenuId");
	}

	@Override
	public void Update(MealMenu mealMenu) {
		baseDao.UpdateEntity(mealMenu);

	}

	@Override
	public void Save(MealMenu mealMenu) {
		baseDao.SaveEntity(mealMenu);
	}

	@Override
	public List<MealMenu> GetPagingMealMenus(Map<String, Object> params, int page, int pageSize) {
		List<HSerchEntity> hses = new ArrayList<HSerchEntity>();
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		MealMenu entity = new MealMenu();// TODO--Spring.getBean
		Map<String, String> fieldMap = entity.GetClassFieldMaps();

		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			String val = (String) entry.getValue();
			if (null == val || val.length() <= 0) {
				continue;
			}
			if (!fieldMap.containsKey(key.toLowerCase())) {
				if (key.toLowerCase().equals("mealmenuname")) {
					key="mealmenuname";
				} else {
					continue;
				}
			} else {
				key = fieldMap.get(key.toLowerCase());
			}
			if (key.toLowerCase().equals("mealmenuname")) {
				HSerchEntity hse = new HSerchEntity();
				hse.ColumnName = "menuName";
				hse.ColumnValue = params.get("mealMenuName").toString();
				hse.HMachMode = MatchMode.ANYWHERE;
				hses.add(hse);
			} else {
				HSerchEntity hse = new HSerchEntity();
				hse.ColumnName = key;
				if (key.toLowerCase().equals("menuid") || key.toLowerCase().equals("menutype")
						|| key.toLowerCase().equals("canteenid")) {
					hse.ColumnValue = Integer.parseInt(val);
				} else {
					hse.ColumnValue = val;
				}
				hse.HMachMode = null;
				hses.add(hse);
			}
		}
		return baseDao.LoadPagingEntities(MealMenu.class, hses, page, pageSize);
	}

	@Override
	public List<Integer> GetAvailableMealMenuIds() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("{call SP_GetAvailableMealMenuIDs()}");
		List list = query.list();
		if(!list.isEmpty()){
			return (List<Integer>)list;
		}
		return null;
	}

	@Override
	public List<MealMenu> GetAvailableMealMenus() {
		List<Integer> idList = GetAvailableMealMenuIds();
		if(idList!=null && idList.size()>0){
			Session session = sessionFactory.getCurrentSession();
			Criteria cri = session.createCriteria(MealMenu.class);
			cri.add(Restrictions.in("mealMenuId", idList));
			List<MealMenu> result = cri.list();
			return result;
		}
		return null;
	}

}
