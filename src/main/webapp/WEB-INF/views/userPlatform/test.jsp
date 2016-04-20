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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${basePath }Resources/css/platformMain.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="${basePath }Resources/css/platformIndex.css" type="text/css"></link>
<link rel="stylesheet"
	href="${basePath }Resources/css/platformDetail.css" type="text/css"></link>
<link rel="stylesheet" href="${basePath }Resources/css/platformUser.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="${basePath }Resources/css/platformAnnouncement.css"
	type="text/css"></link>
</head>
<body>

	<div class="home">
		<!-- ${testmd5 } -->
		<header class="header"> <nav
			class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="row">
				<div class="hidden-xs hidden-sm col-md-3 col-lg-3">
					<div class="navbar-header navbar-left">
						<a class="navbar-brand-mc" href="/"> <img
							src="/Public/img/Brand.png" alt="logo" />
						</a>
					</div>
				</div>
				<div class="hidden-xs visible-sm-block col-sm-2">
					<div class="navbar-header navbar-left">
						<a class="navbar-brand-mc" href="/"> <img
							src="/Public/img/Brand-M.png" alt="logo" />
						</a>
					</div>
				</div>
				<div class="visible-xs-block col-xs-2">
					<div class="navbar-header navbar-left">
						<a class="navbar-brand-mc" href="/"> <img
							src="/Public/img/Brand-S.png" alt="logo" />
						</a>
					</div>
				</div>
				<div class="col-xs-8 col-sm-5 col-md-5 col-lg-5">
					<!--<div class="navbar-search navbar-left">-->
					<form class="navbar-form-mc" method="get" action="/course/search"
						role="search">
						<div class="input-group input-group-nav">
							<input type="text" class="form-control" id="input-search"
								name="key" placeholder="查找课程..."> <span
								class="input-group-btn"> <a role="button" class="btn"
								aria-label="Left Align"
								onclick="$(this).closest('form').submit()"> <span
									class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</a>
							</span>
						</div>
					</form>
					<!--</div>-->
				</div>
				<div class="hidden-xs col-sm-5 col-md-4 col-lg-4">
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav pull-right">
							<li id="nav-index"><a href="/">首页</a></li>
							<li id="nav-course"><a href="/course">课程</a></li>
							<li id="nav-notice"><a href="/announcement">公告</a></li>
							<li><a href="/">登录</a></li>

						</ul>
					</div>
				</div>
				<div class="visible-xs-block col-xs-2">
					<div class="nav nav-hamburger pull-right">
						<a href="#ham" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false"><span
							class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></a>
						<ul class="dropdown-menu pull-right">
							<li><a href="/">首页</a></li>
							<li><a href="/course">课程</a></li>
							<li id="xs-nav-notice"><a href="/announcement">公告</a></li>
							<li><a href="/">登录</a></li>

						</ul>
					</div>

				</div>

			</div>
		</div>
		</nav> </header>

		<div class="content">

			<div class="wrapper">
				<div class="container">
					<div class="row">
						<div class="wrapper-intro col-xs-0 col-sm-6 col-md-8 col-lg-8">
							<img src="/Public/img/MiLogo.png" /> <br /> <img
								src="/Public/img/miTitle.png" />
						</div>

						<!--<div class="wrapper-intro col-xs-0 col-sm-0 col-md-2 col-lg-2"></div>-->

						<div class="log-or-sign col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs" id="tab-sl">
								<li role="presentation" class="active"><a href="#login"
									aria-controls="login" role="tab" data-toggle="tab"
									id="tri-login">登录米课</a></li>
								<li role="presentation"><a href="#register"
									aria-controls="register" role="tab" data-toggle="tab"
									id="tri-register">注册·加入米课</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<!-- Tab Log in -->
								<form role="tabpanel" class="tab-pane fade in active" id="login"
									onsubmit="return false;">
									<div class="tab-info" id="login-info"></div>
									<label for="login-email" class="sr-only">邮箱</label> <input
										type="email" id="login-email" class="form-control"
										placeholder="邮箱" required autofocus> <label
										for="login-password" class="sr-only">密码</label> <input
										type="password" id="login-password" class="form-control"
										placeholder="密码" required>
									<div class="checkbox">
										<label class="f-white"> <input type="checkbox"
											id="login-remember" checked> 记住我
										</label> <a class="pull-right forgot" href="/recover">忘记密码</a>
									</div>
									<button class="btn btn-lg btn-primary btn-block login">登录</button>
								</form>
								<!-- Tab Register -->
								<form role="tabpanel" class="tab-pane fade" id="register"
									onsubmit="return false;">
									<div class="tab-info" id="register-info"></div>
									<label for="register-email" class="sr-only">邮箱</label> <input
										type="email" id="register-email" class="form-control"
										placeholder="邮箱" required autofocus> <label
										for="register-password" class="sr-only">密码</label> <input
										type="password" id="register-password" class="form-control"
										placeholder="密码" required>
									<button class="btn btn-lg btn-primary btn-block register">注册</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="home-page container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
						<!--BEGIN NEW COURSES-->
						<div class="section section-carousel">
							<h4>新课速递</h4>

							<div id="carousel-example-generic" class="carousel slide"
								data-ride="carousel">
								<!-- Indicators -->
								<ol class="carousel-indicators">
									<li data-target="#carousel-example-generic" data-slide-to="0"
										class="active"></li>
									<li data-target="#carousel-example-generic" data-slide-to="1"></li>
									<li data-target="#carousel-example-generic" data-slide-to="2"></li>
								</ol>

								<!-- Wrapper for slides -->
								<div class="carousel-inner" role="listbox">
									<div class="item active">
										<div class="row">
											<div class="col-xs-12 col-sm-6 col-sm-6 col-md-6">
												<div class="thumbnail">
													<a> <img src="/Public/img/new/film.jpg" alt="...">
														<div class="new-course-mask">
															<div class="info-icon">
																<div class="box-f">
																	<div class="box-s">
																		<div class="box-t img-responsive"
																			style="background-image: url(/Public/img/icons/film.png);">
																		</div>
																	</div>
																</div>
															</div>
															<h3>
																<a href="/course/471">文学与电影：艺术之互动</a>
															</h3>
														</div>
													</a>
													<div class="caption">
														<p>感受文学与电影交融之魅力</p>
													</div>
												</div>
											</div>
											<div class="col-xs-12 col-sm-6 col-sm-6 col-md-6">
												<div class="thumbnail">
													<a> <img src="/Public/img/new/mineral.jpg" alt="...">
														<div class="new-course-mask">
															<div class="info-icon">
																<div class="box-f">
																	<div class="box-s">
																		<div class="box-t img-responsive"
																			style="background-image: url(/Public/img/icons/geography.png);">
																		</div>
																	</div>
																</div>
															</div>
															<h3>
																<a href="/course/476">地表双雄：生物和矿物</a>
															</h3>
														</div>
													</a>
													<div class="caption">
														<p>看地表双雄谁与争锋</p>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="item">
										<div class="row">
											<div class="col-xs-12 col-sm-6 col-sm-6 col-md-6">
												<div class="thumbnail">
													<a> <img src="/Public/img/new/biology.jpg" alt="...">
														<div class="new-course-mask">
															<div class="info-icon">
																<div class="box-f">
																	<div class="box-s">
																		<div class="box-t img-responsive"
																			style="background-image: url(/Public/img/icons/biology.png);">
																		</div>
																	</div>
																</div>
															</div>
															<h3>
																<a href="/course/467">探索生物医学诺贝尔奖</a>
															</h3>
														</div>
													</a>
													<div class="caption">
														<p>走进诺贝尔奖</p>
													</div>
												</div>
											</div>
											<div class="col-xs-12 col-sm-6 col-sm-6 col-md-6">
												<div class="thumbnail">
													<a> <img src="/Public/img/new/uncertainty.jpg"
														alt="...">
														<div class="new-course-mask">
															<div class="info-icon">
																<div class="box-f">
																	<div class="box-s">
																		<div class="box-t img-responsive"
																			style="background-image: url(/Public/img/icons/psychology.png);">
																		</div>
																	</div>
																</div>
															</div>
															<h3>
																<a href="/course/475">不确定世界中的决策行为</a>
															</h3>
														</div>
													</a>
													<div class="caption">
														<p>你真的了解你所做的决策吗</p>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="item">
										<div class="row">
											<div class="col-xs-12 col-sm-6 col-sm-6 col-md-6">
												<div class="thumbnail">
													<a> <img src="/Public/img/new/pollution.jpg" alt="...">
														<div class="new-course-mask">
															<div class="info-icon">
																<div class="box-f">
																	<div class="box-s">
																		<div class="box-t img-responsive"
																			style="background-image: url(/Public/img/icons/air.png);">
																		</div>
																	</div>
																</div>
															</div>
															<h3>
																<a href="/course/473">大气雾霾污染与健康</a>
															</h3>
														</div>
													</a>
													<div class="caption">
														<p>我们的健康去了哪里</p>
													</div>
												</div>
											</div>
											<div class="col-xs-12 col-sm-6 col-sm-6 col-md-6">
												<div class="thumbnail">
													<a> <img src="/Public/img/new/usa.jpg" alt="...">
														<div class="new-course-mask">
															<div class="info-icon">
																<div class="box-f">
																	<div class="box-s">
																		<div class="box-t img-responsive"
																			style="background-image: url(/Public/img/icons/politics.png);">
																		</div>
																	</div>
																</div>
															</div>
															<h3>
																<a href="/course/478">二十世纪中美文化交往诸问题</a>
															</h3>
														</div>
													</a>
													<div class="caption">
														<p>那时的我们</p>
													</div>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>

						<!--BEGIN HOT-COURSES-->
						<div class="section hot-course">
							<h4>
								最热门课程榜<small><a href="/course">更多»</a></small>
							</h4>
							<ul class="row">
								<li class="item col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<div class="item-card">
										<div class="card-icon">
											<div class="box-f">
												<div class="box-s">
													<div class="box-t img-responsive"
														style="background-image: url(/Public/img/icons/literature.png);">
													</div>
												</div>
											</div>
										</div>
										<a class="f-18 f-hot f-weight card-name" href="/course/148">俄罗斯文学经典的当代意义</a>
										<div class="hidden-md">
											<a class="tag tag-info tag-sm" href="/Course/tag/id/445">文学院</a><a
												class="tag tag-info tag-sm" href="/Course/tag/id/447">董晓</a>
										</div>
										<div class="score">
											<img src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <span
												class="f-12 f-sub star">4.8分</span>
										</div>
										<div class="f-12">
											3学分 <a href="/course/148#anchor-comments">43评论</a>
										</div>
									</div>
								</li>
								<li class="item col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<div class="item-card">
										<div class="card-icon">
											<div class="box-f">
												<div class="box-s">
													<div class="box-t img-responsive"
														style="background-image: url(/Public/img/icons/music.png);">
													</div>
												</div>
											</div>
										</div>
										<a class="f-18 f-hot f-weight card-name" href="/course/278">西方音乐通论</a>
										<div class="hidden-md">
											<a class="tag tag-info tag-sm" href="/Course/tag/id/449">吕晓一</a>
										</div>
										<div class="score">
											<img src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <span
												class="f-12 f-sub star">4.7分</span>
										</div>
										<div class="f-12">
											2学分 <a href="/course/278#anchor-comments">45评论</a>
										</div>
									</div>
								</li>
								<li class="item col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<div class="item-card">
										<div class="card-icon">
											<div class="box-f">
												<div class="box-s">
													<div class="box-t img-responsive"
														style="background-image: url(/Public/img/icons/art.png);">
													</div>
												</div>
											</div>
										</div>
										<a class="f-18 f-hot f-weight card-name" href="/course/98">中国书画鉴赏</a>
										<div class="hidden-md">
											<a class="tag tag-info tag-sm" href="/Course/tag/id/450">文化艺术教育中心</a><a
												class="tag tag-info tag-sm" href="/Course/tag/id/451">黄正明</a>
										</div>
										<div class="score">
											<img src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <span
												class="f-12 f-sub star">4.9分</span>
										</div>
										<div class="f-12">
											2学分 <a href="/course/98#anchor-comments">31评论</a>
										</div>
									</div>
								</li>
								<li class="item col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<div class="item-card">
										<div class="card-icon">
											<div class="box-f">
												<div class="box-s">
													<div class="box-t img-responsive"
														style="background-image: url(/Public/img/icons/art.png);">
													</div>
												</div>
											</div>
										</div>
										<a class="f-18 f-hot f-weight card-name" href="/course/112">艺术原理与艺术经典</a>
										<div class="hidden-md">
											<a class="tag tag-info tag-sm" href="/Course/tag/id/450">文化艺术教育中心</a><a
												class="tag tag-info tag-sm" href="/Course/tag/id/452">康尔</a>
										</div>
										<div class="score">
											<img src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <span
												class="f-12 f-sub star">4.9分</span>
										</div>
										<div class="f-12">
											2学分 <a href="/course/112#anchor-comments">30评论</a>
										</div>
									</div>
								</li>
								<li class="item col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<div class="item-card">
										<div class="card-icon">
											<div class="box-f">
												<div class="box-s">
													<div class="box-t img-responsive"
														style="background-image: url(/Public/img/icons/art.png);">
													</div>
												</div>
											</div>
										</div>
										<a class="f-18 f-hot f-weight card-name" href="/course/100">视觉文化与摄影艺术</a>
										<div class="hidden-md">
											<a class="tag tag-info tag-sm" href="/Course/tag/id/450">文化艺术教育中心</a><a
												class="tag tag-info tag-sm" href="/Course/tag/id/457">谢白</a>
										</div>
										<div class="score">
											<img src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <span
												class="f-12 f-sub star">4.4分</span>
										</div>
										<div class="f-12">
											2学分 <a href="/course/100#anchor-comments">26评论</a>
										</div>
									</div>
								</li>
								<li class="item col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<div class="item-card">
										<div class="card-icon">
											<div class="box-f">
												<div class="box-s">
													<div class="box-t img-responsive"
														style="background-image: url(/Public/img/icons/literature.png);">
													</div>
												</div>
											</div>
										</div>
										<a class="f-18 f-hot f-weight card-name" href="/course/77">南大逸事</a>
										<div class="hidden-md">
											<a class="tag tag-info tag-sm" href="/Course/tag/id/453">教育研究院</a><a
												class="tag tag-info tag-sm" href="/Course/tag/id/454">王运来</a>
										</div>
										<div class="score">
											<img src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <img
												src="/Public/img/star.png"> <span
												class="f-12 f-sub star">4.9分</span>
										</div>
										<div class="f-12">
											2学分 <a href="/course/77#anchor-comments">21评论</a>
										</div>
									</div>
								</li>
							</ul>

						</div>
						<!--END HOT-COURSES-->


					</div>
					<div class="home-sub col-xs-12 col-sm-12 col-md-4 col-lg-4">
						<div class="hot-tag section">
							<h4>热门标签</h4>
							<div class="tag-section">
								<h5>学分</h5>
								<a class="tag tag-info" href="/Course/tag/id/448">2学分</a><a
									class="tag tag-info" href="/Course/tag/id/446">3学分</a><a
									class="tag tag-info" href="/Course/tag/id/641">1学分</a>
							</div>
							<div class="tag-section">
								<h5>类型</h5>
								<a class="tag tag-info" href="/Course/tag/id/875">研讨课</a><a
									class="tag tag-info" href="/Course/tag/id/873">通识课</a><a
									class="tag tag-info" href="/Course/tag/id/878">公选课</a><a
									class="tag tag-info" href="/Course/tag/id/840">悦读计划</a><a
									class="tag tag-info" href="/Course/tag/id/876">文化素质课</a><a
									class="tag tag-info" href="/Course/tag/id/874">优秀文化素质课</a><a
									class="tag tag-info" href="/Course/tag/id/877">就业创业课</a>
							</div>
							<div class="tag-section">
								<h5>院系</h5>
								<a class="tag tag-info" href="/Course/tag/id/445">文学院</a><a
									class="tag tag-info" href="/Course/tag/id/470">历史学系</a><a
									class="tag tag-info" href="/Course/tag/id/559">创新创业学院</a><a
									class="tag tag-info" href="/Course/tag/id/468">哲学系</a><a
									class="tag tag-info" href="/Course/tag/id/547">信息管理学院</a><a
									class="tag tag-info" href="/Course/tag/id/461">环境学院</a><a
									class="tag tag-info" href="/Course/tag/id/562">法学院</a><a
									class="tag tag-info" href="/Course/tag/id/698">国际学院</a><a
									class="tag tag-info" href="/Course/tag/id/481">社会学院</a><a
									class="tag tag-info" href="/Course/tag/id/458">外国语学院</a>
							</div>

							<div class="tag-section">
								<h5>分类</h5>
								<a class="tag tag-info" href="/Course/tag/id/18">文学</a><a
									class="tag tag-info" href="/Course/tag/id/17">历史</a><a
									class="tag tag-info" href="/Course/tag/id/54">其他</a><a
									class="tag tag-info" href="/Course/tag/id/22">生物</a><a
									class="tag tag-info" href="/Course/tag/id/15">社会</a><a
									class="tag tag-info" href="/Course/tag/id/20">艺术</a><a
									class="tag tag-info" href="/Course/tag/id/16">物理</a><a
									class="tag tag-info" href="/Course/tag/id/45">创新创业</a><a
									class="tag tag-info" href="/Course/tag/id/29">医学/健康</a><a
									class="tag tag-info" href="/Course/tag/id/27">计算机</a>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>