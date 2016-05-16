package com.wjm.security_framework.dao.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wjm.security_framework.dao.RoleDao;
import com.wjm.security_framework.entities.Role;

@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao{

	@Override
	public Role getRoleById(int id) {
		Role role = getEntityManager().find(Role.class, id);
		return role;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Role> getRoleList() {
		String jpql = "SELECT r FROM Role r";
		Query query = this.getEntityManager().createQuery(jpql, Role.class);
		
		Collection<Role> roles = query.getResultList();
		return roles;
	}

	@Override
	public void save(Role role) {
		if(role.getId() > 0) {
			getEntityManager().merge(role);
		} else {
			getEntityManager().persist(role);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Role> getRoleListByIds(Integer[] roleIds) {
		String jpql = "SELECT r FROM Role r WHERE r.id IN (:param)";
		Query query = getEntityManager().createQuery(jpql, Role.class);
		
		List<Integer> list = Arrays.asList(roleIds);

		query.setParameter("param", list);
		Collection<Role> roleList = query.getResultList();
		return roleList;
	}
	
}
