<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Register</title>
<style type="text/css">
#wrapper{
	background-image:url(view/static/image/background.png);
	background-repeat:no-repeat;
	background-position:center center;
	background-attachment:fixed;
	background-size:cover;
	height: 100%;
	position: relative;
	min-height: 600px;
}
#content{
	width:355px;
	height:420px;
	background-color:rgba(255,255,255,0.8);/*背景颜色白色，50%透明度*/
	/*position: absolute;*/
	color: RGB(50, 180, 215);
	/*left: 38%;
	top: 90px;*/
	margin: auto;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	text-align: center;
}
.inputLine{
	padding-top:20px;
	padding-left:20px;
}
.inputText:FOCUS {
	outline: none;
}
.inputText{
	background:none;
	border: none;
	border-bottom: 1px solid #ddd;
	font-size: 21px;
	color:rgb(50,180,215);
	width: 230px;
}
span{
	color:rgb(50,180,215);
	font-size:21px;
}
#regist{
	color:white;
	background-color: rgb(50,180,215);
	border: 0px;
	height: 33px;
	width: 150px;
	font-size: 20px;
	font-weight: 300;
}
.buttonL{
	padding-top: 40px;
}
.inbutton:hover{
opacity: 0.7;
}

.inbutton:active{
opacity: 0.5;
}
</style>

<script type="text/javascript">
	function check(){
		var name = document.getElementById("name").value;
		var pwd = document.getElementById("pwd").value;
		var email = document.getElementById("email").value;
		
		var strN = name.replace(/(^\s*)|(\s*$)/g, "");
		var strP = pwd.replace(/(^\s*)|(\s*$)/g, "");
		var strE = email.replace(/(^\s*)|(\s*$)/g, "");
		if(strN=="" || strP=="" || strE==""){
			alert("请确保输入了所有的注册信息！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		if(request.getAttribute("result") != null){
			if(request.getAttribute("result").equals(false)){
	%>
	<script type="text/javascript">alert("注册失败！");</script>
	<%
			}
		}
	%>
	<div id="wrapper">
		<div id="content">
			<h1 style="padding-top: 25px;">Please Enter</h1><br><br>
			<form action="<%=request.getContextPath()%>/UserregistServlet" onsubmit="return check()" method="post">
				<div class="inputLine"><span>用户名 :</span> <input type="text" id="name" class="inputText" maxlength="18" name="username"></div><br>
				<div class="inputLine"><span>密 &nbsp;&nbsp;码 :</span> <input type="password" id="pwd" maxlength="18" class="inputText" name="password"></div><br>
				<div class="inputLine"><span>邮 &nbsp;&nbsp;箱 :</span> <input type="email" id="email" maxlength="30" class="inputText" name="email"></div><br>
				<div class="buttonL">
				<input type="submit" id="regist" value="完 成 注 册" class="inbutton"></div>
			</form>
		</div>
	</div>
</body>
</html>