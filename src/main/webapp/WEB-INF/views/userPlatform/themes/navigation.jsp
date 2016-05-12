<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//session.setAttribute("loginUser","abc");
	Object loginUser = session.getAttribute("loginUser");
%>

<!-- 头部导航 -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header hidden-xs">
			<!-- <button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button> -->
			<a class="navbar-brand" href="#">订餐系统</a>
		</div>
		<div class="navbar-header visible-xs">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="navbar-brand" style="width: 75%; text-align: center;">
				<a href="#">订餐系统</a>
			</div>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav middle-nav-ul">
				<li class="active"><a href="userplatform/index.html">首页</a></li>
				<li><a href="/userplatform/cart">购物车</a></li>
				<li><a href="/userplatform/about">关于</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right hidden-xs">
				<%
					if (loginUser != null) {
				%>
				<li><a href="/userplatform/userInfo"><%="loginUser.name"%>,你好</a></li>
				<%
					} else {
				%>
				<li id="sign-in-item"><a href="/userplatform/sign_in">登录</a></li>
				<li id="sign-up-item"><a href="/userplatform/sign_up">注册</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
<!-- 头部导航End -->