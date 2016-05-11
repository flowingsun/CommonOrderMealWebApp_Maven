package com.flowingsun.webapp.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseDomain {

	private static Map<String, String> _map;

	public Map<String, String> GetClassFieldMaps() {

		if (_map == null || _map.isEmpty()) {
			Map<String, String> map = new HashMap<String, String>();
			Field[] fs = this.getClass().getDeclaredFields();
			for (Field field : fs) {
				field.setAccessible(true);
				String fieldName = field.getName();
				String key = fieldName.toLowerCase();
				map.put(key, fieldName);
			}
			return map;
		} else {
			return _map;
		}
	}
}
