<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<script>
	//window.location.href="/CommonOrderMealWepApp_Maven/userplatform/index.html";
</script>
<body>
	Spring-Mvc page
	<br> teststr:${teststr}
	<br /> user.username:${user.getUserName()==null?"!!!its
	null!!!":user.getUserName()}
	<br /> end
	<br />
	<table border="1" style="font-size: 10px; width:80%;">
		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>UserPassword</th>
			<th>CleartextPassword</th>
			<th>Postion</th>
			<th>TelePhone</th>
			<th>Email</th>
			<th>UserLocation</th>
			<th>CreateTime</th>
			<th>LastEditTime</th>
			<th>PasswordEditTime</th>
			<th>OnlineTime</th>
			<th>LastLoginIP</th>
			<th>LoginCount</th>
			<th>UserState</th>
			<th>MealPackageNames</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userID}</td>
				<td>${user.userName}</td>
				<td>${user.userPassword}</td>
				<td>${user.cleartextPassword}</td>
				<td>${user.postion}</td>
				<td>${user.telePhone}</td>
				<td>${user.email}</td>
				<td>${user.userLocation}</td>
				<td>${user.createTime}&nbsp;</td>
				<td>${user.lastEditTime}&nbsp;</td>
				<td>${user.passwordEditTime}&nbsp;</td>
				<td>${user.onlineTime}</td>
				<td>${user.lastLoginIP}</td>
				<td>${user.loginCount}</td>
				<td>${user.userState}</td>
				<td>
					<c:forEach items="${user.mealOrders}" var="MealOrder">
						<label>
							${MealOrder.mealPackageName}
						</label>
					</c:forEach>&nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
