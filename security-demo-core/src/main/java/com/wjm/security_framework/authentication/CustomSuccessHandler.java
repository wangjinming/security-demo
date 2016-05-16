package com.wjm.security_framework.authentication;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.wjm.security_framework.entities.MenuNode;
import com.wjm.security_framework.service.AuthenticationService;

public class CustomSuccessHandler 
				extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Autowired
	private AuthenticationService authenService;
	
	@Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
            final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);
        
        String username = authentication.getName();
        List<MenuNode> menus = authenService.getModulesByUser(username);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("menus", menus);
    }
}
