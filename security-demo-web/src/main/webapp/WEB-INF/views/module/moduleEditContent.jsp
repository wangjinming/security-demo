<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    		<div class="span3"></div>
    		<div class="span6">
     			<div class="widget-box">
        			<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          				<h5>URL Info</h5>
       				</div>
       				
			        <div class="widget-content nopadding">
			        	<form:form action="${pageContext.request.contextPath}/module/save" method="POST" class="form-horizontal" modelAttribute="module">
			            	<form:input type="hidden" path="id"/>
			            	<div class="control-group">
			              		<label class="control-label">Parent ID :</label>
			              		<div class="controls">
			               		<form:input type="text" path="parentId" class="span11" />
			             		</div>
			           		</div>
			            	
			            	<div class="control-group">
			              		<label class="control-label">name</label>
			              		<div class="controls">
			                	<form:input type="text" path="name" class="span11" />
			             		</div>
			            	</div>
			            	
			            	<div class="control-group">
			              		<label class="control-label">Description :</label>
			              		<div class="controls">
			                	<form:input type="text" path="desc" class="span11" />
			             		</div>
			            	</div>
			            	
			            	<div class="control-group">
			              		<label class="control-label">URL :</label>
			              		<div class="controls">
			                	<form:input type="text" path="url" class="span11" />
			             		</div>
			            	</div>
			            	
			            	<div class="form-actions">
			              		<button type="submit" class="btn btn-success">Save</button>
			            	</div>
			          	</form:form>
			        </div>
			     </div>
     			 </div>
     			 <div class="span3"></div>
     		</div>
		</div>
	</div>