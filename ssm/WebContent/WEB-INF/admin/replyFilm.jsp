<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dashboard.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	function hide(obj) {
		var ou = obj.getElementsByTagName("ul");
		if (ou[0].style.display == "none") {
			ou[0].style.display = "block";
		} else {
			ou[0].style.display = "none";
		}
	}

	function about() {
		alert("我们是蒲公英校园娱乐网的工作人员，感谢您的使用！");
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">蒲公英管理页面</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="admin.jsp">首页</a></li>
					<li><a href="#">修改密码</a></li>
					<li><a href="#">退出登录</a></li>
					<li><a onclick="about()">关于</a></li>
				</ul>
				<form class="navbar-form navbar-right"
					action="findFilmByName.action" method="post">
					<input type="text" class="form-control" placeholder="搜索电影..."
						name="film_name"> <input type="submit"
						class="form-control" value="查询">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" id="ul1">
					<li class="active"><a href="admin.jsp">主页 <span
							class="sr-only">(current)</span></a></li>
					<li onclick="hide(this)"><a href="#">音乐管理</a>
						<ul style="display: none">
							<li><a href="getAllMusic.action">音乐编辑</a></li>
							<li><a href="insertMusic.jsp">新增音乐</a></li>
							<li><a href="getCollectMusic.action">音乐收藏</a></li>
							<li><a href="getReplyMusic.action">音乐评论</a></li>
						</ul></li>
					<li onclick="hide(this)"><a href="#">电影管理</a>
						<ul style="display: none">
							<li><a href="getAllFilm.action">电影编辑</a></li>
							<li><a href="insertFilm.jsp">新增电影</a></li>
							<li><a href="getCollectFilm.action">电影收藏</a></li>
							<li><a href="getReplyFilm.action">电影评论</a></li>
							<li><a href="getAllFilmForPic.action">添加电影剧照</a></li>
						</ul></li>
					<li onclick="hide(this)"><a href="#">读书管理</a>
						<ul style="display: none">
							<li><a href="getAllBook.action">图书编辑</a></li>
							<li><a href="insertBook.jsp">新增图书</a></li>
							<li><a href="getCollectBook.action">图书收藏</a></li>
							<li><a href="getReplyBook.action">图书评论</a></li>
						</ul></li>
					<li onclick="hide(this)"><a href="#">活动管理</a>
						<ul style="display: none">
							<li><a href="getAllActy.action">活动编辑</a></li>
							<li><a href="getUserActy.action">新增活动</a></li>
							<li><a href="getStatus.action">审核活动</a></li>
							<li><a href="getReply.action">活动评论</a></li>

						</ul></li>
					<li onclick="hide(this)"><a href="#">用户管理</a>
						<ul style="display: none">
							<li><a href="getAllUser.action">显示用户</a>
							<li><a href="insertUser.jsp">新增用户</a>
						</ul></li>
				</ul>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<h2 class="page-header">管理页面</h2>
				<div class="table-responsive" id="table">
					<table class="table">
						<thead>
							<tr>
								<th>序号</th>
								<th>用户名</th>
								<th>电影名</th>
								<th>评论</th>
								<th>评分</th>
								<th>评论时间</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="mapReplyFilm" status="reply">
								<tr class="success">
									<td><s:property value="film_reply_id" /></td>
									<td><s:property value="user_name" /></td>
									<td><s:property value="film_name" /></td>
									<td><s:property value="film_reply_content" /></td>
									<td><s:property value="film_reply_score" /></td>
									<td><s:property value="film_reply_time" /></td>
								</tr>
							</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>