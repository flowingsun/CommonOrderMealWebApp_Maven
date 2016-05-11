package com.flowingsun.webapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.domain.MealOrder;
import com.flowingsun.webapp.domain.MealPackage;

@Repository("mealPackageDao")
@Transactional(rollbackFor = Throwable.class)
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
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		MealPackage entity = new MealPackage();// TODO--Spring.getBean
		Map<String, String> fieldMap = entity.GetClassFieldMaps();

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
			if (key.toLowerCase().equals("postion")) {
				HSerchEntity hse = new HSerchEntity();
				hse.ColumnName = "postion";
				hse.ColumnValue = params.get("postion").toString();
				hse.HMachMode = MatchMode.ANYWHERE;
				hses.add(hse);
			} else {
				HSerchEntity hse = new HSerchEntity();
				hse.ColumnName = key;
				if (key.toLowerCase().equals("mealpackageid") || key.toLowerCase().equals("canteenid")) {
					hse.ColumnValue = Integer.parseInt(val);
				} else {
					hse.ColumnValue = val;
				}
				hse.HMachMode = null;
				hses.add(hse);
			}
		}
		return baseDao.LoadPagingEntities(MealPackage.class, hses, page, pageSize);
	}

}
