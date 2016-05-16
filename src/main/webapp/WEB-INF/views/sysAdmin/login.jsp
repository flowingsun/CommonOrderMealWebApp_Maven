<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String agent = request.getHeader("user-agent");//获取浏览器名称
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>订餐系统后台登陆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript"
	src="<%=basePath%>/Resources/JavaScripts/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/Resources/JavaScripts/json2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/Resources/JavaScripts/jsUtil.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/Resources/JavaScripts/common.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/Resources/JavaScripts/jquery-ui-1.10.4/ui/minified/jquery-ui.min.js"></script>
<script src="<%=basePath%>/Resources/JavaScripts/jquery-ui-1.10.4/ui/jquery.ui.effect-fold.js"></script>
<link href="<%=basePath%>/Resources/JavaScripts/jquery-ui-1.10.4/themes/base/jquery.ui.all.css" rel="stylesheet">
<link href="<%=basePath%>/Resources/JavaScripts/jquery-ui-1.10.4/themes/base/jquery-ui.css" rel="stylesheet">
<link href="<%=basePath%>/Resources/Image/java_coffee_cup_logo.png" type="image/x-icon" rel="icon" /> 
<style>
body {
    font-family: "Trebuchet MS","Arial","Helvetica","Verdana","sans-serif";
    font-size: 10px;
	background: #eee;
}
#div_loginHeader{
	margin-right: auto;
	margin-left: auto;
	height: 80px;
}
.toggler {
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	width: 400px;
}
#div_loginTop{
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	width: 400px;
	height: 60px;
	background: #eee;
}
#div_loginLeft {
	float: left;
	display: inline;
	width: 70px;
	height: 180px;
	background: #eee;
	text-align: center;
}

#div_loginMiddle {
	float: left;
	display: inline;
	width: 260px;
	height: 180px;
	text-align: center;
}

h3 {
    margin: 0 0 2px;
    text-align: center;
	padding: 0.2em;
	font-size: 14px;
}

#div_login {
	height: 160px;
	padding: 0em;
	position: relative;
	width: 255px;
	font-size: 12px;
	font-family: "Microsoft Yahei";
}

#div_login input[type="text"] {
	padding: 0.3em;
	margin-top: 15px;
}

#div_login input[type="password"] {
	padding: 0.3em;
	margin-top: 10px;
}

#div_loginControll{
	margin-top: 10px;
}

#div_loginControll input[type="button"]{
	width: 80px;
	margin: 0 10px;
}

#div_loginRight {
	float: right;
	display: inline;
	width: 70px;
	height: 180px;
	background: #eee;
	text-align: center;
}

#div_loginFooter{
	margin-right: auto;
	margin-left: auto;
	text-align: center;
	width: 700px;
	background: #eee;
}

#errormsg {
	text-align: center;
}

.hint {
	position: absolute; 	
	background: rgba(0,0,0,0.3);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#7F000000, endColorstr=#7F000000);	
	padding: 6px 11px;
	color: white;
	font: "Microsoft Yahei";
	font-weight: bold;
	border-radius: 8px;
	display: none;
	z-index: 1100;
}
.hint img {
	vertical-align: middle;
	margin-right: 5px;
	-position: relative;
	-bottom: 3px;
}
</style>
<script>
	$.ajaxSetup({  
		contentType : 'application/json'  
	}); 
	$(function() {
		document.onkeydown = function(e){
	    var ev = document.all ? window.event : e;
	    	if(ev.keyCode==13) {
	        	$('#form_login').submit();//处理事件
			}
		}
		$("#div_login").hide();
		bindAjaxHint("登录中，请稍候...");
		$('#form_login').submit(function() {
			$("#errormsg").empty();
			if ($.trim($("#loginname").val()) == "") {
				$("#errormsg").text('请填写用户名称！');
				$("#loginname").effect("highlight");
			} else if ($("#userPassword").val() == "") {
				$("#errormsg").text('请填写密码！');
				$("#userPassword").effect("highlight");
			} else {
				$("#btn_submit").attr("disabled","disabled");
				$("#btn_reset").attr("disabled","disabled");
				$.ajax({
					url : "<%=basePath%>admin_ajax/checklogin.html",
					contentType : 'application/json',
					type : 'POST',
					async: true,
					timeout : 5000,
					data : JSON.stringify({
						'loginname' : $("#loginname").val(),
						'userPassword' : $("#userPassword").val()
					}),
					dataType : 'json',
					success : function(result) {
						//$("#div_login").show("fold",
	                    //  		{horizFirst: false}, 600 );
	                    if($.trim(result)=="success"){
							window.location='<%=basePath%>admin/index.html'
	                    }else{
							$("#errormsg").text(result);
		    				ShowMessageDialog();
	                    }
	    				
						return false;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown){
						$("#errormsg").text("登陆出错！"+" errormsg:"+XMLHttpRequest.status+" "+errorThrown);
	    				ShowMessageDialog();
					},
					complete : function(XMLHttpRequest,status){
						$("#btn_submit").removeAttr("disabled");
						$("#btn_reset").removeAttr("disabled");
						if(status=='timeout'){
							$("#errormsg").text("登陆超时！");
		    				ShowMessageDialog();
							this.abort;
						}
					}
				});
			}
			return false;
		});
		//登陆框
		function ToggleLoginDiv() {
			$("#div_login").toggle( "fold", 
	                      {horizFirst: false}, 600 );
		}
		$("#btn_submit").click(function(){
			$('#form_login').submit();
			//$("#div_login").show("Fold");
		});
		$("#btn_reset").click(function(){
			document.getElementById("form_login").reset();
		});
		$("#div_login").toggle( "fold", 
	                      {horizFirst: false}, 1000 );
	    function ShowMessageDialog(){
	    	$("#dialog-modal").dialog({
	    		resizable: false,
	    		modal: true, 
	    		buttons: {
					"确认": function() {
						$( this ).dialog( "close" );
					}
				}
	    	});
	    }
	});
</script>
</head>

<body>
	<form id="form_login" action="admin_ajax/index.html">
		<div id="div_loginHeader"></div>
		<div class="toggler">
			<div id="div_loginTop"></div>
			<div id="div_loginLeft" class="c_div_login"></div>
			<div id="div_loginMiddle" class="c_div_login">
				<div id="div_login" class="ui-widget-content ui-corner-all">
					<h3 class="ui-widget-header ui-corner-all">用户登陆</h3>
					<div id="div_loginInfo">
						<div>账　号：<input type="text" id="loginname" title="账号" name="loginname"></div>
						<div>密　码：<input type="password" id="userPassword" title="密码" name="userPassword"></div>
					</div>
					<div id="div_loginControll">
						<input type="button" id="btn_submit" class="ui-state-default ui-corner-all" value="登陆">
						<input type="button" id="btn_reset" class="ui-state-default ui-corner-all" value="重新编辑">
					</div>
				</div>
			</div>
			<div id="div_loginRight"></div>
		</div>
		<div id="div_loginFooter"><%=agent%></div>
	</form>
	<div id="dialog-modal" title="消息提示">
		<br> <br>
		<div id="errormsg"></div>
	</div>
</body>
</html>
