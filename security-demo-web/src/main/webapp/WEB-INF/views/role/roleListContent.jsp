<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="content">
  		<div id="content-header">
  			 <div id="breadcrumb"> 
  			 	<a href="index.html" title="Go to Home Page" class="tip-bottom"><i class="icon-home"></i> Home</a> 
  			 	<a href="#" class="tip-bottom">System Setting</a> 
  			 	<a href="#" class="current">Role Setting</a> 
  			 </div>
 	 	</div>
		<div class="container-fluid">
    		<hr>
    		<div class="row-fluid">
     			<div class="span12">
     				<div class="widget-box">
          				<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            			<h5>Role Information</h5>
          				</div>
          		
		          		<div class="widget-content nopadding">
		           			<table class="table table-bordered table-striped">
		              			<thead>
		                			<tr>
		                  				<th>Role ID</th>
		                  				<th>Role Name</th>
						                <th>Role Mark</th>
						                <th>Role Description</th>  
						                <th width="40px">Edit</th>
						                <th width="40px">URL</th>   
						                 <th width="40px">Module</th>   
		                			</tr>
		              			</thead>
		              			
		              			<tbody>
		              			<c:forEach items="${roles }" var="role">
		                			<tr class="odd gradeX">
		                  				<td>${role.id }</td>
		                  				<td>${role.name }</td>
		                  				<td>${role.mark }</td>
		                  				<td>${role.desc }</td>	
		                  				<td><a href="${pageContext.request.contextPath }/role/edit/${role.id}"><button class="btn btn-info btn-mini">Edit</button></a></td>	
		                  				<td><a href="${pageContext.request.contextPath }/role/resourceSetting/${role.id}"><button class="btn btn-success btn-mini">URL</button></a></td>
		                  				<td><a href="${pageContext.request.contextPath }/role/moduleSetting/${role.id}"><button class="btn btn-warning btn-mini">Module</button></a></td>		                  	
		               				 </tr>	
		               			</c:forEach>                
		              			</tbody>
		           			</table>
		         		 </div>
		        	</div>
     			</div>
     			
     			<div class="row-fluid">
     			<div class="span10"></div>
     			<div class="span2">
     				<a href="${pageContext.request.contextPath }/role/newRole"><button id="newRoleButton" class="btn btn-warning">New Role</button></a>
     			</div>
     			</div>
     		</div>
		</div>
	</div>
