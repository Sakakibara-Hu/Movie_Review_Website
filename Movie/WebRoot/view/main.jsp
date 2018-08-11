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
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home Page</title>

<style type="text/css">

.rankList{
	list-style-type: none;
}

.rankList li{
	border:2px solid rgb(223, 231, 223);
	border-top:none;
	border-left:none;
	border-right: none;
	height: 40px;
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

.headline{
		line-height: 50px;
		height:52px;
		border:12px solid rgb(50, 180, 215);
		border-top:none;
		border-bottom:none;
		border-right: none;
		font-size: 18px;
	}
	
.more{
	font-size: 10px;
	margin-left: 38px;
	color:gray;
}

.comment{
	width: 100%;
	margin-top: 19px;
	height: 235px;
}

.fl {
	float: left;
}
.commsg {
	width: 330px;
	margin-left: 20px;
	max-height: 235px;
    font-size: 14px;
}
.commsg p {
	margin-bottom: 0;
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 10;
}

.movie{
	 overflow: hidden; 
}

.m_item{
	margin-top:35px;
	margin-right:40px;
	float:left;
	width: 117px;
	height: 206px;
}

.m_item p{
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
}

.Poster{
	height: 162px;
	width: 117px;
	background-color: rgb(215,227,230);
}
	
.movieName{
	font-size: 16px;
	text-align: center;
	margin-bottom: 0;
}
	
.movieScore{
	font-size: 14px;
}

</style>
</head>
<body style="position: relative;">
	<%
		if(request.getAttribute("latestmovie") == null){
	%>
	<jsp:forward page="/MovieSearchNewTime">
		<jsp:param value="0" name="page"/>
	</jsp:forward>
	
	<%} %>
	<%
		if(request.getAttribute("topmovie") == null){
	%>
	<jsp:forward page="/MovieSearchByScore">
		<jsp:param value="main.jsp" name="url"/>
	</jsp:forward>
	<%} %>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="page_Flag" style="display: none;">main</div>
	
	<div id="slide" class="carousel slide" style="width: 100%; margin-bottom: 40px; ">
	
		<!-- 轮播（Carousel）项目 -->
		<div id="slide-inner" class="carousel-inner" style="width:auto; left: 23%; height: 100%;">
			<div class="item active">
				<img src="view/static/image/slide-1.jpg" style="height: 450px; width: 800px;" alt="First slide">
			</div>
			<div class="item">
				<img src="view/static/image/slide-2.jpg" style="height: 450px; width: 800px;" alt="Second slide">
			</div>
			<div class="item">
				<img src="view/static/image/slide-3.jpg" style="height: 450px; width: 800px;" alt="Third slide">
			</div>
		</div>
		
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#slide" data-slide-to="0" class="active"></li>
			<li data-target="#slide" data-slide-to="1"></li>
			<li data-target="#slide" data-slide-to="2"></li>
		</ol>   
		
		<!-- 轮播（Carousel）导航 -->
		<a class="left carousel-control" href="view/main.jsp#slide" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="view/main.jsp#slide" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	 
	<div id="wrapper" style="width: 1200px; height: 1060px; margin: 0 auto; margin-bottom: 40px;">
		<div id="content" style="height: 100%;">
		
			<div id="left" style="width: 785px; height:1060px; float:left;">
				<div id="l-upper" style="width: 100%; height: 500px; margin-bottom: 30px;">
					<div class="headline">&nbsp;&nbsp;最新院线<a href="view/classifyPage.jsp" class="more">更多>></a></div>
					<div class="movie">
			  		<%
			  			List<Movie> latestM = (List<Movie>)request.getAttribute("latestmovie");
			  			if(latestM == null){
			  				out.print("Loading......");
			  			}
			  			else{
				  			for(int i=0; i<10; i++)
				  			{
				  				out.print("<div class='m_item'>");
				  				out.print("<img class='Poster' alt='loading...' onerror=\"this.src='view/static/image/background.png;this.onerror=null'\" src='"+latestM.get(i).getMovieImage()+"'>");
				  				out.print("<a href='view/movieMsg.jsp?mid="+latestM.get(i).getMovieId()+"'>");
				  				out.print("<p title='"+latestM.get(i).getMoviename()+"' class='movieName'>"+latestM.get(i).getMoviename()+"</p>");
				  				out.print("</a>");
				  				out.print("<span style='font-size: 14px; margin-left: 29px;'>评分 :</span><span class='movieScore'>"+latestM.get(i).getMovieScore()+"</span>");
				  				out.print("</div>");
				  			}
			  			}
			  		 %>
			  		</div>
				</div>
				<div id="l-lower" style="width: 100%; height: 530px;">
					<div class="headline">&nbsp;&nbsp;热门推荐<a href="view/rankList.jsp" class="more">更多>></a></div>
					<div class="movie">
			  		<%
			  			for(int i=0;i<10;i++)
			  			{
			  				out.print("<div class='m_item'>");
			  				out.print("<img class='Poster' alt='loading...' src='view/static/image/background.png'>");
			  				out.print("<p class='movieName'>我不是药神</p>");
			  				out.print("<span style='font-size: 14px; margin-left: 29px;'>评分 :</span><span class='movieScore'>9.0</span>");
			  				out.print("</div>");
			  			}
			  		 %>
			  		</div>
				</div>
			</div>
			
			<div id="right" style="width: 415px; height:1060px; float:right;">
				<div id="r-upper" style="width: 100%; height: 460px; margin-bottom: 40px;">
					<div class="headline">&nbsp;&nbsp;排行榜<a href="view/rankList.jsp" class="more">更多>></a></div>
			  		<div class="rank">
			  			<ul class="rankList">
			  				<%
			  					List<Movie> mT = (List<Movie>)request.getAttribute("topmovie");
				  				if(mT != null){
									for(int i=0; i<10; i++){
										out.print("<li><div class='number'>"+(i+1)+"</div><a href='view/movieMsg.jsp?mid="+mT.get(i).getMovieId()+"'>"+mT.get(i).getMoviename()+"</a></li>");
									}
								}
								else{
									%>
									<li><div class="number">1</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">2</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">3</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">4</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">5</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">6</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">7</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">8</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">9</div><a href="#">我不是药神</a></li>
					  				<li><div class="number">10</div><a href="#">我不是药神</a></li>
									<%
								}
			  				%>
			  			</ul>
			  		</div>
				</div>
				<div id="r-lower" style="width: 100%; height: 560px;">
					<div class="headline">&nbsp;&nbsp;热门影评<a href="#" class="more">更多>></a></div>
					<div class="comment" id="comment_1">
						<a class="fl"><img alt="" src="view/static/image/background.png" style="height: 90px; width: 65px;"></a>
						<div class="fl commsg">
							<span>电影名</span><br>
							<span>用户名</span>&nbsp;&nbsp;<span>评分：8.0</span>
							<p>
一直以来我都是喜剧电影的忠实粉丝，特别喜欢周星驰系列和金凯瑞系列的喜剧电影，对我来说他们的作品就是我喜欢的喜剧电影的标杆！

《西虹市首富》看到这个电影的介绍的时候，我是怀着极大的热情和希望，想看到一部中国式的《百万英镑》，一部嘲讽式的黑色幽默的喜剧作品，但是看到最后结束，我很尬尴，没有等到我期待的大反转，也没有任何给我思想上的冲击，更没有任何印象深刻的梗或者是人物！说句实在话，我很失望！</p>
						</div>
					</div>
					<div class="comment" id="comment_2">
						<a class="fl"><img alt="" src="view/static/image/background.png" style="height: 90px; width: 65px;"></a>
						<div class="fl commsg">
							<span>电影名</span><br>
							<span>用户名</span>&nbsp;&nbsp;<span>评分：8.0</span>
							<p>
一直以来我都是喜剧电影的忠实粉丝，特别喜欢周星驰系列和金凯瑞系列的喜剧电影，对我来说他们的作品就是我喜欢的喜剧电影的标杆！

《西虹市首富》看到这个电影的介绍的时候，我是怀着极大的热情和希望，想看到一部中国式的《百万英镑》，一部嘲讽式的黑色幽默的喜剧作品，但是看到最后结束，我很尬尴，没有等到我期待的大反转，也没有任何给我思想上的冲击，更没有任何印象深刻的梗或者是人物！说句实在话，我很失望！</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>