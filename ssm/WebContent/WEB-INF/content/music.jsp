<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>ZHKU娱乐网|音乐</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/selectStyle.css">
<link rel="stylesheet" href="css/style.css">
<link href="css/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/music_show.js"></script>
<style type="text/css">
audio {
	position: fixed;
	bottom: 0px;
	left: 500px;
}
</style>
<script type="text/javascript">
	function play(obj) {
		var url = obj.name;
		var audio = document.getElementById("play");
		audio.src = url;
	}
	$(function() {
		if (<%out.print(session.getAttribute("user") != null);%>) {
			$("#user").html("<i class='Hui-iconfont'>&#xe62c;</i>用户");
		}
		if(<%out.print(request.getAttribute("msg") != null);%>){
			alert("收藏成功！");
		}
	});
	
</script>
</head>
<body>
	<div class="container" style="padding: 30px;">
		<!-- 導航欄 -->
		<div class="row clearfix">
			<div class="col-md-5 column">
				<div class="row clearfix">
					<div class="col-md-6 column">
						<img src="img/logo2.jpg"
							style="width: 250px; height: 100px; position: relative; top: -25px;">
					</div>
				</div>
			</div>
			<div class="col-md-7 column">
				<ul class="nav nav-pills">
					<li><a href="index.action"><i class="Hui-iconfont">&#xe625;</i>首页</a></li>
					<li  class="active"><a href="music.action"><i class="Hui-iconfont">&#xe60f;</i>音乐</a></li>
					<li><a href="film.action"><i class="Hui-iconfont">&#xe64b;</i>电影</a></li>
					<li><a href="book.action"><i class="Hui-iconfont">&#xe720;</i>读书</a></li>
					<li><a href="topic.action"><i class="Hui-iconfont">&#xe622;</i>话题</a></li>
					<li><a href="#"><i class="Hui-iconfont">&#xe6a3;</i>联系我们</a></li>
					<s:if test="#session.user!=null">
						<li><a href="instructUser.action" id="user">用户</a></li>
						<li><a href="cancel.action"><i class="Hui-iconfont">&#xe66b;</i>注销</a></li>
					</s:if>
				</ul>
			</div>
		</div>
		<hr style="margin-top: 0px; margin-bottom: 10px">
		<!-- 分類欄 -->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<a class="navbar-brand" href="music.action">分类</a>
					</div>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav" id="classfiy">
							<li><a href="musicType.action?musicType=摇滚">摇滚</a></li>
							<li><a href="musicType.action?musicType=流行">流行</a></li>
							<li><a href="musicType.action?musicType=古典">古典</a></li>
							<li><a href="musicType.action?musicType=爵士">爵士</a></li>
							<li><a href="musicType.action?musicType=抒情">抒情</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 更多<strong class="caret"></strong>
							</a>
								<ul class="dropdown-menu">
									<li><a href="musicType.action?musicType=民间音乐">民间音乐</a></li>
									<li><a href="musicType.action?musicType=民族音乐">民族音乐</a></li>
									<li><a href="musicType.action?musicType=重金属">重金属</a></li>
									<li><a href="musicType.action?musicType=迪斯科">迪斯科</a></li>
								</ul></li>
						</ul>
						<div class="nav navbar-nav navbar-right">
							<form class="navbar-form navbar-left" role="search"
								action="searchAll.action" method="post">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="输入关键字"
										name="key" />
								</div>
								<button type="submit" class="btn btn-default">搜索</button>
							</form>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<!-- 中間層 -->
		<div class="row clearfix" id="home">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-8 column">
						<div class="carousel slide" id="carousel-873866">
							<ol class="carousel-indicators">
								<li class="active" data-slide-to="0"
									data-target="#carousel-873866"></li>
								<li data-slide-to="1" data-target="#carousel-873866"></li>
								<li data-slide-to="2" data-target="#carousel-873866"></li>
								<li data-slide-to="3" data-target="#carousel-873866"></li>
								<li data-slide-to="4" data-target="#carousel-873866"></li>
								<li data-slide-to="5" data-target="#carousel-873866"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img alt="" src="img/milkyway6.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/milkyway7.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/milkyway8.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/milkyway9.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/milkyway1.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/milkyway2.jpg" />
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-873866"
								data-slide="prev"><span
								class="glyphicon glyphicon-chevron-left"></span></a> <a
								class="right carousel-control" href="#carousel-873866"
								data-slide="next"><span
								class="glyphicon glyphicon-chevron-right"></span></a>
						</div>
					</div>
					<div class="col-md-4 column">
						<h2>最新单曲...</h2>
						<div class="list-group">
							<s:iterator value="arrayListLatestMusic" status="rank">
								<a class="list-group-item" href="musicInstruct.action?musicBean.music_id=<s:property value="music_id"/>"> <span class="badge"><s:property
											value="music_singer" /></span> <s:if test="#rank.index==0">
										<img src="img/first.png" />
									</s:if> <s:elseif test="#rank.index==1">
										<img src="img/second.png" />
									</s:elseif> <s:elseif test="#rank.index==2">
										<img src="img/third.png" />
									</s:elseif> <s:else>
										<s:property value="#rank.index+1" />
									</s:else> .<s:property value="music_name" />
								</a>
							</s:iterator>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 歌曲展示 -->
		<div class="row clearfix" style="margin-top: 10px;" id="music_show">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-8 column">
						<div class="row">
							<div class="col-md-12 column">
								<div class="alert alert-success alert-dismissable">
									<h4>新歌速递</h4>
									<a href="#" class="alert-link"
										style="float: right; position: relative; top: -5px;">更多新歌..</a>
								</div>
							</div>
							<s:iterator value="arrayListMusic" status="music">
								<div class="col-md-3">
									<div class="thumbnail">
										<img alt="300x200"
											src="<s:property value="mapMusicPic[music_id]"/>"
											style="width: 300px; height: 150px;" />
										<div class="caption">
											<div class="clearfix">
												<span class="f-l f-14 va-m"></span>
												<div class="star-bar star-bar-show size-S f-l va-m mr-10">
													<s:if test="mapMusicScore[music_id]!=null">
														<span class="star" style="width: <s:property value="mapMusicScore[music_id]*10"/>%"></span>
													</s:if>
													<s:else><span class="star" style="width: 0%"></span></s:else>
												</div>
											</div>
											<h4>
												<a href="musicInstruct.action?musicBean.music_id=<s:property value="music_id"/>"><s:property value="music_name" /></a>
											</h4>
											<p>
												<a href="collectMusic.action?music_id=<s:property value="music_id"/>" class="btn btn-primary">收藏</a> <a
													style="cursor: pointer;"
													name="<s:property value=" music_play"/>"
													onclick="play(this)"">播放</a>
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
							
							<!-- 翻页模块 -->
							<div class="col-md-12 column">
							<form action="music.action" method="get">
								<ul class="pager">
									<s:if test="#attr.page!=null">
										<s:if test="#attr.page<=1">
											<li><a>←</a></li>
										</s:if>
										<s:else>
											<li><a
												href="music.action?page=<s:property value="#attr.page-1"/>">←</a></li>
										</s:else>
									</s:if>
									<li><a href="music.action?page=1">首页</a></li>
									<li>第<input type="text" name="page" value="1" style="width: 30px;"/>页
									</li>
									<li><a
										href="music.action?page=<s:property value="#attr.end"/>">尾页</a></li>
									<s:if test="#attr.page!=null">
										<s:if test="#attr.page>=#attr.end">
											<li><a>→</a></li>
										</s:if>
										<s:else>
											<li><a
												href="music.action?page=<s:property value="#attr.page+1"/>">→</a></li>
										</s:else>
									</s:if>
									<li><a><button>翻到</button></a></li>
								</ul>
							</form>
							</div>
						</div>
					</div>
					<div class="col-md-4 column">
						<h2>精选好歌...</h2>
						<div class="list-group">
							<s:iterator value="arrayListHotMusic" status="rank">
								<a class="list-group-item" href="musicInstruct.action?musicBean.music_id=<s:property value="music_id"/>"> <span class="badge"><s:property
											value="sum" /></span> <s:if test="#rank.index==0">
										<img src="img/first.png" />
									</s:if> <s:elseif test="#rank.index==1">
										<img src="img/second.png" />
									</s:elseif> <s:elseif test="#rank.index==2">
										<img src="img/third.png" />
									</s:elseif> <s:else>
										<s:property value="#rank.index+1" />
									</s:else> .<s:property value="music_name" />
								</a>
							</s:iterator>

						</div>
					</div>
				</div>
			</div>
		</div>
		<audio controls="controls" src="#" id="play" autoplay="autoplay"></audio>
</body>
</html>