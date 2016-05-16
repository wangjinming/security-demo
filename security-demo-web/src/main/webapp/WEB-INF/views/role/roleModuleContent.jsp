<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/styles/jqx.base.css" type="text/css" />
<script src="${pageContext.request.contextPath }/static/matrix/js/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function () {
	$("input").click(function(){
		var str = "";
	    var items = $('#jqxWidget').jqxTree('getCheckedItems');
	    for (var i = 0; i < items.length; i++) {
	        var item = items[i];
	        str += item.value + ",";
	    }
	    
	    var param = {"newAssignedModule" : str};
	    $.ajax({
	    	dataType:"json",
			data:param,
			url: "${pageContext.request.contextPath }/module/updateModules/${roleId}",
			success: function (result) {
				$.gritter.add({
					text:	result.message,
					sticky: false
				});	
			}
		});
	    
	});
	var jsondata = null;
	$.ajax({
		async: false,
		url: "${pageContext.request.contextPath }/module/getAllModuleTree/${roleId}",
		success: function (data, status, xhr) {
			jsondata = data;
		}
	});
    
	// prepare the data
    var source = {
        datatype: "json",
        datafields: [
            { name: 'id' },
            { name: 'parentid' },
            { name: 'text' },
            { name: 'value' },
            { name: 'checked' }
        ],
        id: 'id',
        localdata: jsondata
    };

    var dataAdapter = new $.jqx.dataAdapter(source);
    dataAdapter.dataBind();
    var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', [{ name: 'text', map: 'label'}]);
    $('#jqxWidget').jqxTree({ source: records, checkboxes: true});
    $('#jqxWidget').jqxTree("expandAll");
});

</script>	
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
     			
    		<div class="span9">    
				<div id='jqxWidget' style='float: center; margin-left: 20px;'></div>
			       
     		</div>
     		<div class="span3"><input type="button" value="Update" class="btn btn-warning"/></div>
     		</div>
    		
		</div>
	</div>
