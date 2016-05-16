package com.wjm.security_framework.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjm.security_framework.dao.ModuleDao;
import com.wjm.security_framework.dao.ResourceDao;
import com.wjm.security_framework.dao.RoleDao;
import com.wjm.security_framework.entities.Module;
import com.wjm.security_framework.entities.Resource;
import com.wjm.security_framework.entities.Role;
import com.wjm.security_framework.entities.TreeNode;

@Service
public class AuthorizationService {
	
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	@Transactional(readOnly=true)
	public Map<String, Collection<ConfigAttribute>> getResourceMap() {
		Map<String, Collection<ConfigAttribute>> resourceMap = 
				new HashMap<String, Collection<ConfigAttribute>>();
		
		Collection<Resource> resources = resourceDao.getResources();
		for(Resource resource : resources) {
			String resourceUrl = resource.getUrl();
			Set<Role> roles = resource.getRoles();
			Iterator<Role> roleIter = roles.iterator();
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
			while(roleIter.hasNext()) {
				Role role = roleIter.next();
				ConfigAttribute configAttribute = new SecurityConfig(role.getMark());
				configAttributes.add(configAttribute);
			}
			resourceMap.put(resourceUrl, configAttributes);
		}
		
		return resourceMap;
	}
	
	@Transactional(readOnly=true)
	public Collection<Role> getRoleList() {
		return roleDao.getRoleList();
	}
	
	@Transactional(readOnly=true)
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveRole(Role role) {
		roleDao.save(role);
	}
	
	@Transactional(readOnly=true)
	public Collection<Resource> getResourceList() {
		return resourceDao.getResources();
	}
	
	@Transactional(readOnly=true)
	public Resource getResourceById(int id) {
		return resourceDao.getResourceById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveResource(Resource resource) {
		resourceDao.save(resource);
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateResourceForRole(int roleId, Integer[] resourceIds) {
		Role role = roleDao.getRoleById(roleId);
		Collection<Resource> resources = resourceDao.getResourceListByIds(resourceIds);
		role.setResources(new HashSet<Resource>(resources));
		
		roleDao.save(role);	
		
	}

	@Transactional(readOnly=true)
	public Role getRoleAndResourcesById(int roleId) {
		Role role = roleDao.getRoleById(roleId);
		
		Hibernate.initialize(role.getResources());
		
		return role;
	}
	
	@Transactional(readOnly=true)
	public Collection<Module> getModuleList() {
		Collection<Module> modules = moduleDao.getModuleList();
		return modules;
	}
	
	@Transactional(readOnly=true)
	public Collection<TreeNode> getAllModules(int roleId) {
		Role role = roleDao.getRoleById(roleId);
		Set<Module> modulesForRole = role.getModules();
		
		Collection<TreeNode> moduleTreeNodes = new ArrayList<>();
		
		Collection<Module> modules = moduleDao.getModuleList();
		Iterator<Module> moduleIter = modules.iterator();
		
		while(moduleIter.hasNext()) {
			Iterator<Module> modulesForRoleIter = modulesForRole.iterator();
			Module module = moduleIter.next();
			TreeNode treeNode = new TreeNode(module);
			while(modulesForRoleIter.hasNext()) {
				Module moduleForRole = modulesForRoleIter.next();
				if(moduleForRole.getId() == module.getId()) {
					treeNode.setChecked(true);
				}
			}
			moduleTreeNodes.add(treeNode);
		}
		
		
		return moduleTreeNodes;
	}

	@Transactional(readOnly=true)
	public Module getModuleById(int moduleId) {
		Module module = moduleDao.getModuleById(moduleId);
		
		return module;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveModule(Module module) {
		moduleDao.save(module);		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void updateModuleForRole(int roleId, String moduleIds) {
		Role role = roleDao.getRoleById(roleId);
		StringTokenizer token = new StringTokenizer(moduleIds, ",");
		Integer[] moduleIdArry = new Integer[token.countTokens()];
		int i = 0;
		while(token.hasMoreTokens()) {
			moduleIdArry[i++] = Integer.valueOf(token.nextToken());
		}
		Collection<Module> modules = moduleDao.getModuleListByIds(moduleIdArry);
		role.setModules(new HashSet<Module>(modules));
		
		roleDao.save(role);	
	}
}
