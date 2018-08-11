<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.izoro.vo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电影评论</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	*{
		padding:0;
		margin:0;
	}
	body{
		position: relative;
		
	}
	
	.mainFR{
		width: 1200px;
		margin: auto;
		margin-bottom: 40px;
	}
	
	.upFR{
		margin-top: 78px;
		border: 2px solid RGB(215,227,230);
		box-sizing: border-box;
		border-left: none;
		border-right: none;
		border-top:none;
	}
	
	.mainFR p{
		text-indent:2em;
	}
	
	.downFR{
	}
	
	.reviewFR{
		overflow: hidden;
		
	}
	
	.iconBox{
		margin-top:25px;
	    margin-left:25px;
	    margin-right:30px;
		float: left;
	}
	
	.headiconI{
		width: 70px;
		height: 70x;
		border-radius: 50%;
		border: 3px solid RGB(51,180,215); 
		box-sizing: content-box;
	}
		
	.reviewR{
		padding-top:25px;
		float: left;
		width: 1069px;
		height: 101px;
		border: 2px solid RGB(215,227,230);
		box-sizing: border-box;
		border-left: none;
		border-right: none;
		border-top:none;
	}
	#zan:hover {
		opacity: 0.8;
	}
	#zan:active {
		opacity: 0.5;
	}
	</style>
  </head>
  
  <body>
  <jsp:include page="header.jsp"></jsp:include>
  <div class="mainFR">
      <div class="upFR">
      	<h1 style="margin-bottom: 20px;">  ${commentByCommentId.getCommentMovieName()}</h1>
      	<div style="margin-bottom: 23px;">
	      	<span>${commentByCommentId.getCommentPeople()}</span>
	      	<span style="color:gray;">评论</span>
	      	<span>${commentByCommentId.getCommentLevel()}分</span>
	      	<span style="color:gray;margin-left: 90px;"> ${commentByCommentId.getCommentTime()}</span>
	      	<a id="zan" href="Dianzan?commentId=${commentByCommentId.commentId }" style="color:gold;margin-left: 500px; text-decoration: none;">${commentByCommentId.getCommentLikes()} like</a>
      	</div>
      	<div style="margin-bottom: 35px">
	      	<p>  ${commentByCommentId.getCommentContent()} </p>
		</div>
      </div>
	  <div class="downFR">
	  	<%for(int i=0;i<5;i++)
		  			{
		  				out.print("<div class='reviewFR'>");
		  				out.print("<div class='iconBox'><img src='view/static/image/default.png'  id='headiconB' class='headiconI' /></div>");
		  				out.print("<div class='reviewR'>");
		  				out.print("<span style='margin-right: 38px'>恨大西</span>");
		  				out.print("<span style='color:gray;'>2018/7/31</span>");
		  				out.print("<span style='margin-left:6px; color:gray;'>18:00</span>");
		  				out.print("<p style='margin-top: 12px;text-indent:0;'>大撒都觉得撒离开你们称其为没礼貌我企鹅群反倒是官方代购</p>");
		  				out.print("</div>");
		  				out.print("</div>");
		  			}
		 %>
	  </div>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
