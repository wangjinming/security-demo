package com.wjm.security_framework.entities;

import java.util.ArrayList;
import java.util.List;

public class MenuNode {
	private int id;
	private int parentId;
	private String text;
	private String url;
	private List<MenuNode> children = new ArrayList<>();
	
	public MenuNode(){
		
	} 
	
	public MenuNode(Module module) {
		this.id = module.getId();
		this.parentId = module.getParentId();
		this.text = module.getName();
		this.url = module.getUrl();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuNode> getChildren() {
		return children;
	}

	public void setChildren(List<MenuNode> children) {
		this.children = children;
	}
	
	public int getChildCount() {
		return children.size();
	}
	
	public boolean getHasChild() {
		return children.size() > 0;
	}
	
	public void addChild(MenuNode child) {
		children.add(child);
	}
}
