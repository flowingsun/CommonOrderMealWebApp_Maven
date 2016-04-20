package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.domain.MealMenu;
import com.flowingsun.webapp.domain.MealOrder;

@Repository("mealOrderDao")
@Transactional(rollbackFor=Throwable.class)
public class MealOrderDaoImpl implements MealOrderDao {

	@Autowired
	private BaseDao<MealOrder> baseDao;
	@Override
	public List<MealOrder> FindAllMealOrders() {
		return baseDao.LoadAllEntities(MealOrder.class);
	}

	@Override
	public MealOrder FindMealOrderById(int Id) {
		return baseDao.LoadEntityById(MealOrder.class, Id, "mealOrderId");
	}

	@Override
	public void Update(MealOrder mealOrder) {
		baseDao.UpdateEntity(mealOrder);
		
	}

	@Override
	public void Save(MealOrder mealOrder) {
		baseDao.SaveEntity(mealOrder);
		
	}

	@Override
	public List<MealOrder> GetPagingMealOrders(Map<String, Object> params, int page, int pageSize) {
		List<HSerchEntity> hses = new ArrayList<HSerchEntity>();
//		if (params.get("canteenName") != null && params.get("canteenName") != "") {
//			HSerchEntity hse = new HSerchEntity();
//			hse.ColumnName = "canteenName";
//			hse.ColumnValue = params.get("canteenName").toString();
//			hse.HMachMode = MatchMode.ANYWHERE;
//			hses.add(hse);
//		}
		return baseDao.LoadPagingEntities(MealOrder.class, hses, page, pageSize);
	}

	
}
