package com.wjm.security_framework.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjm.security_framework.entities.Resource;
import com.wjm.security_framework.service.AuthorizationService;

@Controller
@RequestMapping("resource")
public class ResourceController {
	@Autowired
	private AuthorizationService authService;
	
	@RequestMapping("listResource")
	public String showResourceView(Map<String, Object> map) {
		
		map.put("resources", authService.getResourceList());
		
		return "resource/resourceList";
	}
	
	@RequestMapping("edit/{resourceId}")
	public String showResourceEditView(@PathVariable("resourceId") int resourceId, 
			Map<String, Object> map) {
		
		map.put("resource", authService.getResourceById(resourceId));
		
		return "resource/resourceEdit";
	}
	
	@RequestMapping("save")
	public String saveResource(Resource resource) {
		authService.saveResource(resource);
		return "redirect:/resource/listResource";
	}
	
	@RequestMapping("newResource")
	public String showResourceNewView(Map<String, Object> map) {
		
		map.put("resource", new Resource());
		
		return "resource/resourceEdit";
	}
}
