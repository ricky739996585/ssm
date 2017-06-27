<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/instruction/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/selectStyle.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
.div1 {
	width: 100%;
	border: 1px solid red;
	padding: 10px;
}

.div1 li {
	float: left;
}

.div2 {
	display: inline-block;
	width: 30%;
	height: 200px;
}

.div3 {
	display: inline-block;
	width: 50%;
	height: 200px;
	border: 1px solid black;
}

.span1 {
	position: absolute;
	right: 0px;
}
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
</script>
</head>
<body>
<body style="background: #f5f5f5;">
	<div class="title">
		<ul>
			<li><a href="index.action">首页</a></li>
			<li><a href="music.action">音乐</a></li>
			<li><a href="film.action">电影</a></li>
			<li><a href="book.action">读书</a></li>
			<li><a href="topic.action">话题</a></li>
		</ul>
		<span class="login"><a href="">登录</a></span>
	</div>
	<div id="main" style="background: white">
		<div class="row clearfix" style="margin: 10px;">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<br> <img src="<s:property value="#attr.headPic"/>"
							style="width: 200px; height: 200px;" class="img-circle">
					</div>
					<div class="col-md-8 column">
						<h4>
							<strong><s:property value="userBean.user_nick" /></strong>
							<span style="display:inline-block;width:5px;"></span>
							<s:if test='#session.user.user_sex=="男"'>
								<img src="img/boy.png" style="width: 20px;height: 20px;">
							</s:if>
							<s:else>
								<img src="img/girl.png" style="width: 20px;height: 20px;">
							</s:else>
							<span class="span1"><a href="userForUpdate.action"><button class="btn btn-default">编辑资料</button></a></span>
						</h4>
						<hr style="position: relative; right: 0; width: 400px;">
						<h6>
							用户名：
							<s:property value="userBean.user_name" />
						</h6>
						<h6>
							用户状态：
							<s:property value="userBean.user_status" />
						</h6>
						<h6>
							创建时间：
							<s:property value="userBean.user_time" />
						</h6>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#music" data-toggle="tab">
							音乐收藏</a></li>
					<li><a href="#film" data-toggle="tab">电影收藏</a></li>
					<li><a href="#book" data-toggle="tab">图书收藏</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="music">
						<s:iterator value="mapCollectMusic" status="music">
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
													<span class="star"
														style="width: <s:property value="mapMusicScore[music_id]*10"/>%"></span>
												</s:if>
												<s:else>
													<span class="star" style="width: 0%"></span>
												</s:else>
											</div>
										</div>
										<h4>
											<a
												href="musicInstruct.action?musicBean.music_id=<s:property value="music_id"/>"><s:property
													value="music_name" /></a>
										</h4>
										<p>
											<a	class="btn btn-primary"
												style="cursor: pointer;"
												name="<s:property value=" music_play"/>"
												onclick="play(this)">播放</a>
										</p>
									</div>
								</div>
							</div>
						</s:iterator>
					</div>
					<div class="tab-pane fade" id="film">
						<s:iterator value="mapCollectFilm" status="film">
								<div class="col-md-3">
									<div class="thumbnail">
										<img alt="300x200"
											src="<s:property value="mapFilmPic[film_id]" />"
											style="width: 300px; height: 150px;" />
										<div class="caption">
										<div class="clearfix">
												<span class="f-l f-14 va-m"></span>
												<div class="star-bar star-bar-show size-S f-l va-m mr-10">
													<s:if test="mapFilmScore[film_id]!=null">
														<span class="star" style="width: <s:property value="mapFilmScore[film_id]*10"/>%"></span>
													</s:if>
													<s:else><span class="star" style="width: 0%"></span></s:else>
												</div>
											</div>
											<h4>
												<a href="filmInstruct.action?filmBean.film_id=<s:property value="film_id" />"><s:property value="film_name" /></a>
											</h4>
											<p>
												<a class="btn btn-primary" href="<s:property value="film_url"/>">下载</a>
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
					</div>
					<div class="tab-pane fade" id="book">
						<s:iterator value="mapCollectBook" status="book">
								<div class="col-md-3">
									<div class="thumbnail">
										<img alt="300x200"
											src="<s:property value="mapBookPic[book_id]"/>"
											style="width: 300px; height: 150px;" />
										<div class="caption">
											<div class="clearfix">
												<span class="f-l f-14 va-m"></span>
												<div class="star-bar star-bar-show size-S f-l va-m mr-10">
													<s:if test="mapBookScore[book_id]!=null">
														<span class="star"
															style="width: <s:property value="mapBookScore[book_id]*10"/>%"></span>
													</s:if>
													<s:else>
														<span class="star" style="width: 0%"></span>
													</s:else>
												</div>
											</div>
											<h4>
												<a href="bookInstruct.action?bookBean.book_id=<s:property value="book_id"/>"><s:property value="book_name" /></a>
											</h4>
											<p>
												<a class="btn btn-primary" href="#">阅览</a>
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
					</div>
				</div>
			</div>
		</div>
	</div>
	<audio controls="controls" src="#" id="play" autoplay="autoplay"></audio>
	<script>
		$(function() {
			$('#myTab li:eq(1) a').tab('show');
		});
	</script>
</body>


</html>