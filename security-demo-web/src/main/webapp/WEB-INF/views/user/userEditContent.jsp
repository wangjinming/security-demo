<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    		<div class="span3"></div>
    		<div class="span6">
     			<div class="widget-box">
        			<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          				<h5>Role Info</h5>
       				</div>
       				
			        <div class="widget-content nopadding">
			        	<form:form action="${pageContext.request.contextPath}/user/save" method="POST" 
			        			   class="form-horizontal" modelAttribute="user">
			            	<form:input type="hidden" path="id"/>
			            	<div class="control-group">
			              		<label class="control-label">Name :</label>
			              		<div class="controls">
			               		<form:input type="text" path="name" class="span11" />
			             		</div>
			           		</div>
			            	<div class="control-group">
			              		<label class="control-label">Password :</label>
			              		<div class="controls">
			                	<form:input type="password" path="password" class="span11" />
			             		</div>
			            	</div>
			            	<div class="control-group">
			              		<label class="control-label">Gender :</label>
			              		<div class="controls">
					                <label>
					                  <input type="radio" name="gender" value="1" checked="${user.gender==1 }"/>
					                  Male</label>
					                <label>
					                  <input type="radio" name="gender" value="0" checked="${user.gender==0 }"/>
					                  Female</label>
					                
					            </div>
			            	</div>
			            	
			            	<div class="control-group">
					            <label class="control-label">Select input</label>
					            <div class="controls">
					                <form:select path="dept.id" class="span11" 
					                	items="${departments }" itemLabel="name" itemValue="id">
					                  
					                </form:select>
					            </div>
					        </div>
			            	<div class="control-group">
			             		<label class="control-label">Email :</label>
			              		<div class="controls">
			                		<form:input type="text" path="email" class="span11" />
			              		</div>
			            	</div>
			            	<div class="control-group">
			             		<label class="control-label">Is Valid :</label>
			              		<div class="controls">
			                		<form:input type="text" path="enabled" class="span11" />
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