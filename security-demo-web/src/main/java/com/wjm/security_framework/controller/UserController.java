package com.wjm.security_framework.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjm.security_framework.entities.Role;
import com.wjm.security_framework.entities.User;
import com.wjm.security_framework.service.AuthenticationService;
import com.wjm.security_framework.service.AuthorizationService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private AuthenticationService authenService;
	
	@Autowired
	private AuthorizationService authorizeService;
	
	@RequestMapping("listUsers")
	public String getUserList(Map<String, Object> map) {
		
		map.put("users", authenService.getUserList());
		
		return "user/userList";
	}
	
	@RequestMapping("newUser") 
	public String showUserNewView(Map<String, Object> map) {
		
		map.put("departments", authenService.getDeptmentList());
		map.put("user", new User());
		
		return "user/userEdit";
	}
	
	@RequestMapping("save")
	public String save(User user) {
		
		authenService.save(user);
		
		return "redirect:/user/listUsers";
	}
	
	@RequestMapping("edit/{userId}")
	public String showUserEditView(@PathVariable("userId") int userId, 
			Map<String, Object> map) {
		
		map.put("user", authenService.getUserById(userId));
		map.put("departments", authenService.getDeptmentList());
		
		return "user/userEdit";
	}
	
	@RequestMapping("roleSetting/{userId}")
	public String showRoleSettingForUser(@PathVariable("userId") int userId, 
			Map<String, Object> map) {
		
		User user = authenService.getUserAndRoleById(userId);
		Collection<Role> roles = authorizeService.getRoleList();
		Collection<Role> assignedRoles = user.getRoles();
		
		Map<Integer, String> selectionMap = new HashMap<Integer, String>();
		for(Role role : roles) {
			selectionMap.put(role.getId(), "");
			for(Role assignedRole : assignedRoles) {
				if(assignedRole.getId() == role.getId()) {
					selectionMap.put(role.getId(), "checked=\"checked\"");
				} 
			}
			
		}
		map.put("username", user.getName());
		map.put("userId", user.getId());
		map.put("assignedRoles", selectionMap);
		map.put("roles", roles);
		
		return "user/userRoles";
	}
	
	@RequestMapping("updateRoles") 
	@ResponseBody
	public String updateRolesForUser(@RequestParam("userId") long userId, 
			@RequestParam("newAssignedRole") Integer[] roleIds) {
		
		authenService.updateRolesForUser(userId, roleIds);
		
		return "User's role is successfully updated.";
	}
 }
