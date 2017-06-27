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
<link rel="stylesheet" href="css/postStyle.css">
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
		if (
<%out.print(session.getAttribute("user") != null);%>
	) {
			$("#user").html("${sessionScope.user.user_name}");
		}
	});
</script>
</head>
<body>
	<div class="container" style="padding: 30px;">
		<!-- 導航欄 -->
		<div class="row clearfix">
			<div class="col-md-6 column">
				<div class="row clearfix">
					<div class="col-md-6 column">
						<img src="img/logo2.jpg"
							style="width: 250px; height: 100px; position: relative; top: -25px;">
					</div>
				</div>
			</div>
			<div class="col-md-6 column">
				<ul class="nav nav-pills">
					<li><a href="index.action">首页</a></li>
					<li><a href="music.action">音乐</a></li>
					<li><a href="film.action">电影</a></li>
					<li><a href="book.action">读书</a></li>
					<li><a href="topic.action">话题</a></li>
					<li><a href="#">联系我们</a></li>
					<s:if test="#session.user!=null">
						<li><a href="instructUser.action" id="user">用户</a></li>
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
						<a class="navbar-brand" href="music.action"></a>
					</div>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav" id="classfiy">
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

		<!-- 歌曲展示 -->
		<div class="row clearfix" style="margin-top: 10px;" id="music_show">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-8 column">
						<div class="row">
							<div class="col-md-12 column">
								<div class="alert alert-success alert-dismissable">
									<h4>搜索结果：</h4>
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
												<a href="#" class="btn btn-primary">收藏</a> <a
													style="cursor: pointer;"
													name="<s:property value=" music_play"/>"
													onclick="play(this)"">播放</a>
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
							<s:iterator value="arrayListFilm" status="film">
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
														<span class="star"
															style="width: <s:property value="mapFilmScore[film_id]*10"/>%"></span>
													</s:if>
													<s:else>
														<span class="star" style="width: 0%"></span>
													</s:else>
												</div>
											</div>
											<h4>
												<a
													href="filmInstruct.action?filmBean.film_id=<s:property value="film_id" />"><s:property
														value="film_name" /></a>
											</h4>
											<p>
												<a class="btn btn-primary"
													href="<s:property value="film_url"/>">下载</a>
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
							<s:iterator value="arrayListBook" status="book">
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
												<a
													href="bookInstruct.action?bookBean.book_id=<s:property value="book_id"/>"><s:property
														value="book_name" /></a>
											</h4>
											<p>
												<a class="btn btn-primary" href="#">阅览</a>
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
							<div class="col-md-8 column">
							<s:iterator value="arrayListMapActy" status="acty">
							<div class="div1">
							<div class="span1">
								<s:property value="acty_people"/><br>喜欢
							</div>
							<div class="span2">
								<a href="topicInstruct.action?actyBean.acty_id=<s:property value="acty_id"/>"><s:property value="acty_title"/></a>
								<div class="span3">
									<img src='<s:property value="mapActyPic[acty_id]"/>'>
									<div class="span4"><s:property value="acty_content"/></div>
								</div>
								<div>
									<span class="span5">来自:<s:property value="user_nick"/></span> <span class="span5"><s:property value="acty_time"/></span>
								</div>
							</div>
						</div>
						<hr>
						</s:iterator>
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
							<h2>精选电影...</h2>
						<div class="list-group">
							<s:iterator value="arrayListHotFilm" status="rank">
								<a class="list-group-item" href="filmInstruct.action?filmBean.film_id=<s:property value="film_id" />"> <span class="badge"><s:property
											value="sum" /></span> <s:if test="#rank.index==0">
										<img src="img/first.png" />
									</s:if> <s:elseif test="#rank.index==1">
										<img src="img/second.png" />
									</s:elseif> <s:elseif test="#rank.index==2">
										<img src="img/third.png" />
									</s:elseif> <s:else>
										<s:property value="#rank.index+1" />
									</s:else> .<s:property value="film_name" />
								</a>
							</s:iterator>
						</div>
						<h2>精品好书...</h2>
						<div class="list-group">
							<s:iterator value="arrayListHotBook" status="rank">
								<a class="list-group-item" href="bookInstruct.action?bookBean.book_id=<s:property value="book_id"/>"> <span class="badge"><s:property
											value="sum" /></span> <s:if test="#rank.index==0">
										<img src="img/first.png" />
									</s:if> <s:elseif test="#rank.index==1">
										<img src="img/second.png" />
									</s:elseif> <s:elseif test="#rank.index==2">
										<img src="img/third.png" />
									</s:elseif> <s:else>
										<s:property value="#rank.index+1" />
									</s:else> .<s:property value="book_name" />
								</a>
							</s:iterator>

						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<audio controls="controls" src="#" id="play" autoplay="autoplay"></audio>
</body>
</html>