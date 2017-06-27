
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZHKU娱乐网</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/style.css">
<link href="css/login.css" rel='stylesheet' type='text/css' />
<link href="css/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<style type="text/css">
audio {
	position: fixed;
	bottom: 0px;
	left: 500px;
}
i {
	font-size: 15px;
}
</style>
<script type="text/javascript">
	$(function() {
		if (<%out.print(session.getAttribute("user") != null);%>) {
			$("#user").html("<i class='Hui-iconfont'>&#xe62c;</i>用户");
			$("#login").css("display", "none");
		}
		if(<%out.print(request.getAttribute("error") != null);%>){
			alert("密码不正确！");
		}
		if(<%out.print(request.getAttribute("great") != null);%>){
			alert("注册成功！");
		}
		if(<%out.print(request.getAttribute("login") != null);%>){
			alert("请先登录！");
		}
		if(<%out.print(request.getAttribute("loginSuccess") != null);%>){
			alert("登录成功！");
		}
		$('#login').click(function() {
			$('#form').submit();
		});
		
		
	});

	function play(obj) {
		var url = obj.name;
		var audio = document.getElementById("play");
		audio.src = url;
	}
	function login() {
		document.getElementById("form").submit();
	}
	function check() {
		var a = document.getElementById("repsw");
		var b = document.getElementById("psw");
		if (a.value != b.value) {
			alert("密码不正确！");
		}
	}
</script>
</head>

