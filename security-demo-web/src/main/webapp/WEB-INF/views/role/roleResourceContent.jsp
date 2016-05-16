<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/static/matrix/js/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#updateRoleResourceBtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath }/role/updateResources",
				data:$("#roleSourceForm").serialize(),
				success:function(result) {
					$.gritter.add({
						text:	result,
						sticky: false
					});		
				}
			});
		});
		
		$("#title-checkbox").click(function(){
			if($("#title-checkbox").attr("checked") == "checked"){
				 $("[name = newAssignedResource]:checkbox").attr("checked", true);
			} else {
				$("[name = newAssignedResource]:checkbox").attr("checked", false);
			}
		});
	})
</script>
<div id="content">
	<div id="content-header">
  		<div id="breadcrumb"> 
  			<a href="index.html" title="Go to Home Page" class="tip-bottom"><i class="icon-home"></i> Home</a> 
  			<a href="#" class="tip-bottom">System Setting</a> 
  			<a href="#" class="current">URL Setting</a> 
  		</div>
 	</div>
 	 
 	<form id="roleSourceForm" action="${pageContext.request.contextPath }/role/updateResource">
 		<input type="hidden" name="roleId" value="${roleId }"/>
		<div class="container-fluid">
    		<hr>
    		<div class="row-fluid">
    		<div class="span12">
				<div class="widget-box">
			    	<div class="widget-title"> 
			    	<span class="icon">
			            <input type="checkbox" id="title-checkbox" name="title-checkbox" />
			        </span>
			            <h5>URL Setting for :<font color="RED">${roleName }</font></h5>
			        </div>
			        <div class="widget-content nopadding">
			        	<table class="table table-bordered table-striped with-check">
			            	<thead>
			                	<tr>
			                  		<th><i class="icon-resize-vertical"></i></th>
			                 		<th>ID</th>
		                  			<th>URL</th>
						        	<th>Description</th>						    
			               		</tr>
			              	</thead>
			            <tbody>			              
			              	<c:forEach items="${resources }" var="resource">
			              		<tr class="odd gradeX">
			              			<td><input type="checkbox" name="newAssignedResource" value=${resource.id } ${assignedResources[resource.id]}/></td>
			              			<td>${resource.id } </td>
		                  			<td>${resource.url }</td>
		                  			<td>${resource.desc }</td>	
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
     				<input type="button" id="updateRoleResourceBtn" value="Update" class="btn btn-warning">
     			</div>
     		</div>
		</div>
	</form> 
</div>