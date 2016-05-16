package com.flowingsun.webapp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.MealMenuDao;
import com.flowingsun.webapp.domain.MealMenu;
import com.flowingsun.webapp.service.MealMenuService;

@Service("mealMenuService")
@Transactional
public class MealMenuServiceImpl implements MealMenuService {

	@Autowired
	private MealMenuDao mealMenuDao;

	@Override
	public MealMenu getMealMenuById(Long id) {
		return mealMenuDao.FindEnityById(id);
	}

	@Override
	public List<MealMenu> GetPagingMealMenus(Map<String, Object> params, int page, int pageSize) {
		List<MealMenu> list = mealMenuDao.GetPagingEntities(params, page, pageSize);
		return list;
	}

	@Override
	public void Update(MealMenu mealMenu) {
		mealMenuDao.Update(mealMenu);
	}

	@Override
	public void Save(MealMenu mealMenu) throws Exception {
		mealMenuDao.Save(mealMenu);
	}

	@Override
	public List<Integer> GetAvailableMealMenuIds() {
		return mealMenuDao.GetAvailableMealMenuIds();
	}

	@Override
	public List<MealMenu> GetAvailableMealMenus() {
		return mealMenuDao.GetAvailableMealMenus();
	}

}
