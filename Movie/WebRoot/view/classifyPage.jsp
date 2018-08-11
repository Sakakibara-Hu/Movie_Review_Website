<%@ page language="java" import="java.util.*, com.izoro.vo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>分类搜索</title>
    
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
	/* overflow-x: hidden;  */
	position: relative;
	}
	.main{
		overflow:hidden;
		padding-top:62px;
		width:1200px;
		margin: auto;
		margin-bottom: 40px;
	}
	.left{
		width: 785px;
		float:left;
	}
	.right{
		width:415px;
		float:left;
	}
	.classify{
	}
	
	.movie{
		 overflow: hidden; 
	}
	
	.item{
		margin-top:35px;
		margin-right:35px;
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
	}
	
	.movieScore{
		font-size: 14px;
	}
	
	.rankPage{
		line-height: 52px;
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
	
	.rank{
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
	
	.classifyList{
		list-style-type: none;
		overflow: hidden;
	}
	.classifyList li{
		float: left;
	}
	
	.tag{
		padding:0 10px;
		font-size: 20px;
		margin-right: 20px;
		color:black;
		text-decoration: none;
	}
	
	.tag:HOVER{
		color:rgb(50, 180, 215);
		cursor:hand; 
	}
	
	.spanActive{
		color:white;
		background-color: rgb(50, 180, 215);
	}
	
	.spanActive:HOVER{
		color:white;
		background-color: rgb(50, 180, 215);
	}
	
	</style>
	
	<script type="text/javascript">		
		 function change(b){
		 	var id = b.parentElement.parentElement.id;
		 	//alert(id);
			var sNode =document.getElementById(id).getElementsByTagName("a");
			for(var j=0;j<sNode.length;j++){
					sNode[j].className="tag";
				}
				b.className="spanActive tag";
		} 
		
		
	</script>
  </head>
  
  <body>
  <jsp:include page="header.jsp"></jsp:include>
  <div style="height:5px;background-color: rgb(220,226,228);"></div>
  <div class="main">
  	<div class="left">
  		<div class="classify">
  			<ul id="format" class="classifyList">
  					<li style="height: 28px"><a href="javascript:void(0)" onclick="change(this)" class="spanActive tag">全 部 形 式</a></li>
  					<li><a href="javascript:void(0)" onclick="change(this)" class="tag" id="dianying">电影</a></li>
  					<li><a href="javascript:void(0)" onclick="change(this)" class="tag" id="dianshiju" >电视剧</a></li>
  					<li><a href="javascript:void(0)" onclick="change(this)" class="tag" id="zongyi" >综艺</a></li>
  					<li><a href="javascript:void(0)" onclick="change(this)" class="tag" id="donghua" >动画</a></li>
  					<li><a href="javascript:void(0)" onclick="change(this)" class="tag" id="jilupian" >纪录片</a></li>
  					<li><a href="javascript:void(0)" onclick="change(this)" class="tag" id="duanpian" >短片</a></li>
  			</ul>
  			<ul id="movieStyle" class="classifyList" style="margin-top: 20px">
  					<li style="height: 84px"><a href="MovieSearchBySpace?type=&tid=tall&space=${space}&sid=${sid}" onclick="change(this)" class="spanActive tag" id="tall">全 部 类 型</a></li>
  					<li><a href="MovieSearchBySpace?type=剧情&tid=juq&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="juq">剧情</a></li>
  					<li><a href="MovieSearchBySpace?type=喜剧&tid=xij&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="xij">喜剧</a></li>
  					<li><a href="MovieSearchBySpace?type=动作&tid=dongz&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="dongz">动作</a></li>
  					<li><a href="MovieSearchBySpace?type=爱情&tid=aiq&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="aiq">爱情</a></li>
  					<li><a href="MovieSearchBySpace?type=科幻&tid=keh&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="keh">科幻</a></li>
  					<li><a href="MovieSearchBySpace?type=悬疑&tid=xuany&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="xuany">悬疑</a></li>
  					<li><a href="MovieSearchBySpace?type=惊悚&tid=jings&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="jings">惊悚</a></li>
  					<li><a href="MovieSearchBySpace?type=恐怖&tid=kongb&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="kongb">恐怖</a></li>
  					<li><a href="MovieSearchBySpace?type=犯罪&tid=fanz&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="fanz">犯罪</a></li>
  					<li><a href="MovieSearchBySpace?type=同性&tid=tongx&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="tongx">同性</a></li>
  					<li><a href="MovieSearchBySpace?type=音乐&tid=yiny&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="yiny">音乐</a></li>
  					<li><a href="MovieSearchBySpace?type=歌舞&tid=gew&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="gew">歌舞</a></li>
  					<li><a href="MovieSearchBySpace?type=传记&tid=zhuanj&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="zhuanj">传记</a></li>
  					<li><a href="MovieSearchBySpace?type=历史&tid=lis&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="lis">历史</a></li>
  					<li><a href="MovieSearchBySpace?type=战争&tid=zhanz&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="zhanz">战争</a></li>
  					<li><a href="MovieSearchBySpace?type=西部&tid=xib&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="xib">西部</a></li>
  					<li><a href="MovieSearchBySpace?type=奇幻&tid=qih&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="qih">奇幻</a></li>
  					<li><a href="MovieSearchBySpace?type=冒险&tid=maox&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="maox">冒险</a></li>
  					<li><a href="MovieSearchBySpace?type=灾难&tid=zain&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="zain">灾难</a></li>
  					<li><a href="MovieSearchBySpace?type=武侠&tid=wux&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="wux">武侠</a></li>
  					<li><a href="MovieSearchBySpace?type=情色&tid=qings&space=${space}&sid=${sid}" onclick="change(this)" class="tag" id="qings">情色</a></li> 
  			</ul>
  			<ul id="region" class="classifyList" style="margin-top: 20px">
  					<li style="height: 84px"><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=&sid=sall" onclick="change(this)" class="spanActive tag" id="sall">全 部 地 区</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=中国大陆&sid=cn" onclick="change(this)" class="tag" id="cn">中国大陆</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=美国&sid=sa" onclick="change(this)" class="tag" id="sa">美国</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=香港&sid=hk" onclick="change(this)" class="tag" id="hk">香港</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=台湾&sid=tw" onclick="change(this)" class="tag" id="tw">台湾</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=日本&sid=rb" onclick="change(this)" class="tag" id="rb">日本</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=韩国&sid=han" onclick="change(this)" class="tag" id="han">韩国</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=英国&sid=ying" onclick="change(this)" class="tag" id="ying">英国</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=法国&sid=fa" onclick="change(this)" class="tag" id="fa">法国</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=德国&sid=de" onclick="change(this)" class="tag" id="de">德国</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=意大利&sid=ydl" onclick="change(this)" class="tag" id="ydl">意大利</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=西班牙&sid=xby" onclick="change(this)" class="tag" id="xby">西班牙</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=印度&sid=yd" onclick="change(this)" class="tag" id="yd">印度</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=泰国&sid=tai" onclick="change(this)" class="tag" id="tai">泰国</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=俄罗斯&sid=els" onclick="change(this)" class="tag" id="els">俄罗斯</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=伊朗&sid=yl" onclick="change(this)" class="tag" id="yl">伊朗</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=加拿大&sid=jnd" onclick="change(this)" class="tag" id="jnd">加拿大</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=澳大利亚&sid=adly" onclick="change(this)" class="tag" id="adly">澳大利亚</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=爱尔兰&sid=ael" onclick="change(this)" class="tag" id="ael">爱尔兰</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=瑞典&sid=rd" onclick="change(this)" class="tag" id="rd">瑞典</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=巴西&sid=bx" onclick="change(this)" class="tag" id="bx">巴西</a></li>
  					<li><a href="MovieSearchBySpace?type=${type}&tid=${tid}&space=丹麦&sid=dm" onclick="change(this)" class="tag" id="dm">丹麦</a></li> 
  			</ul>
  		</div>
  		
  		
  		<%
  			if(request.getAttribute("type")==null&&request.getAttribute("space")==null){
  			}else{
  			 String tid=request.getAttribute("tid").toString(); 
  			 String sid=request.getAttribute("sid").toString(); 
  			 
  			out.print("<script type='text/javascript'>");
  					
		 	out.print("document.getElementById('"+tid+"').onclick();");
		 	out.print("document.getElementById('"+sid+"').onclick();");
			out.print("</script>");
  			}
  		 %>
  		
  		<div class="movie">
  		<%
  			List<Movie> m = (List<Movie>)request.getAttribute("movie");
  			if(m != null){
  				for(int i=0; i<m.size(); i++){
  					out.print("<div class='item'>");
	  				out.print("<img class='Poster' alt='loading...' onerror=\"this.src='view/static/image/background.png;this.onerror=null'\" src='"+m.get(i).getMovieImage()+"'>");
	  				out.print("<a href='view/movieMsg.jsp?mid="+m.get(i).getMovieId()+"'>");
	  				out.print("<p title='"+m.get(i).getMoviename()+"' class='movieName'>"+m.get(i).getMoviename()+"</p>");
	  				out.print("</a>");
	  				out.print("<span style='font-size: 14px; margin-left: 29px;'>评分 :</span><span class='movieScore'>"+m.get(i).getMovieScore()+"</span>");
	  				out.print("</div>");
  					/* out.print("<div class='item'>");
  	  				out.print("<img class='Poster' alt='loading...' src='view/static/image/background.png'>");
  	  				out.print("<p class='movieName'>我不是药神</p>");
  	  				out.print("<span style='font-size: 14px; margin-left: 29px;'>评分 :</span><span class='movieScore'>9.0</span>");
  	  				out.print("</div>"); */
  				}
  			}
  			else{
  				for(int i=0;i<20;i++)
  	  			{
  	  				out.print("<div class='item'>");
  	  				out.print("<img class='Poster' alt='loading...' src='view/static/image/background.png'>");
  	  				out.print("<p class='movieName'>我不是药神</p>");
  	  				out.print("<span style='font-size: 14px; margin-left: 29px;'>评分 :</span><span class='movieScore'>9.0</span>");
  	  				out.print("</div>");
  	  			}
  			}
  		 %> 
  		</div>
  	</div>
  <div class="right">
  		<div class="rankPage">&nbsp;&nbsp;排行榜<a href="#" class="more">更多>></a>
  		</div>
  		<div class="rank">
  			<ul class="rankList">
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
  			</ul>
  		</div>
  </div>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
  
  
</html>

