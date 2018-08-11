<!DOCTYPE html>
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
<title>footer</title>
<style type="text/css">
body {
	position: relative;	/* footer定位 */
}
</style>
</head>
<body>
	<div id="footer" style="width: 100%; height: 100px; background-color: RGB(232,240,242); color: RGB(92,100,102); font-size: 14px; text-align:center; vertical-align:middle; position:absolute; top: auto;">
		<p style="margin-top: 30px;">小组版权所有@影评网站</p>
		<span>重庆邮电大学</span>
	</div>
</body>
</html>