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
    
    <title>个人信息</title>
    
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
			position: relative; /*解决footer显示问题*/
		}
		
		.main{
			width:1200px;
			margin: auto;
			margin-bottom: 40px;
		}
		.upD{
			width:1200px;
			height: 315px;
			overflow: hidden;
		}
		.upDitem{
			float: left;
		}
		
		.exitItem{
			float: right;
			margin-top: 210px;
		}
		.downD{
			overflow: hidden;
			width:1200px;
		}
		
		.leftI{
			width:200px;
			float: left;
		}
		
		.rightI{
			width:1000px;
			float: left;
		}
		
		.headiconI{
			margin-top:70px;
			width: 206px;
			height: 206px;
			border-radius: 50%;
			border: 3px solid RGB(51,180,215); 
			box-sizing: content-box;
		}
		.NameI{
			margin-top:158px;
			margin-left:60px;
			font-size: 30px;
		}
		.IntroduceI{
			color: gray;
			margin-left:60px;
			margin-top: 28px;
		}
		.exitI{
			font-size: 16px;
			color:gray;
			text-decoration: none;
		}
		.exitI:HOVER {
			opacity: 0.8;
		}
		.exitI:ACTIVE {
			opacity: 0.5;
		}
		
		#listI{
			list-style-type: none;
		}
		
		.liInfor{
			line-height: 52px;
			width:160px;
			height:52px;
			border:12px solid rgb(50, 180, 215);
			border-top:none;
			border-bottom:none;
			border-right: none;
			font-size: 18px;
			margin-bottom: 20px;
		}
		
		.liInforActive{
			line-height: 52px;
			width:160px;
			height:52px;
			border:12px solid rgb(50, 180, 215);
			border-top:none;
			border-bottom:none;
			border-right: none;
			font-size: 18px;
			margin-bottom: 20px;
			background-color: rgb(230,238,240);
		}
		
		.liInfor:HOVER {
			background-color: rgba(50, 180, 215,0.08);
			cursor: pointer;
		}
		
		.PagingButton{
			height: 64px;
			position: relative;;
		}
		
		.PagingButton a{
			color:gray;
			position: absolute;
			bottom: 7px;
			right: 17px;
		}
		
		.PagingButton a:hover{
			opacity: 0.8;
		}
		
		.PagingButton a:ACTIVE{
			opacity: 0.5;
		}
		
		.contentD{
			height: 128px;
			position: relative;
			border: 2px solid RGB(212,223,226);
			box-sizing: content-box;
			border-left: none;
			border-right: none;
			border-top:none;
		}
		
		.titleS{
			position:absolute;
			top:23px;
			left:30px;
			font-size: 20px;
			color:rgb(74,186,218);
		}
		
		.contentS{
			position: absolute;
			width: 800px;
			left:30px;
			top:55px;
			overflow: hidden;
			text-overflow: ellipsis;
			display: -webkit-box;
		    -webkit-box-orient: vertical;
		    -webkit-line-clamp: 2;
		}
		
		.contentB{
			position:absolute;
			color:gray;
			font-size:15px;
			top:55px;
			right: 17px;
		}
		
		.contentB:hover{
			opacity: 0.8;
		}
		
		.contentB:ACTIVE{
			opacity: 0.5;
		}
		
		.contentTime{
			position:absolute;
			top:90px;
			right:17px;
			color:gray;
			font-size:15px;
		}
		
		#div4{
			position: relative;
		}
		
		.inputD{
			position: absolute;
		}
		
	</style>
	<script type="text/javascript">		
		 function changeI(b){
			var sNode =document.getElementById("listI").getElementsByTagName("li");
			var nowDivid = b.id;
			var showDiv ;
			switch(nowDivid)
			{
				case "li1":
					showDiv=document.getElementById("div1");
					hDiv2=document.getElementById("div2");
					hDiv3=document.getElementById("div3");
					hDiv4=document.getElementById("div4");
					showDiv.style.display="";
					hDiv2.style.display="none";
					hDiv3.style.display="none";
					hDiv4.style.display="none";
					break;
				case "li2":
					showDiv=document.getElementById("div2");
					hDiv2=document.getElementById("div1");
					hDiv3=document.getElementById("div3");
					hDiv4=document.getElementById("div4");
					showDiv.style.display="";
					hDiv2.style.display="none";
					hDiv3.style.display="none";
					hDiv4.style.display="none";
					break;
				case "li3":
					showDiv=document.getElementById("div3");
					hDiv2=document.getElementById("div1");
					hDiv3=document.getElementById("div2");
					hDiv4=document.getElementById("div4");
					showDiv.style.display="";
					hDiv2.style.display="none";
					hDiv3.style.display="none";
					hDiv4.style.display="none";
					break;
				case "li4":
					showDiv=document.getElementById("div4");
					hDiv2=document.getElementById("div1");
					hDiv3=document.getElementById("div3");
					hDiv4=document.getElementById("div2");
					showDiv.style.display="";
					hDiv2.style.display="none";
					hDiv3.style.display="none";
					hDiv4.style.display="none";
					break;
				
			}
			
			for(var j=0;j<sNode.length;j++){
					sNode[j].className="liInfor";
					
				}
				b.className="liInforActive";
		} 
	</script>
	<script type="text/javascript">

