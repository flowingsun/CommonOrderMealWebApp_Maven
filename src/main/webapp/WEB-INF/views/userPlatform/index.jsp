<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="_themes.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户订餐平台</title>
<link rel="stylesheet"
	href="${basePath }Resources/css/Platform/Index.css" type="text/css"></link>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<!-- 轮播插件 -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<a href="#"> <img class="first-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="First slide">
				</a>
				<div class="container">
					<div class="carousel-caption">
						<h1>Example headline.</h1>
						<p>
							Note: If you're viewing this page via a
							<code>file://</code>
							URL, the "next" and "previous" Glyphicon buttons on the left and
							right might not load/display properly due to web browser security
							rules.
						</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Sign
								up today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Another example headline.</h1>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								more</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>One more for good measure.</h1>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Browse
								gallery</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- 轮播插件END -->


	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
				<!-- 热门 -->
				<div class="section">
					<h4>
						热门<small><a href="/course">更多»</a></small>
					</h4>
					<ul class="row">
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							<div style="display: block;">re1</div>
							<div style="display: block;">
								<img class="col-xs-6 col-sm-6 col-md-4 col-lg-4"
								src="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png" />
							</div>
						</li>
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							<img class="col-xs-6 col-sm-6 col-md-4 col-lg-4"
							src="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png" />
							re2
						</li>
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							<img class="col-xs-6 col-sm-6 col-md-4 col-lg-4"
							src="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png" />
							re3
						</li>
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							<img class="col-xs-6 col-sm-6 col-md-4 col-lg-4"
							src="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png" />
							re4
						</li>
					</ul>
				</div>
				<!-- 热门END -->



				<!-- 商家 -->
				<div class="section">
					<h4>
						商家<small><a href="/course">更多»</a></small>
					</h4>
					<ul class="row">
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">sj1</li>
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							sj2
						</li>
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							sj3
						</li>
						<li class="item col-xs-6 col-sm-6 col-md-4 col-lg-4">
							sj4
							<!-- <div style="width: 100px; height: 100px;">re4</div> -->
						</li>
					</ul>
				</div>
				<!-- 商家END -->
			</div>

			<!-- 标签 -->
			<div class="home-sub col-xs-12 col-sm-12 col-md-4 col-lg-4">

				<div class="shopingCar section">
					<h4>购物车</h4>
					<div>
						<ol>
							<li>炒饭(10元)X</li>
							<li>白粥(2元)X</li>
							<li>面包(6元)X</li>
						</ol>
						<label>共x元</label>
					</div>
				</div>

				<div class="hot-tag section">
					<h4>热门标签</h4>
					<div class="tag-section">
						<a class="tag tag-info" href="/Course/tag/id/448">辣</a><a
							class="tag tag-info" href="/Course/tag/id/446">清淡</a><a
							class="tag tag-info" href="/Course/tag/id/641">味道好</a> &nbsp; <a
							class="tag tag-info" href="/Course/tag/id/448">辣</a><a
							class="tag tag-info" href="/Course/tag/id/446">清淡</a><a
							class="tag tag-info" href="/Course/tag/id/641">味道好</a> <a
							class="tag tag-info" href="/Course/tag/id/448">辣</a><a
							class="tag tag-info" href="/Course/tag/id/446">清淡</a><a
							class="tag tag-info" href="/Course/tag/id/641">味道好</a> <a
							class="tag tag-info" href="/Course/tag/id/448">辣</a><a
							class="tag tag-info" href="/Course/tag/id/446">清淡</a><a
							class="tag tag-info" href="/Course/tag/id/641">味道好</a> <a
							class="tag tag-info" href="/Course/tag/id/448">辣</a><a
							class="tag tag-info" href="/Course/tag/id/446">清淡</a><a
							class="tag tag-info" href="/Course/tag/id/641">味道好</a>
					</div>
				</div>
			</div>
			<!-- 标签END -->


		</div>
	</div>
	<!-- /.container -->
</body>
</html>