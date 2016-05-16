<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	<div id="header"><h1><a href="">Security Demo</a></h1></div>

	<!--top-Header-menu-->
	<div id="user-nav" class="navbar navbar-inverse">
 	<ul class="nav">
   		<li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
     		<ul class="dropdown-menu">
        		<li><a href="#"><i class="icon-user"></i> My Profile</a></li>
        		<li class="divider"></li>
        		<li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
        		<li class="divider"></li>
        		<li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
      		</ul>
    	</li>
   
    	<li class=""><a title="" href="${pageContext.request.contextPath }/logout"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
 	</ul>
	</div>
		
	<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Security Demo</a>
  	<ul>
  	<c:forEach items="${sessionScope.menus }" var="menu">
  		<li class="submenu"> <a href="#"><i class="icon icon-cog"></i> <span>${menu.text }</span> <span class="label label-important">${menu.childCount }</span></a>
  			<ul>
  				<c:forEach items="${menu.children }" var="child">
  					<li><a href="${pageContext.request.contextPath }/${child.url}">${child.text }</a></li>
  				</c:forEach>
  			</ul>
  		</li>
  	</c:forEach>
  	</ul>
  	
	</div>