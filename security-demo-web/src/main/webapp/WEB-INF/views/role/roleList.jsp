<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Security Demo</title>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/static/images/security.ico">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/matrix/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/matrix/css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/matrix/css/fullcalendar.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/matrix/css/matrix-style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/matrix/css/matrix-media.css" />
	<link href="${pageContext.request.contextPath }/static/matrix/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/matrix/css/jquery.gritter.css" />
	<link href='http://fonts.useso.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>

<body>

	<jsp:include page="../headerAndNav.jsp"></jsp:include>
	
	<jsp:include page="roleListContent.jsp"/>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>