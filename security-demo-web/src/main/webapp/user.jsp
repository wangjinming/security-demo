<!DOCTYPE html>
<html lang="en">
<head>
    <title id='Description'>In this demo the jqxTree is built from JSON data.</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/styles/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/scripts/demos.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxpanel.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxtree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/jqwidgets/jqwidgets/jqxcheckbox.js"></script>
</head>
<body>
    <div id='content'>
        <script type="text/javascript">
        
        $(document).ready(function () {
        	var jsondata = null;
			$.ajax({
       			async: false,
        		url: "${pageContext.request.contextPath }/module/getAllModuleTree",
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
                    { name: 'checked' }
                ],
                id: 'id',
                localdata: jsondata
            };

            var dataAdapter = new $.jqx.dataAdapter(source);
            dataAdapter.dataBind();
            var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', [{ name: 'text', map: 'label'}]);
            $('#jqxWidget').jqxTree({ source: records, width: '300px', checkboxes: true});
				
        });
        </script>
        <div id='jqxWidget'>
        </div>
    </div>
</body>
</html>
