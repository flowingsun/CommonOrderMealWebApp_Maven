package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.domain.Canteen;

@Repository("canteenDao")
@Transactional(rollbackFor = Throwable.class)
public class CanteenDaoImpl implements CanteenDao {

	// @Resource
	@Autowired
	// @Qualifier("baseDao")
	private BaseDao<Canteen> baseDao;
	
	@Autowired
	Canteen _canteen;

	@Override
	public List<Canteen> FindAllCanteens() {
		return baseDao.LoadAllEntities(Canteen.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.flowingsun.webapp.dao.CanteenDao#GetPagingCanteens(java.util.Map,
	 * int, int)
	 * 
	 * @author flowingsun
	 * 
	 * @description
	 */
	@Override
	public List<Canteen> GetPagingCanteens(Map<String, Object> params, int page, int pageSize) {
		List<HSerchEntity> hses = new ArrayList<HSerchEntity>();
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		//Canteen canteen = new Canteen();// TODO--Spring.getBean
		// Canteen canteen = (Canteen)
		// SpringContext.GetContext().getBean("canteen");
		// Canteen canteen = SpringContext.GetContext().getBean(Canteen.class);
		Map<String, String> fieldMap = _canteen.GetClassFieldMaps();

		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			String val = (String) entry.getValue();
			if (null == val || val.length() <= 0) {
				continue;
			}
			if (!fieldMap.containsKey(key.toLowerCase())) {
				continue;
			} else {
				key = fieldMap.get(key.toLowerCase());
			}
			if (key.toLowerCase().equals("canteenname")) {
				HSerchEntity hse = new HSerchEntity();
				hse.ColumnName = "canteenName";
				hse.ColumnValue = params.get("canteenName").toString();
				hse.HMachMode = MatchMode.ANYWHERE;
				hses.add(hse);
			} else {
				HSerchEntity hse = new HSerchEntity();
				hse.ColumnName = key;
				if (key.toLowerCase().equals("canteenid") || key.toLowerCase().equals("canteenstatus")) {
					hse.ColumnValue = Integer.parseInt(val);
				} else {
					hse.ColumnValue = val;
				}
				hse.HMachMode = null;
				hses.add(hse);
			}
		}
		return baseDao.LoadPagingEntities(Canteen.class, hses, page, pageSize);
	}

	@Override
	public Canteen FindCanteenById(int Id) {
		return baseDao.LoadEntityById(Canteen.class, Id, "canteenId");
	}

	@Override
	public void Update(Canteen canteen) {
		baseDao.UpdateEntity(canteen);
	}

	@Override
	public void Save(Canteen canteen) {
		baseDao.SaveEntity(canteen);
	}
}
