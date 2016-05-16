package com.wjm.security_framework.entities;

public class TreeNode {
	private String id;
	private String parentid;
	private String text;
	private String value;
	private boolean checked;
	
	public TreeNode() {
		
	}
	
	public TreeNode(Module module) {
		this.id = "" + module.getId();
		this.parentid = "" +module.getParentId();
		this.text = module.getName();
		checked = false;
		value = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
