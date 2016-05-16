package com.wjm.security_framework.dao;

import java.util.Collection;

import com.wjm.security_framework.entities.Module;

public interface ModuleDao {
	Collection<Module> getModuleList();

	Module getModuleById(int moduleId);

	void save(Module module);

	Collection<Module> getModuleListByIds(Integer[] moduleIdArry);
}
