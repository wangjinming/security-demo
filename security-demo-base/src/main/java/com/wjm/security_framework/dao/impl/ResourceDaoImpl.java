package com.wjm.security_framework.dao.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wjm.security_framework.dao.ResourceDao;
import com.wjm.security_framework.entities.Resource;

@Repository
public class ResourceDaoImpl extends BaseDao implements ResourceDao {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Resource> getResources() {
		String jpql = "SELECT r FROM Resource r";
		Query query = this.getEntityManager().createQuery(jpql, Resource.class);
		Collection<Resource> resources = query.getResultList();
		return resources;
	}

	@Override
	public Resource getResourceById(int id) {
		Resource resource = getEntityManager().find(Resource.class, id);
		return resource;
	}

	@Override
	public void save(Resource resource) {
		if(resource.getId() > 0) {
			getEntityManager().merge(resource);
		} else {
			getEntityManager().persist(resource);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Resource> getResourceListByIds(Integer[] resourceIds) {
		String jpql = "SELECT r FROM Resource r WHERE r.id IN (:param)";
		Query query = getEntityManager().createQuery(jpql, Resource.class);
		
		List<Integer> list = Arrays.asList(resourceIds);

		query.setParameter("param", list);
		Collection<Resource> roleList = query.getResultList();
		return roleList;
	}

}
