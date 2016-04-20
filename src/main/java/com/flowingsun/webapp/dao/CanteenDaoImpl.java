package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
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
		if (params.get("canteenName") != null && params.get("canteenName") != "") {
			HSerchEntity hse = new HSerchEntity();
			hse.ColumnName = "canteenName";
			hse.ColumnValue = params.get("canteenName").toString();
			hse.HMachMode = MatchMode.ANYWHERE;
			hses.add(hse);
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
