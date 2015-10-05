<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	pageContext.setAttribute("user",
			request.getSession().getAttribute("user"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>订餐系统后台首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@include file="_themes.jsp"%>
<script type="text/javascript"
	src="${basePath}ExtJsCustom/Admin/app/app.js"></script>
<!-- <script type="text/javascript"
	src="${basePath}ExtJsCustom/Admin/index.js"></script> -->
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	/* Ext.onReady(function() {
		var userName = '${user.userName}';
		var obj_spanUserName = Ext.get("span_userName");
		obj_spanUserName.dom.textContent = userName;
	}) */
</script>
</head>
<body>
</body>
</html>
