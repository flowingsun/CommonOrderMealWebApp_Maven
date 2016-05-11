<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path2 = request.getContextPath();
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path2 + "/";
%>

<script type="text/javascript">
	var Golbal_UserName = '${user.userName}';
	var Golbal_BasePath = '<%=basePath2%>'; 
</script>
<script type="text/javascript"
	src="<%=basePath2%>Resources/JavaScripts/json2.js"></script>
<script type="text/javascript"
	src="<%=basePath2%>Resources/JavaScripts/ExtJS/bootstrap.js"></script>
<link rel="stylesheet"
	href="<%=basePath2%>Resources/JavaScripts/ExtJS/resources/css/ext-all-gray-debug.css"
	type="text/css"></link>
<link href="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png" type="image/x-icon" rel="icon" /> 