<body>
	<div class="md-modal md-effect-9" id="modal-9">
		<div class="over"></div>
		<div class="md-content">
			<div class="form_div">
				<h3>注册</h3>
				<form action="register.action" id="register" class="form" method="post">
					<table>
						<tr>
							<td class="toRight"><label for="username"><span
									class="red">*</span>用户名：</label></td>
							<td><input type="text" placeholder="请输入用户名，作为该用户唯一标识"
								id="username" name="userBean.user_name"/></td>
						</tr>
						<tr>
							<td class="toRight"><label for="psw"><span
									class="red">*</span>用户密码：</label></td>
							<td><input type="password" placeholder="请输入密码" id="psw" name="userBean.user_psw"/></td>
						</tr>
						<tr>
							<td class="toRight"><label for="repsw"><span
									class="red">*</span>确认密码：</label></td>
							<td><input type="password" placeholder="请再次输入密码" id="repsw" onblur="check();"/></td>
						</tr>
						<tr>
							<td class="toRight"><label for="repsw"><span
									class="red">*</span>性别：</label></td>
							<td><select name="userBean.user_sex">
							<option value="男">男</option>
							<option value="女">女</option>
							</select></td>
						</tr>

					</table>
					<div class="form_buttons">
						<input type="submit" value="注册" /> <input type="reset" value="重置" />
					</div>
				</form>
				<p>
					<button class="md-close closeButton">×</button>
				</p>
			</div>
		</div>
	</div>
	<div class="container" style="padding: 30px;">
		<!-- 標題欄 -->
		<div class="row clearfix">
			<div class="col-md-5 column">
				<div class="row clearfix">
					<div class="col-md-6 column">
						<a href="index.html"><img src="img/logo2.jpg"
							style="width: 250px; height: 100px; position: relative; top: -25px;">
						</a>
					</div>
				</div>
			</div>
			<div class="col-md-7 column">
				<ul class="nav nav-pills">
					<li class="active"><a href="index.action"><i class="Hui-iconfont">&#xe625;</i>首页</a></li>
					<li><a href="music.action"><i class="Hui-iconfont">&#xe60f;</i>音乐</a></li>
					<li><a href="film.action"><i class="Hui-iconfont">&#xe64b;</i>电影</a></li>
					<li><a href="book.action"><i class="Hui-iconfont">&#xe720;</i>读书</a></li>
					<li><a href="topic.action"><i class="Hui-iconfont">&#xe622;</i>话题</a></li>
					<li><a href="#"><i class="Hui-iconfont">&#xe6a3;</i>联系我们</a></li>
					<s:if test="#session.user!=null">
						<li><a href="instructUser.action" id="user"></a></li>
						<li><a href="cancel.action"><i class="Hui-iconfont">&#xe66b;</i>注销</a></li>
					</s:if>
				</ul>
			</div>
		</div>
		<hr style="margin-top: 0px; margin-bottom: 10px">
		<!-- 登陸界面 -->
		<div class="row clearfix"
			style="background-image: url(img/login.jpg); background-position: -500px -500px; margin: 10px; padding: 5px;" id="login">
			<div class="col-md-8 column"></div>
			<div class="col-md-4 column">
				<div class="form-horizontal">
					<form method="post" id="form" action="login.action">
						<div class="form-group">
							<div class="col-sm-10">
								<input type="text" class="form-control" id="username"
									name="userBean.user_name" required="required" placeholder="输入用户名" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<input type="password" class="form-control" id="password"
									name="userBean.user_psw" required="required" placeholder="输入密码" />
							</div>
						</div>
					</form>
					<div class="form-group buttons">
						<ul>
							<li><a class="hvr-sweep-to-right" id="login"
								style="cursor: pointer;" onclick="login();">登录</a></li>

							<li><a class="hvr-sweep-to-left">
									<button class="md-trigger buttontype" data-modal="modal-9">注册</button>
							</a></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
		<!-- 中間部分 -->
		<div class="row clearfix" style="margin: -5px;">
			<div class="col-md-12 column">
				<div class="carousel slide" id="carousel-107257">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-107257"></li>
						<li data-slide-to="1" data-target="#carousel-107257"></li>
						<li data-slide-to="2" data-target="#carousel-107257"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="img/milkyway1.jpg"
								style="height: 400px; width: 1300px;" />
							<div class="carousel-caption">
								<h4>那个雨季</h4>
								<p>我们一起挥洒雨露</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/milkyway2.jpg"
								style="height: 400px; width: 1300px;" />
							<div class="carousel-caption">
								<h4>那个夜晚</h4>
								<p>我们一起仰望星空</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/milkyway4.jpg"
								style="height: 400px; width: 1300px;" />
							<div class="carousel-caption">
								<h4>那个时刻</h4>
								<p>我们彼此相知相惜</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-107257"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-107257"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>
		<div>
			<div class="index_capital">
				<div class="title">音乐</div>
				<!-- 显示在侧边栏 -->
				<div class="ind_left_sidebar">
				</div>
				<!-- 显示部分音乐 -->
				<div class="ind_content">
					<s:iterator value="arrayListMusic" status="music" begin="0" end="3">
						<div class="eachInfo tr_nOne">
							<img alt="300x200"
								src='<s:property value="mapMusicPic[music_id]"/>' width="100%"
								height="123px" />
							<div class="detail">
								<div class="star-bar star-bar-show size-S f-l va-m mr-10">
									<s:if test="mapMusicScore[music_id]!=null">
										<span class="star"
											style="width: <s:property value="mapMusicScore[music_id]*10"/>%"></span>
									</s:if>
									<s:else>
										<span class="star" style="width: 0%"></span>
									</s:else>
								</div>
								<p>
									<a href="musicInstruct.action?musicBean.music_id=<s:property value="music_id"/>"><s:property value="music_name" /></a>
								</p>
								<div>
									<a href="collectMusic.action?music_id=<s:property value="music_id"/>" class="btn btn-primary">收藏</a> <a
													style="cursor: pointer;"
													name="<s:property value=" music_play"/>"
													onclick="play(this)"">播放</a>
								</div>
							</div>
						</div>
					</s:iterator>



				</div>
				<!-- 显示比较热门音乐，主要超链接 -->
				<div class="ind_right_sidebar">
					热门音乐榜
					<ol>
						<s:iterator value="arrayListHotMusic" status="music" begin="0"
							end="4">
							<li><a href="musicInstruct.action?musicBean.music_id=<s:property value="music_id"/>"><s:property
										value="music_name" /></a></li>
						</s:iterator>
					</ol>
				</div>
			</div>
			<div class="spe"></div>
			<div class="index_capital">
				<div class="title">电影</div>
				<!-- 显示在侧边栏 -->
				<div class="ind_left_sidebar">
					
				</div>
				<!-- 显示部分电影 -->
				<div class="ind_content">
					<s:iterator value="arrayListFilm" status="film" begin="0" end="3">
						<div class="eachInfo tr_nOne">
							<img alt="300x200"
								src="<s:property value="mapFilmPic[film_id]"/>" width="100%"
								height="123px" />
							<div class="detail">
								<div class="star-bar star-bar-show size-S f-l va-m mr-10">
									<s:if test="mapFilmScore[film_id]!=null">
										<span class="star"
											style="width: <s:property value="mapFilmScore[film_id]*10"/>%"></span>
									</s:if>
									<s:else>
										<span class="star" style="width: 0%"></span>
									</s:else>
								</div>
								<p>
									<a href="filmInstruct.action?filmBean.film_id=<s:property value="film_id" />"><s:property value="film_name" /></a>
								</p>
								<div>
									<a href="collectFilm.action?film_id=<s:property value="film_id"/>" class="btn btn-primary">收藏</a> <a
										href="<s:property value="film_url"/>">下载</a>
								</div>
							</div>
						</div>
					</s:iterator>

				</div>
				<!-- 显示比较热门电影，主要超链接 -->
				<div class="ind_right_sidebar">
					热门电影榜
					<ol>
						<s:iterator value="arrayListHotFilm" status="film" begin="0"
							end="4">
							<li><a href="filmInstruct.action?filmBean.film_id=<s:property value="film_id"/>"><s:property
										value="film_name" /></a></li>
						</s:iterator>
					</ol>
				</div>
			</div>
			<div class="index_capital">
				<div class="title">读书</div>
				<!-- 显示在侧边栏 -->
				<div class="ind_left_sidebar">
					
				</div>
				<!-- 显示部分图书 -->
				<div class="ind_content">
					<s:iterator value="arrayListBook" status="book" begin="2" end="5">
						<div class="eachInfo tr_nOne">
							<img alt="300x200"
								src="<s:property value="mapBookPic[book_id]"/>" width="100%"
								height="123px" />
							<div class="detail">
								<div class="star-bar star-bar-show size-S f-l va-m mr-10">
									<s:if test="mapBookScore[book_id]!=null">
										<span class="star"
											style="width: <s:property value="mapBookScore[book_id]*10"/>%"></span>
									</s:if>
									<s:else>
										<span class="star" style="width: 0%"></span>
									</s:else>
								</div>
								<p>
									<a href="bookInstruct.action?bookBean.book_id=<s:property value="book_id"/>"><s:property value="book_name" /></a>
								</p>
								<div>
									<a href="collectBook.action?book_id=<s:property value="book_id"/>" class="btn btn-primary">收藏</a> <a href="#">阅览</a>
								</div>
							</div>
						</div>

					</s:iterator>
				</div>
				<div class="ind_right_sidebar">
					受欢迎的图书
					<ol>
						<s:iterator value="arrayListHotBook" status="book" begin="0"
							end="4">
							<li><a href="bookInstruct.action?bookBean.book_id=<s:property value="book_id" />"><s:property
										value="book_name" /></a></li>
						</s:iterator>
					</ol>
				</div>
			</div>
			<div class="index_capital">
				<div class="title">话题</div>
				<!-- 显示在侧边栏 -->
				<div class="ind_left_sidebar">
					
				</div>
				<!-- 显示部分话题 -->
				<div class="ind_content">
					<s:iterator value="arrayListActy" status="acty" begin="0" end="3">
						<div class="eachInfo tr_nOne">
							<img alt="300x200"
								src="<s:property value="mapActyPic[acty_id]"/>" width="100%"
								height="123px" />
							<div class="detail">
								<p>
									<s:property value="acty_title" />
								</p>
								<div>
									<a href="topicInstruct.action?actyBean.acty_id=<s:property value="acty_id"/>">评论</a>
								</div>
							</div>
						</div>

					</s:iterator>
				</div>
				<div class="ind_right_sidebar">
					热门话题榜
					<ol>
						<s:iterator value="arrayListHotActy" status="acty" begin="0"
							end="4">
							<li><a href="topicInstruct.action?actyBean.acty_id=<s:property value="acty_id"/>"><s:property
										value="acty_title" /></a></li>
						</s:iterator>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<script src="js/classie.js"></script>
	<script src="js/modalEffects.js"></script>
	<script>
		var polyfilter_scriptpath = '/js/';
	</script>
	<audio controls="controls" src="#" id="play" autoplay="autoplay"></audio>
</body>
</html>