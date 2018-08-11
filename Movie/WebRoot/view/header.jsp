<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<base href="<%=basePath%>">

<title>Header</title>
<style type="text/css">
* {
	padding:0;
	margin:0;
}
body{
	min-width: 1435px;
	/*overflow-x: hidden; 
	overflow-y: hidden;*/
}
#header{
	height:50px;
	width:100%;
	background-color: white;
	/*min-width: 1145px;*/
	line-height: 0; /*解决inline-block有默认上下边距的问题*/
}
#navi {
	float:right;
	list-style-type: none;
	height: 32px;
	margin-top: 25px;
}
#navi li{
	display: inline;
	margin-right: 30px;
	font-size: 17px;
	padding-bottom: 10px;
}
#navi li:HOVER {
	border-bottom: 5px solid RGB(51,180,215);
}
#navi a{
	text-decoration: none;
	color:black;
}
.entrace, .entrace:hover {
	text-decoration: none;
	color:black;
}

li.active {
	border-bottom: 5px solid RGB(51,180,215);
}

#search{
	border-bottom-left-radius: 3px;
	border-bottom-right-radius: 3px;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	height: 36px;
	font-size: 15px; 
	width: 250px; 
	border: 0.5px solid RGB(51,180,215);
	padding-left: 20px;
	display: inline;
	background-image: url(view/static/image/search.png);
	background-repeat: no-repeat;
	background-position: 95%;
	box-sizing: border-box;
}
#search-sub{
	float: left;
	width: 20px;
	height: 20px;
	border: orangered;
	position: relative;
	left: 218px;
	top: -28px;
	cursor: pointer;
	opacity: 0.1;
}

</style>
<script type="text/javascript">
	window.onload = function(){
		var aNode = document.getElementById("navi").getElementsByTagName("a");
		var lNode = document.getElementById("navi").getElementsByTagName("li");
		var currenturl = document.location.href;
		for(var i=0; i<aNode.length; i++){
			var aurl = aNode[i].getAttribute("href");
			if(currenturl.indexOf(aurl) == -1){
				lNode[i].setAttribute("class", "");
			}
			else{
				lNode[i].setAttribute("class", "active");
			}
		}
		
		if(currenturl.indexOf("regist") != -1 || currenturl.indexOf("ogin") != -1){
			var search = document.getElementById("searchB");
			search.style.display = "none";
		}
		
		
	}
</script>
</head>
<body>
	<div id="header">
		<span style="margin-left: 315px; display:inline-block; font-size:15px; padding-top: 25px; color:rgb(50,180,215);">FandT</span><!-- 
	 --><div id="searchB" style="display:inline-block; margin-left: 30px; margin-top:7px; width: 250px;">
			<form action="" method="post">
				<input id="search" type="text" maxlength="18" name="search" placeholder="  请输入..." >
				<input id="search-sub" value="" type="submit">
			</form>
			
		</div>
		
		<div style="width:400px; height:30px; padding-left:10px; background-color:white; float:right; box-sizing: content-box;">
		    <div style="width: 40px; height: 40px; float:left; border-radius: 50%; border: 2px solid RGB(51,180,215); box-sizing: content-box; overflow: hidden; margin-top: 4px; ">
		        <%
		        	if(session.getAttribute("username") == null){
		        %>
		        <a href="view/login.jsp"><img src="" onerror="this.src='view/static/image/default.png;this.onerror=null'" id="headicon" width="80" height="80" /></a>
		    	<%}else{ %>
		    	<a href="view/information.jsp"><img src="${sessionScope.userFace }" onerror="this.src='view/static/image/default.png;this.onerror=null'" id="headicon" width="80" height="80" /></a>
		    	<%} %>
		    </div>
		    <div style="float:left; margin-left:10px; padding-top: 25px; color:black; font-size: 17px;">
		    	<%
		    		if(session.getAttribute("username") == null){
		    	%>
		    			<a class="entrace" href="view/login.jsp">登录</a>/<a class="entrace" href="view/register.jsp">注册</a>
		    	<%
		    		}else{
		    	%>
		        <a class="entrace" href="view/information.jsp">${sessionScope.username }</a>
		        <%} %>
		    </div>
		</div>
		
		<ul id="navi">
			<li><a href="view/main.jsp" >首页</a></li>
			<li><a href="view/rankList.jsp" >排行榜</a></li>
			<li><a href="view/classifyPage.jsp" >分类</a></li>
			<li><a href="view/yingping.jsp" >影评</a></li>
		</ul>
		
		
	</div>
</body>

</html>