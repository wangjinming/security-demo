package com.wjm.security_framework.dao;

import java.util.Collection;

import com.wjm.security_framework.entities.Role;

public interface RoleDao {
	
	public Role getRoleById(int id);
	
	public Collection<Role> getRoleList();
	
	public void save(Role role);
	
	public Collection<Role> getRoleListByIds(Integer[] roleIds);
}
