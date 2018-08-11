<!DOCTYPE html>
<%@ page language="java" import="com.izoro.vo.Movie, java.util.List, com.izoro.vo.Comment" contentType="text/html; charset=UTF-8"
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
<title>movieMsg</title>

<style type="text/css">
#mMsg {
	width: 710px;
	height: 210px;
	overflow: hidden;
}
#mMsg img{
	width: 150px;
	height: 210px;
	float: left;
}
.font {
	font-size:  14px;
	color: RGB(105, 105, 105);
}
.over_flow{
	width: 410px;
    overflow:hidden;
    text-overflow:ellipsis;
    white-space: nowrap;/*加宽度width属来兼容部分浏览*/
}
.comments{
	height: 88px;
	margin-top: 20px;
	padding-bottom: 17px;
	border-bottom: 2px solid RGB(215, 227, 230);
}
#score{
	height: 205px;
	border-left: 2px solid RGB(215, 227, 230);
	padding-left: 20px;
}
#score span{
	font-size: 14px;
	color: rgb(105,105,105);
}
#stars {
	margin: 20px 0 20px 90px;
}
.star_i{
	
}
.power{
	float: left;
	background-color: rgb(255,244,92);
	margin: 2px 10px 1px 0;
	width: 100px;
	height: 15px;
}
.starstop{
	margin-right: 10px;
	float: left;
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
.mt40 {
	margin-top: 40px;
}
.movie{
	 overflow: hidden; 
}

.m_item{
	margin-top:15px;
	margin-right:20px;
	float:left;
	width: 117px;
	height: 206px;
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

.com_span{
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
}
</style>

<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		
		if(request.getAttribute("movie") == null){
	%>
	<jsp:forward page="/ShowbyMovie">
		<jsp:param value='<%=request.getParameter("mid") %>' name="movieId"/>
	</jsp:forward>
	<%}
		Movie m = (Movie)request.getAttribute("movie");
	%>
	
	 <%
	 if(m != null && request.getAttribute("tjmovie") == null){
	 %>
	<jsp:forward page="/MovieByTuijianShow">
		<jsp:param value='<%=m.getMovieType() %>' name="neirong"/>
		<jsp:param value="0" name="page"/>
		<jsp:param value='<%=request.getParameter("mid") %>' name="movieId"/>
	</jsp:forward>
	<%}
	%>
	<%
		if(request.getAttribute("result") == null){
	%>
	<jsp:forward page="/CommentShowByMovie">
		<jsp:param value='<%=request.getParameter("mid") %>' name="MovieId"/>
	</jsp:forward>
	<%
		}
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="height:5px;background-color: rgb(220,226,228);"></div>
	<div id="wrapper" style="width: 1200px; overflow: hidden; margin:45px auto 40px auto; ">
		<div id="left" style="width: 710px; height: 100%; float:left;">
			<div id="mMsg">
				<img alt="loading...." onerror="this.src='view/static/image/background.png;this.onerror=null'" src="<%=m.getMovieImage() %>">
				<div style="display: inline-block; margin-left: 40px; float: left;">
					<h1 style="margin-bottom: 14px;"><%=m.getMoviename() %><span style="color: gray;">（<%=m.getMovieTime().substring(0, 4) %>）</span></h1>
					<p class="font over_flow">导演：<%=m.getMovieDirect() %></p>
					<p class="font over_flow">编剧：</p>
					<p class="font over_flow">主演：<%=m.getMovieMainpeople() %></p>
					<p class="font over_flow">类型：<%=m.getMovieType() %></p>
					<p class="font over_flow">制片国家/地区：<%=m.getMoveSpace() %></p>
					<p class="font over_flow">语言：</p>
					<p class="font over_flow">片长：</p>
					<p class="font over_flow">制片时间：<%=m.getMovieTime().substring(0, 11) %></p>
				</div>
				<span style="color: white; background-color: RGB(52, 180, 215); cursor:default; display:inline-block; margin-left: 15px;">想 看</span><span style="color: white; cursor:default; background-color: RGB(52, 180, 215); margin-top: 20px; margin-left: 20px;">已 看</span>
			</div>
			<div id="mIntro" class="mt40">
				<p>简介......</p>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="font"><%=m.getMovieIntuduce() %></span>
			</div>
			<div id="mComment" class="mt40">
				<%
					List<Comment> c = (List<Comment>)request.getAttribute("result");
				
					//String p = "";
					//int pageNum = request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));//默认首页
					
					/* String url = request.getRequestURL().toString();
					if(url.indexOf("pageNum=") != -1){
						String[] strs = url.split("&");	//避免与其他参数混淆
						p = strs[0].split("=")[1];
						pageNum = Integer.parseInt(p);
					}
					else{
						pageNum = 1;
					} */
					//int datas = c.size();//设一个总数据数
					//int pageNum = request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));//默认首页
					//int pageSize = 5;
					//int pageSize = request.getParameter("pageSize")==null?5:Integer.parseInt(request.getParameter("pageSize"));//默认为5条
					//int totalPages = datas % pageSize == 0? (datas/pageSize):(datas/pageSize+1);//计算总页数
					
				%>
				<div class="headline">&nbsp;&nbsp;影评<a href="javascript:void(0)" class="more">更多>></a></div>
				<%
					if(c != null){
						int num = c.size()>5? 5:c.size();
						for(int i = 0; i<num; i++){
							out.print("<div class='comments'>");
							out.print("<a>"+c.get(i).getCommentPeople()+"</a>&nbsp;&nbsp;&nbsp;<span style='color: gray;'>"+c.get(i).getCommentTime().substring(0, 10)+"</span><br>");
							out.print("<a><span class='com_span font'>"+c.get(i).getCommentContent()+"</span></a>");
							out.print("</div>");
						}
					}
					/* for(int i = (pageNum-1)*pageSize; i<(pageNum-1)*pageSize+5; i++){
						out.print("<div class='comments'>");
						out.print("<a>"+c.get(i).getCommentPeople()+"</a>&nbsp;&nbsp;&nbsp;<span style='color: gray;'>"+c.get(i).getCommentTime().substring(0, 10)+"</span><br>");
						out.print("<a><span class='com_span font'>"+c.get(i).getCommentContent()+"</span></a>");
						out.print("</div>");
					} */
				%>
				<p style="margin-top: 17px; text-align: right;">
					<%
						//if(pageNum > 1){
					%>
					<a target="_self" href="view/movieMsg.jsp#mComment?mid=<%=request.getParameter("mid") %>&pageNum=" style="margin-right: 30px;">上一页</a>
					<%//} %>
					
					<%
						//if(pageNum < totalPages){
					%>
					<a target="_self" href="view/movieMsg.jsp?mid=<%=request.getParameter("mid") %>&pageNum=">下一页</a>
					<%//} %>
				</p>
			</div>
		</div>
		
		<div id="right" style="height: 740px; width: 420px; float:right; margin-left: 70px;">
			<div id="score">
				<h1><span>FandT评分</span>&nbsp;<%=m.getMovieScore() %>&nbsp;<span><%=m.getMovieAmount() %>人评价</span></h1>
				<div id="stars">
					<div class="star_i">
						<span class="starstop" title="力荐">5星</span><div class="power"></div><span>25%</span>
					</div>
					<div class="star_i">
						<span class="starstop" title="推荐">4星</span><div class="power"></div><span>25%</span>
					</div>
					<div class="star_i">
						<span class="starstop" title="还行">3星</span><div class="power"></div><span>25%</span>
					</div>
					<div class="star_i">
						<span class="starstop" title="较差">2星</span><div class="power"></div><span>25%</span>
					</div>
					<div class="star_i">
						<span class="starstop" title="很差">1星</span><div class="power"></div><span>25%</span>
					</div>
				</div>
				<span>我来评分</span>
				<span style="margin-left: 40px;">
					<img alt="" style="height: 20px; width: 20px; vertical-align: text-top;" src="view/static/image/star.png">
					<img alt="" style="height: 20px; width: 20px; vertical-align: text-top;" src="view/static/image/star.png">
					<img alt="" style="height: 20px; width: 20px; vertical-align: text-top;" src="view/static/image/star.png">
					<img alt="" style="height: 20px; width: 20px; vertical-align: text-top;" src="view/static/image/star.png">
					<img alt="" style="height: 20px; width: 20px; vertical-align: text-top;" src="view/static/image/star.png">
				</span>
			</div>
			<div id="commend" class="mt40">
				<div class="headline">&nbsp;&nbsp;相关推荐<a href="javascript:void(0)" class="more">更多>></a></div>
				<div class="movie">
			  		<%
			  			List<Movie> tjm = (List<Movie>)request.getAttribute("tjmovie");
			  			if(tjm == null){
			  				out.print("Loading......");
			  			}
			  			else{
			  				int n = tjm.size()>6? 6:tjm.size();
			  				for(int i=0; i<n; i++)
				  			{
				  				out.print("<div class='m_item'>");
				  				out.print("<img class='Poster' alt='loading...' onerror=\"this.src='view/static/image/background.png;this.onerror=null'\" src='"+tjm.get(i).getMovieImage()+"'>");
				  				out.print("<a href='view/movieMsg.jsp?mid="+tjm.get(i).getMovieId()+"'>");
				  				out.print("<p title='"+tjm.get(i).getMoviename()+"' class='movieName'>"+tjm.get(i).getMoviename()+"</p>");
				  				out.print("</a>");
				  				out.print("<span style='font-size: 14px; margin-left: 29px;'>评分 :</span><span class='movieScore'>"+tjm.get(i).getMovieScore()+"</span>");
				  				out.print("</div>");
				  			}
			  			}
			  		 %> 
			  		</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>