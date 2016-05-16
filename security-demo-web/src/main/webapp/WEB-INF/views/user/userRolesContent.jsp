<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/static/matrix/js/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#updateUserRoleBtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath }/user/updateRoles",
				data:$("#userRoleForm").serialize(),
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
				 $("[name = newAssignedRole]:checkbox").attr("checked", true);
			} else {
				$("[name = newAssignedRole]:checkbox").attr("checked", false);
			}
		});
	})
</script>
<div id="content">
	<div id="content-header">
  		<div id="breadcrumb"> 
  			<a href="index.html" title="Go to Home Page" class="tip-bottom"><i class="icon-home"></i> Home</a> 
  			<a href="#" class="tip-bottom">System Setting</a> 
  			<a href="#" class="current">Role Setting</a> 
  		</div>
 	</div>
 	 
 	<form id="userRoleForm" action="${pageContext.request.contextPath }/user/updateRoles">
 		<input type="hidden" name="userId" value="${userId }"/>
		<div class="container-fluid">
    		<hr>
    		<div class="row-fluid">
    		<div class="span12">
				<div class="widget-box">
			    	<div class="widget-title"> 
			    	<span class="icon">
			            <input type="checkbox" id="title-checkbox" name="title-checkbox" />
			        </span>
			            <h5>Role Setting for :<font color="RED">${username }</font></h5>
			        </div>
			        <div class="widget-content nopadding">
			        	<table class="table table-bordered table-striped with-check">
			            	<thead>
			                	<tr>
			                  		<th><i class="icon-resize-vertical"></i></th>
			                 		<th>Role ID</th>
		                  			<th>Role Name</th>
						        	<th>Role Mark</th>
						        	<th>Role Description</th>  
			               		</tr>
			              	</thead>
			            <tbody>			              
			              	<c:forEach items="${roles }" var="role">
			              		<tr class="odd gradeX">
			              			<td><input type="checkbox" name="newAssignedRole" value=${role.id } ${assignedRoles[role.id]}/></td>
			              			<td>${role.id } </td>
		                  			<td>${role.name }</td>
		                  			<td>${role.mark }</td>
		                  			<td>${role.desc }</td>	
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
     				<input type="button" id="updateUserRoleBtn" value="Update" class="btn btn-warning">
     			</div>
     		</div>
		</div>
	</form> 
</div>