package com.wjm.security_framework.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjm.security_framework.dao.DepartmentDao;
import com.wjm.security_framework.dao.RoleDao;
import com.wjm.security_framework.dao.UserDao;
import com.wjm.security_framework.entities.Department;
import com.wjm.security_framework.entities.MenuNode;
import com.wjm.security_framework.entities.Module;
import com.wjm.security_framework.entities.Role;
import com.wjm.security_framework.entities.User;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Transactional(readOnly=true)
	public User getUserByName(String username) {
		return userDao.getByUsername(username);
	}
	
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Collection<GrantedAuthority> loadUserAuthorities(String username){
		Set<Role> roles = userDao.getRolesByUserName(username);
		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		Iterator<Role> roleIterator = roles.iterator();
		while(roleIterator.hasNext()) {
			Role role = roleIterator.next();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getMark());
			auths.add(grantedAuthority);
		}		

		return auths;
	}
	
	@Transactional(readOnly=true)
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}
	
	@Transactional(readOnly=true)
	public User getUserAndRoleById(long id) {
		User user = userDao.getUserById(id);
		
		Hibernate.initialize(user.getRoles());
		
		return user;
	}
	
	@Transactional(readOnly=false)
	public void save(User user) {
		userDao.save(user);
	}
	
	@Transactional(readOnly=true)
	public Collection<User> getUserList() {
		return userDao.getUserList();
	}
	
	@Transactional(readOnly=true)
	public Collection<Department> getDeptmentList() {
		return deptDao.getDeptmentList();
	}
	
	@Transactional(readOnly=false)
	public void updateRolesForUser(long userId, Integer[] roleIds) {
		User user = userDao.getUserById(userId);
		Collection<Role> roles = roleDao.getRoleListByIds(roleIds);		
		user.setRoles(new HashSet<Role>(roles));
		
		userDao.save(user);	
	}
	
	@Transactional(readOnly=false)
	public List<MenuNode> getModulesByUser(String username) {
		List<MenuNode> result = new ArrayList<>();
		
		List<Module> modules = userDao.getModulesByUser(username);
		
		//Assume that the menu structure has only two layers
		for(Module module : modules) {
			if(module.getParentId() == -1) {
				MenuNode menuNode = new MenuNode(module);				
				result.add(menuNode);
			}
		}
		
		for(Module module : modules) {
			for(MenuNode parent : result) {
				if(module.getParentId() == parent.getId()) {
					parent.addChild(new MenuNode(module));
				}
			}
		}
		return result;		
	}
}
