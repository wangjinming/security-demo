package com.wjm.security_framework.authrization;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import com.wjm.security_framework.service.AuthorizationService;

/*
 * 
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配，
 * 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入，
 * 如果一个类要进行实例化的时候，不能注入对象和操作对象，
 * 所以在构造函数里不能进行操作注入的数据。
 */

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private AntPathMatcher urlMatcher = new AntPathMatcher();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	@Autowired
	private AuthorizationService authService;
	
	public  void loadResourceDefine()throws Exception  {
		resourceMap = authService.getResourceMap();
		
		//通过硬编码设置，resouce和role
//		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
//		ConfigAttribute adminConfig = new SecurityConfig("ROLE_ADMIN"); 
//		ConfigAttribute userConfig = new SecurityConfig("ROLE_USER"); 
//		
//		Collection<ConfigAttribute> admin = new ArrayList<ConfigAttribute>();
//		admin.add(adminConfig); 
//		
//		Collection<ConfigAttribute> user = new ArrayList<ConfigAttribute>();
//		user.add(userConfig);
//		
//		Collection<ConfigAttribute> both = new ArrayList<ConfigAttribute>();
//		both.add(adminConfig);
//		both.add(userConfig);
//		
//		resourceMap.put("/user/**", admin); 
//		resourceMap.put("/user.jsp", user); 
//		resourceMap.put("/index", both); 
		
	}
	
	// According to a URL, Find out permission configuration of this URL.
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		// guess object is a URL.
		String url = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.match(resURL, url)) {
				Collection<ConfigAttribute> returnCollection = resourceMap.get(resURL);
				return returnCollection;
			}
		}
		
		return null;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allConfigAttr = new HashSet<>();
		
		for(Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
			allConfigAttr.addAll(entry.getValue());
		}
		return allConfigAttr;
	}

}
