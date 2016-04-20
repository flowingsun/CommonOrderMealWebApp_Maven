package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.domain.MealPackage;

@Repository("mealPackageDao")
@Transactional(rollbackFor=Throwable.class)
public class MealPackageDaoImpl implements MealPackageDao {

	@Autowired
	private BaseDao<MealPackage> baseDao;
	@Override
	public List<MealPackage> FindAllMealPackages() {
		return baseDao.LoadAllEntities(MealPackage.class);
	}

	@Override
	public MealPackage FindMealPackageById(int Id) {
		return baseDao.LoadEntityById(MealPackage.class, Id, "mealPackageId");
	}

	@Override
	public void Update(MealPackage mealPackage) {
		baseDao.UpdateEntity(mealPackage);
		
	}

	@Override
	public void Save(MealPackage mealPackage) {
		baseDao.SaveEntity(mealPackage);
		
	}

	@Override
	public List<MealPackage> GetPagingMealPackages(Map<String, Object> params, int page, int pageSize) {
		List<HSerchEntity> hses = new ArrayList<HSerchEntity>();
//		if (params.get("canteenName") != null && params.get("canteenName") != "") {
//			HSerchEntity hse = new HSerchEntity();
//			hse.ColumnName = "canteenName";
//			hse.ColumnValue = params.get("canteenName").toString();
//			hse.HMachMode = MatchMode.ANYWHERE;
//			hses.add(hse);
//		}
		return baseDao.LoadPagingEntities(MealPackage.class, hses, page, pageSize);
	}

}
