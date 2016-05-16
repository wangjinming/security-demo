package com.wjm.security_framework.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wjm.security_framework.dao.UserDao;
import com.wjm.security_framework.entities.Module;
import com.wjm.security_framework.entities.Role;
import com.wjm.security_framework.entities.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User getByUsername(String username) {
		String jpql = "SELECT u FROM User u WHERE u.name = ?";
		Query query = getEntityManager().createQuery(jpql, User.class);
		query.setParameter(1, username);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public Set<Role> getRolesByUserName(String username) {
		User user = getByUsername(username);
		return user.getRoles();
	}

	@Override
	public User getUserById(long id) {		
		return getEntityManager().find(User.class, id);
	}

	@Override
	public void save(User user) {
		if(user.getId() >0L) {
			getEntityManager().merge(user);
		} else {
			getEntityManager().persist(user);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> getUserList() {
		String jpql = "SELECT u FROM User u";
		Query query = getEntityManager().createQuery(jpql, User.class);
		return query.getResultList();
	}
	
	@Override
	public List<Module> getModulesByUser(String username) {
		List<Module> modules = new ArrayList<>();
		User user = getByUsername(username);
		Set<Role> roles = user.getRoles();
		Iterator<Role> rolesIter = roles.iterator();
		while(rolesIter.hasNext()) {
			Role role = rolesIter.next();
			Set<Module> roleModuels = role.getModules();
			modules.addAll(roleModuels);
		}
		
		return modules;
	}
}
