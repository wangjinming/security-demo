package com.wjm.security_framework.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.wjm.security_framework.entities.Module;
import com.wjm.security_framework.entities.Role;
import com.wjm.security_framework.entities.User;

public interface UserDao {
	
	public User getByUsername(String username);
	
	public Set<Role> getRolesByUserName(String username);
	
	public User getUserById(long id);
	
	public Collection<User> getUserList();
	
	public void save(User user);
	
	public List<Module> getModulesByUser(String username);
}
