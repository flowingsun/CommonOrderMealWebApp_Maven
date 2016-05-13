package com.flowingsun.webapp.dao.common;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	//public List<T> FindAllEntities();

	public T FindEnityById(Long Id);

	public void Update(T entity);

	public void Save(T entity);

	//public void Delete(T entity);

	public void ChangeState(int id,int state);

	public List<T> GetPagingEntities(Map<String, Object> params, int page, int pageSize);
}
