<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path2 = request.getContextPath();
	String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path2 + "/";
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script type="text/javascript">
	var Goble_UserName = '${user.userName}';
</script>
<link rel="stylesheet"
	href="<%=basePath2%>Resources/bootstrap/dist/css/bootstrap.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="<%=basePath2%>Resources/bootstrap/dist/css/bootstrap-theme.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="<%=basePath2%>Resources/css/Platform/Main.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=basePath2%>Resources/JavaScripts/json2.js"></script>
<script type="text/javascript"
	src="<%=basePath2%>Resources/JavaScripts/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="<%=basePath2%>Resources/bootstrap/dist/js/bootstrap.js"></script>
<link href="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png"
	type="image/x-icon" rel="icon" />

