<!DOCTYPE html>
<%@ page language="java" import="java.util.List, com.izoro.vo.Movie" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rank List</title>
<style type="text/css">
.rList{
	float: left;
	width: 400px;
}
.rankList{
	list-style-type: none;
}

.rankList li{
	border:2px solid rgb(223, 231, 223);
	border-top:none;
	border-left:none;
	border-right: none;
	height: 40px;
	width: 340px;
	box-sizing:border-box;/* 内边距的两种模式 */
	padding-top:8px;
}

.rankList li a{
	text-decoration: none;
	color:black;
	margin-left: 50px;
}

.number{
	display: inline-block;
	margin-left:24px;
	width: 12px;
}
</style>
</head>
<body>
<%
	if(request.getAttribute("topmovie") == null){
%>
<jsp:forward page="/MovieSearchByScore">
	<jsp:param value="rankList.jsp" name="url"/>
</jsp:forward>
<%} %>

	<jsp:include page="header.jsp"></jsp:include>
	<div id="page_Flag" style="display: none;">rank</div>
	
	<div style="height:5px;background-color: rgb(220,226,228);"></div>
	
	<%List<Movie> mT = (List<Movie>)request.getAttribute("topmovie"); %>
	<div style="margin: 80px auto 40px auto; overflow: hidden; width: 1200px;">
		<h1 style="margin-bottom: 60px;">排行榜&nbsp;&nbsp;&nbsp;&nbsp;T250</h1>
		<div class="rList">
			<ul class="rankList">
			
			<%
				String str = "<li><div class='number'>1</div><a href='#'>我不是药神</a></li>";
				int i = 0;
				int T = 20;
				if(mT != null){
					T = mT.size()>=20? 20:mT.size();
					for(; i<T; i++){
						out.print("<li><div class='number'>"+(i+1)+"</div><a href='view/movieMsg.jsp?mid="+mT.get(i).getMovieId()+"'>"+mT.get(i).getMoviename()+"</a></li>");
					}
					//i += 20;
				}
				else{
					out.print(str);
				}
				
			%>
			
  			</ul>
		</div>
		<div class="rList">
			<ul class="rankList">
			<%
				if(mT != null){
					T = mT.size()>=40? 40:mT.size();
					for(; i<T; i++){
						out.print("<li><div class='number'>"+(i+1)+"</div><a href='view/movieMsg.jsp?mid="+mT.get(i).getMovieId()+"'>"+mT.get(i).getMoviename()+"</a></li>");
					}
					//i += 20;
				}
				else{
					out.print(str);
				}
			%>
  			</ul>
		</div>
		<div class="rList">
			<ul class="rankList">
			<%
				if(mT != null){
					T = mT.size()>=60? 60:mT.size();
					for(; i<T; i++){
						out.print("<li><div class='number'>"+(i+1)+"</div><a href='view/movieMsg.jsp?mid="+mT.get(i).getMovieId()+"'>"+mT.get(i).getMoviename()+"</a></li>");
					}
					//i += 20;
				}
				else{
					out.print(str);
				}
			%>
  			</ul>
		</div>
		<p style="float: right; margin-top: 18px;"><a href="javascript:void(0)"><span style="margin-right: 16px;">上一页</span></a><a href="javascript:void(0)"><span>下一页</span></a></p>
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>