<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="content">
  		<div id="content-header">
  			 <div id="breadcrumb"> 
  			 	<a href="index.html" title="Go to Home Page" class="tip-bottom"><i class="icon-home"></i> Home</a> 
  			 	<a href="#" class="tip-bottom">System Setting</a> 
  			 	<a href="#" class="current">User Setting</a> 
  			 </div>
 	 	</div>
		<div class="container-fluid">
    		<hr>
    		<div class="row-fluid">
     			<div class="span12">
     				<div class="widget-box">
          				<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            			<h5>User Information</h5>
          				</div>
          		
		          		<div class="widget-content nopadding">
		           			<table class="table table-bordered table-striped">
		              			<thead>
		                			<tr>
		                  				<th>ID</th>
		                  				<th>Name</th>
						                <th>Gender</th>
						                <th>Department</th>
						                <th>Email</th>  
						                <th>Valid</th>  
						                <th width="40px">Edit</th>
						                <th width="40px">View</th>   
		                			</tr>
		              			</thead>
		              			
		              			<tbody>
		              			<c:forEach items="${users }" var="user">
		                			<tr class="odd gradeX">
		                  				<td>${user.id }</td>
		                  				<td>${user.name }</td>
		                  				<td>${user.gender==0? "Female":"Male" }</td>
		                  				<td>${user.dept.name }</td>	
		                  				<td>${user.email }</td>
		                  				<td>${user.enabled }</td>
		                  				<td><a href="${pageContext.request.contextPath }/user/edit/${user.id}"><button class="btn btn-info btn-mini">Edit</button></a></td>	
		                  				<td><a href="${pageContext.request.contextPath }/user/roleSetting/${user.id}"><button class="btn btn-success btn-mini">Role</button></a></td>		                  	
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
     				<a href="${pageContext.request.contextPath }/user/newUser"><button id="newUserButton" class="btn btn-warning ">New User</button></a>
     			</div>
     			</div>
     		</div>
		</div>
	</div>
