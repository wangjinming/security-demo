package com.wjm.security_framework.dao.impl;

import java.util.Collection;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wjm.security_framework.dao.DepartmentDao;
import com.wjm.security_framework.entities.Department;

@Repository
public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Department> getDeptmentList() {
		String jpql = "SELECT d FROM Department d";
		Query query = getEntityManager().createQuery(jpql, Department.class);
		return query.getResultList();
	}

}
