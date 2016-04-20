package com.flowingsun.webapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flowingsun.webapp.dao.CanteenDao;
import com.flowingsun.webapp.domain.Canteen;

@Service("canteenService")
@Transactional
public class CanteenServiceImpl implements CanteenService {

	@Autowired
	CanteenDao canteenDao;
	
	@Override
	public List<Canteen> FindAllCanteens() {
		return canteenDao.FindAllCanteens();
	}
	
	@Override
	public List<Canteen> GetPagingCanteens(Map<String, Object> params, int page,
			int pageSize) {
		List<Canteen> list = canteenDao.GetPagingCanteens(params, page, pageSize);
		return list;
	}

	/* @author flowingsun
	 * @description 
	 */
	@Override
	public void Update(Canteen canteen) {
		canteenDao.Update(canteen);
	}

	/* @author flowingsun
	 * @description 
	 */
	@Override
	public void Save(Canteen canteen) throws Exception {
		canteenDao.Save(canteen);
	}

}
