package com.wjm.security_framework.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wjm.security_framework.dao.ModuleDao;
import com.wjm.security_framework.entities.Module;

@Repository
public class ModuleDaoImpl extends BaseDao implements ModuleDao {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Module> getModuleList() {
		Collection<Module> result = new ArrayList<>();
		
		String jpql = "SELECT m FROM Module m";
		Query query = getEntityManager().createQuery(jpql, Module.class);
		result = query.getResultList();
		
		return result;
	}

	@Override
	public Module getModuleById(int moduleId) {
		Module module = getEntityManager().find(Module.class, moduleId);
		return module;
	}

	@Override
	public void save(Module module) {

		if(module.getId() > 0) {
			getEntityManager().merge(module);
		} else {
			getEntityManager().persist(module);
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Module> getModuleListByIds(Integer[] moduleIdArry) {
		String jpql = "SELECT m FROM Module m WHERE m.id IN (:param)";
		Query query = getEntityManager().createQuery(jpql, Module.class);
		
		List<Integer> list = Arrays.asList(moduleIdArry);

		query.setParameter("param", list);
		Collection<Module> moduleList = query.getResultList();
		return moduleList;
	}

}
