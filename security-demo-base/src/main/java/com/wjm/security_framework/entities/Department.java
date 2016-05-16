package com.wjm.security_framework.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Dept_Table")
@Entity
public class Department {
	private int id;
	private String name;
	
	private Set<User> users = new HashSet<>();
	private Set<SalesRecord> salesRecords = new HashSet<>();
	
	@GeneratedValue
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="dept")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(mappedBy="dept")
	public Set<SalesRecord> getSalesRecords() {
		return salesRecords;
	}

	public void setSalesRecords(Set<SalesRecord> salesRecords) {
		this.salesRecords = salesRecords;
	}	
	
	
}
