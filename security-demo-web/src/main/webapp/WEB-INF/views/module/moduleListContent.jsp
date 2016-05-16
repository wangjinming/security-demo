<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="content">
  		<div id="content-header">
  			 <div id="breadcrumb"> 
  			 	<a href="index.html" title="Go to Home Page" class="tip-bottom"><i class="icon-home"></i> Home</a> 
  			 	<a href="#" class="tip-bottom">System Setting</a> 
  			 	<a href="#" class="current">Module Setting</a> 
  			 </div>
 	 	</div>
		<div class="container-fluid">
    		<hr>
    		<div class="row-fluid">
     			<div class="span12">
			    <div class="widget-box">
    			<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
       			<h5>Module Information</h5>
          		</div>
          		
		        <div class="widget-content nopadding">
		           	<table class="table table-bordered table-striped">
		              	<thead>
		                	<tr>
		                  		<th width="80px">ID</th>
		                  		<th width="80px">Parent ID</th>
		                  		<th>Name</th>
						        <th>Description</th>
						        <th>URL</th>
						        <th width="80px">Edit</th>
		                	</tr>
		              	</thead>
		              			
		              	<tbody>
		              		<c:forEach items="${modules }" var="module">
		                		<tr class="odd gradeX">
		                  			<td>${module.id }</td>
		                  			<td>${module.parentId }</td>
		                  			<td>${module.name }</td>
		                  			<td>${module.desc }</td>
		                  			<td>${module.url }</td>
		                  			<td><a href="${pageContext.request.contextPath }/module/edit/${module.id}"><button class="btn btn-info btn-mini">Edit</button></a></td>	
		               			</tr>	
		               		</c:forEach>                
		              	</tbody>
		           	</table>
		         </div>
		     	</div>
     			</div>
     		</div>
     		
     		<div class="row-fluid">
     			<div class="span10"></div>
     			<div class="span2">
     				<a href="${pageContext.request.contextPath }/module/newModule"><button id="newRoleButton" class="btn btn-warning">New Module</button></a>
     			</div>
     		</div>
     			
		</div>
	</div>