function loginF(){
 var a = document.getElementById("pwd").value;
 var b = document.getElementById("confirmPwd").value;
 var strA=a.replace(/(^\s*)|(\s*$)/g, "");
 var strB=b.replace(/(^\s*)|(\s*$)/g, "");
 if(strA==""||strB=="")
 {
 	window.alert("请输入密码");
	return false;
 }
 else{
 if(strA!=strB)
 {
	window.alert("请确认两次密码是否相同！");
	return false;
 }
 }
 return true;
}
</script>
  </head>
  
  <body>
     <%
  	if(request.getAttribute("result")==null)
  	{%>
  		<jsp:forward page="/CommentShowByOwn">
  			<jsp:param value='${sessionScope.userId }'  name="userId"/>
  		</jsp:forward>
  	<%} 	
   %>    
   
   
      <%
  	if(request.getAttribute("movies")==null)
  	{%>
  		<jsp:forward page="/WantMovieShow">
  			<jsp:param value='${sessionScope.userId }'  name="peopleId"/>
  		</jsp:forward>
  	<%} 	
   %>  
   

   
     <%
  	if(request.getAttribute("resultM")==null)
  	{%>
  		<jsp:forward page="/ShowMess">
  			<jsp:param value='${sessionScope.userId }'  name="userId"/>
  		</jsp:forward>
  	<%} 	
   %>  
    
    
   
   <%
  	if(request.getAttribute("resultD")!=null)
  	{%>
						<script type="text/javascript">
							alert("删除成功！");
						</script>
				  <%} 	
				 
   %>
   
   <%
  	if(request.getAttribute("resultDM")!=null)
  	{%>
						<script type="text/javascript">
							alert("删除成功！");
						</script>
				  <%} 	
				 
   %>
   
    <%
  	if(request.getAttribute("resultWM")!=null)
  	{%>
						<script type="text/javascript">
							alert("删除成功！");
						</script>
				  <%} 	
				 
   %> 
   
    <%
    if(request.getAttribute("reslutC")!=null){
  	  	String reslutC= request.getAttribute("reslutC").toString();
  	  	switch(reslutC)
  	{
  		case "1":
  		 %><script type="text/javascript">
			alert("修改成功！");
		   </script>
		<% break;
		case "0":%>
		   <script type="text/javascript">
			alert("修改失败！");
		   </script><% 
		   break;
	 }} %>  
   
  <jsp:include page="header.jsp"></jsp:include>
  <div style="height:5px;background-color: rgb(220,226,228);"></div>
    <div class="main">
    	<div class="upD">
    		 <div class="upDitem"><img src="${sessionScope.userFace }" onerror="this.src='view/static/image/default.png;this.onerror=null'" id="headiconB" class="headiconI" /></div>
    		 <div class="upDitem"><p id="userNameI" class="NameI">${sessionScope.username}</p>
    							  <p id="userIntroduceI" class="IntroduceI">${sessionScope.userIntriduce}</p></div>
    		 <div class="exitItem"><a href="/MovieContent/view/cancellation.jsp"  class="exitI">退出登录>></a></div>
    	</div>
    	<div class="downD">
    		<div class="leftI">
    			<ul id="listI">
    				<li onclick="changeI(this)" class="liInforActive" id='li1'> <span style="margin-left: 38px;">我的留言</span></li>
    				<li onclick="changeI(this)" class="liInfor" id='li2'><span style="margin-left: 38px;">我最想看</span></li>
    				<li onclick="changeI(this)" class="liInfor" id='li3'><span style="margin-left: 38px;">已经看过</span></li>
    				<li onclick="changeI(this)" class="liInfor" id='li4'><span style="margin-left: 38px;">修改信息</span></li>
    			</ul>
    		</div>
    		<div class="rightI">
    			<!-- <div class="PagingButton"><a href="javascript:void(0)" style="right: 80px;">上一页</a><a href="javascript:void(0)">下一页</a></div> -->
    			  <div id="div3" style="display: none;">
    			    <%
    			   	List<CommentOne> li=(List)request.getAttribute("result");
    			   	Iterator it=li.iterator();
    			   	while(it.hasNext())
    			   	{
    			   		CommentOne a=(CommentOne)it.next();
		  				out.print("<div class='contentD'>");
		  				out.print("<span class='titleS'>"+a.getCommentPeople()+" 评分："+a.getCommentLevel()+"（"+a.getCommentMovieName()+"）</span>");
		  				out.print("<span class='contentS'>"+a.getCommentContent()+"</span>");
		  				out.print("<a href='CommentShowBycommentId?CommentId="+a.getCommentId()+"' style='right: 68px;' class='contentB'>查看详情</a>");
		  				out.print("<a href='DeleteComment?commentId="+a.getCommentId()+"' class='contentB'>删除</a>");
		  				out.print("<span class='contentTime'>"+a.getCommentTime()+"</span>"); 
		  				out.print("</div>");
		  			}
		  		%>   
    			  </div>
    			  <div id="div2" style="display: none;">
    			<%
    			   	List<WanttoMovie> li3=(List)request.getAttribute("movies");
    			   	Iterator it3=li3.iterator();
    			   	while(it3.hasNext())
    			   	{
    			   		WanttoMovie wm=(WanttoMovie)it3.next();
		  				out.print("<div class='contentD'>");
		  				out.print("<span class='titleS'>"+wm.getMoviename()+"</span>");
		  				out.print("<span class='contentS'>"+wm.getMovieIntuduce()+"</span>");
		  				out.print("<a href='view/movieMsg.jsp?mid="+wm.getMovieId()+"' style='right: 68px;' class='contentB'>查看详情</a>");
		  				out.print("<a href='WantMovieDelete?movieId="+wm.getMovieId()+"' class='contentB'>删除</a>");
		  				out.print("<span class='contentTime'>"+wm.getMovieTime()+"</span>");
		  				out.print("</div>");
		  			}
		  		%> 
    			  </div>
    			  <div id="div1">
    			   <%
    			   	List<MessageOne> li2=(List)request.getAttribute("resultM");
    			   	Iterator it2=li2.iterator();
    			   	while(it2.hasNext())
    			   	{
    			   		MessageOne m=(MessageOne)it2.next();
		  				out.print("<div class='contentD'>");
		  				out.print("<span class='titleS'>对"+m.getMessageoneName()+"的回复</span>");
		  				out.print("<span class='contentS'>"+m.getMessageContent()+"</span>");
		  				/* out.print("<a href='javascript:void(0)' style='right: 68px;' class='contentB'>查看详情</a>"); */
		  				out.print("<a href='DeleteMess?MessageId="+m.getMessageId()+"' class='contentB'>删除</a>");
		  				out.print("<span class='contentTime'>"+m.getMessageTime()+"</span>");
		  				out.print("</div>");
		  			}
		  		%>  
    			  </div>
    			  <div id="div4" style="display: none">
    			  	<form action="UpdateUser" onsubmit="return loginF()" method="post">
    			  		<div class="inputD" style="top:50px;right:650px;">id<input type="text" readonly="readonly" value=${sessionScope.userId} name="userId" /></div>
    			  		<div class="inputD" style="top:50px;right:350px;">用户名<input type="text" value=${sessionScope.username} name="userName" /></div>
    			  		<div class="inputD"style="top:90px;right:650px;">密码<input type="password" name="userPassword" id="pwd" /></div>
    			  		<div class="inputD" style="top:90px;right:350px;">确认密码<input type="password"  id="confirmPwd" /></div>
    			  		<div class="inputD"style="top:130px;right:650px;">地址<input type="text" value=${sessionScope.UserDire} name="userDire" /></div>
    			  		<div class="inputD"style="top:130px;right:350px;">头像（网络地址）<input type="text" value=${sessionScope.userFace} name="userFace" /></div>
    			  		<div class="inputD"style="top:170px;right:650px;">自我介绍<input type="text" value=${sessionScope.userIntriduce} name="userIntriduce" /></div>
    			  		<div class="inputD"style="top:170px;right:350px;">邮箱<input type="text" value=${sessionScope.userMail} name="eMail" /></div>
    			  		<div class="inputD"style="top:210px;right:450px; "><input type="submit" value="修改"/></div>
    			  	</form>
    			  </div>
    			  
    		</div>
    	</div>
    </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
