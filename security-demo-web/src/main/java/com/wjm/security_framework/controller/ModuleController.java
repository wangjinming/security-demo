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

import com.wjm.security_framework.entities.Module;
import com.wjm.security_framework.entities.TreeNode;
import com.wjm.security_framework.service.AuthorizationService;

@Controller
@RequestMapping("module")
public class ModuleController {
	@Autowired
	private AuthorizationService authService;
	
	@RequestMapping("listModules")
	public String listModules(Map<String, Object> map) {
		map.put("modules", authService.getModuleList());
		return "module/moduleList";
	}
	
	@RequestMapping("getAllModuleTree/{roleId}")
	@ResponseBody
	public Collection<TreeNode> getAllModuleTree(@PathVariable("roleId") int roleId) {
		return authService.getAllModules(roleId);
	}
	
	@RequestMapping("newModule")
	public String newModule(Map<String, Object> map) {
		map.put("module", new Module());
		
		return "module/moduleEdit";
	}
	
	@RequestMapping("edit/{moduleId}")
	public String showModuleEditView(@PathVariable("moduleId") int moduleId, 
			Map<String, Object> map) {
		
		map.put("module", authService.getModuleById(moduleId));
		
		return "module/moduleEdit";
	}
	
	@RequestMapping("save")
	public String saveModule(Module module) {
		authService.saveModule(module);
		return "redirect:/module/listModules";
	}
	
	@RequestMapping("updateModules/{roleId}")
	@ResponseBody
	public Map<String, Object> updateModules(@PathVariable("roleId") int roleId, 
			@RequestParam("newAssignedModule") String moduleIds) {
		
		authService.updateModuleForRole(roleId, moduleIds);
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Role's accessible modules are successfully updated.");
		return map;
	}
}
