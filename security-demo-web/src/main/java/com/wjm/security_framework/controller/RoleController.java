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

import com.wjm.security_framework.entities.Resource;
import com.wjm.security_framework.entities.Role;
import com.wjm.security_framework.service.AuthorizationService;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private AuthorizationService authService;
	
	@RequestMapping("listRoles")
	public String getRoleList(Map<String, Object> map) {
		
		Collection<Role> roles = authService.getRoleList();
		
		map.put("roles", roles);
		
		return "role/roleList";
	}
	
	@RequestMapping("edit/{roleId}")
	public String showRoleEditView(@PathVariable("roleId") int roleId, 
			Map<String, Object> map) {
		
		map.put("role", authService.getRoleById(roleId));
		
		return "role/roleEdit";
	}
	
	@RequestMapping("save")
	public String saveRole(Role role) {
		authService.saveRole(role);
		return "redirect:/role/listRoles";
	}
	
	@RequestMapping("newRole")
	public String showRoleNewView(Map<String, Object> map) {
		
		map.put("role", new Role());
		
		return "role/roleEdit";
	}

	@RequestMapping("resourceSetting/{roleId}")
	public String showResourceSettingForRole(@PathVariable("roleId") int roleId, 
			Map<String, Object> map) {
		
		Role role = authService.getRoleAndResourcesById(roleId);
		Collection<Resource> resources = authService.getResourceList();
		Collection<Resource> assignedResources = role.getResources();
		
		Map<Integer, String> selectionMap = new HashMap<Integer, String>();
		for(Resource resource : resources) {
			selectionMap.put(resource.getId(), "");
			for(Resource assignedResource : assignedResources) {
				if(assignedResource.getId() == resource.getId()) {
					selectionMap.put(resource.getId(), "checked=\"checked\"");
				} 
			}
			
		}
		map.put("rolename", role.getName());
		map.put("roleId", role.getId());
		map.put("assignedResources", selectionMap);
		map.put("resources", resources);
		
		return "role/roleResource";
	}
	
	@RequestMapping("updateResources")
	@ResponseBody
	public String updateResources(@RequestParam("roleId") int roleId, 
			@RequestParam("newAssignedResource") Integer[] resourceIds) {
		
		authService.updateResourceForRole(roleId, resourceIds);
		
		return "Role's accessible URL resource is successfully updated.";
	}
	
	@RequestMapping("moduleSetting/{roleId}")
	public String moduleSetting(@PathVariable("roleId") int roleId, 
			Map<String, Object> map) {
		map.put("roleId", roleId);
		return "role/roleModule";
	}
	

}
