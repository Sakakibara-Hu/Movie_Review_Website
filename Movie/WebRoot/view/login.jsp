<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>login</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

h1 {
	color: rgb(50, 180, 215);
	text-align: center;
	padding-top: 25px;
}

span {
	color: rgb(50, 180, 215);
	font-size: 21px;
}

.login {
	background-color: rgba(255, 255, 255, 0.8);
	width: 355px;
	height: 421px;
	margin: auto;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
}

.main {
	background-image: url(view/static/image/background.png);
	background-repeat: no-repeat;
	background-position: center center;
	background-attachment: fixed;
	background-size: cover;
	height: 100%;
	position: relative;
	min-height: 600px;
}

.inbutton {
	color: white;
	background-color: rgb(50, 180, 215);
	border: 0px;
	height: 33px;
	width: 100px;
	font-size: 20px;
	font-weight: 300;
	outline: none;
}

.inbutton:hover {
	opacity: 0.7;
}

.inbutton:active {
	opacity: 0.5;
}

.upbutton {
	color: rgb(50, 180, 215);
	background-color: rgb(214, 228, 230);
	border: 0px;
	height: 33px;
	width: 100px;
	font-size: 20px;
	font-weight: 300;
	outline: none;
}

.upbutton:hover {
	opacity: 0.7;
}

.upbutton:active {
	opacity: 0.5;
}

.inputA {
	padding-top: 55px;
	padding-left: 25px;
}

.inputB {
	padding-top: 20px;
	padding-left: 25px;
}

.buttonD {
	padding-top: 70px;
	padding-left: 60px;
}

.inputText:FOCUS {
	outline: none;
}

.inputText {
	background: none;
	border: none;
	border-bottom: 1px solid #ddd;
	font-size: 21px;
	color: rgb(50, 180, 215);
	width: 230px;
}
</style>

<script type="text/javascript">

function loginF(){
 var a = document.getElementById("name").value;
 var b = document.getElementById("psword").value;
 var strA=a.replace(/(^\s*)|(\s*$)/g, "");
 var strB=b.replace(/(^\s*)|(\s*$)/g, "");
 if(strA==""||strB=="")
 {
	window.alert("用户名或帐号不能为空！");
	return false;
 }
 return true;
}
</script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<div class="main">
			<div id="content" class="login">
				<%
					if(request.getAttribute("login")!=null)
					{%>
						<script type="text/javascript">
							alert("登录失败，请确认你的帐号密码是否正确！");
						</script>
				  <%}
				 %>
				<h1>WELCOME</h1>
				<form action="Login" onsubmit="return loginF()" method="post">
					<div class="inputA">
						<span>用户名 :</span> <input type="text" class="inputText" maxlength="18" 
							name="username" id="name">
					</div>
					<br />
					<div class="inputB">
						<span>密 &nbsp;&nbsp;码 :</span> <input type="password" maxlength="18" 
							class="inputText" name="password" id="psword">
					</div>
					<br />
					<div class="buttonD">
						<input type="submit" value="登 录" class="inbutton">&nbsp;&nbsp; &nbsp; &nbsp; 
						<input type="button" value="注 册" class="upbutton" onclick="javascrtpt:window.location.href='view/register.jsp'">
					</div>
				</form>
			</div>
		</div>

	</div>


</body>

</html>
