<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="content">
  		<div id="content-header">
  			 <div id="breadcrumb"> 
  			 	<a href="index.html" title="Go to Home Page" class="tip-bottom"><i class="icon-home"></i> Home</a> 
  			 	<a href="#" class="tip-bottom">System Setting</a> 
  			 	<a href="#" class="current">URL Setting</a> 
  			 </div>
 	 	</div>
		<div class="container-fluid">
    		<hr>
    		<div class="row-fluid">
     			<div class="span12">
			    <div class="widget-box">
    			<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
       			<h5>URL Information</h5>
          		</div>
          		
		        <div class="widget-content nopadding">
		           	<table class="table table-bordered table-striped">
		              	<thead>
		                	<tr>
		                  		<th width="80px">ID</th>
		                  		<th>URL</th>
						        <th>Description</th>
						        <th width="80px">Edit</th>
		                	</tr>
		              	</thead>
		              			
		              	<tbody>
		              		<c:forEach items="${resources }" var="resource">
		                		<tr class="odd gradeX">
		                  			<td>${resource.id }</td>
		                  			<td>${resource.url }</td>
		                  			<td>${resource.desc }</td>
		                  			<td><a href="${pageContext.request.contextPath }/resource/edit/${resource.id}"><button class="btn btn-info btn-mini">Edit</button></a></td>	
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
     				<a href="${pageContext.request.contextPath }/resource/newResource"><button id="newRoleButton" class="btn btn-warning">New URL Resource</button></a>
     			</div>
     		</div>
     			
		</div>
	</div>
