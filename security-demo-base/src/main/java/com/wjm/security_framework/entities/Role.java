package com.wjm.security_framework.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Role_Table")
@Entity
public class Role {
	private int id;
	private String name;
	private String desc;
	private String mark;

	private Set<User> users = new HashSet<>();
	private Set<Module> modules = new HashSet<>();
	private Set<Resource> resources = new HashSet<>();

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

	@Column(name="Role_Desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@ManyToMany(mappedBy="roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@JoinTable(name="Role_Module_Table",
			   joinColumns={@JoinColumn(name="Role_Id")},
			   inverseJoinColumns={@JoinColumn(name="Module_Id")})
	@ManyToMany
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@JoinTable(name="Role_Resource_Table", 
			   joinColumns={@JoinColumn(name="Role_Id")},
			   inverseJoinColumns={@JoinColumn(name="Resource_Id")})
	@ManyToMany
	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

}
