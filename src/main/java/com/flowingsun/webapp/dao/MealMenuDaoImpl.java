package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.domain.MealMenu;

@Repository("mealMenuDao")
@Transactional(rollbackFor = Throwable.class)
public class MealMenuDaoImpl implements MealMenuDao {

	@Autowired
	private BaseDao<MealMenu> baseDao;

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
//		if (params.get("canteenName") != null && params.get("canteenName") != "") {
//			HSerchEntity hse = new HSerchEntity();
//			hse.ColumnName = "canteenName";
//			hse.ColumnValue = params.get("canteenName").toString();
//			hse.HMachMode = MatchMode.ANYWHERE;
//			hses.add(hse);
//		}
		return baseDao.LoadPagingEntities(MealMenu.class, hses, page, pageSize);
	}

}
