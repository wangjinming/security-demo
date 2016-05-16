package com.wjm.security_framework.dao;

import java.util.Collection;

import com.wjm.security_framework.entities.Resource;

public interface ResourceDao {
	
	Resource getResourceById(int id);
	
	Collection<Resource> getResources();
	
	void save(Resource resource);

	Collection<Resource> getResourceListByIds(Integer[] resourceIds);
}
