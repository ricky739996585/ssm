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
	position: relative;
	left: 250px;
}
</style>
<script type="text/javascript">
	function check() {
		var a = document.getElementById("checkPsw");
		var b = document.getElementById("psw");
		if (a.value != b.value) {
			alert("密码不正确！");
		}
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
	</div>
	<div id="main" style="background: white">
		<div class="row clearfix" style="margin: 10px;">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<br> <img src="<s:property value="#attr.headPic"/>" class="img-circle" style="width: 200px; height: 200px;">
					</div>
					<div class="col-md-8 column">
						<h4>
							<strong><s:property value="userBean.user_nick"/></strong>
						</h4>
						<hr style="position: relative; right: 0; width: 400px;">
						<form role="form" method="post" action="modifyUser.action" enctype="multipart/form-data">
							<div class="form-group">
								<label>用户名：<s:property value="userBean.user_name"/></label>
							</div>
							<div class="form-group">
								<label>用户昵称：</label><input type="text" class="form-control"
									name="userBean.user_nick" value="<s:property value="userBean.user_nick"/>"/>
							</div>
							<div class="form-group">
								<label>性别：</label> <select name="userBean.user_sex">
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</div>
							<div class="form-group">
								<label>密码：</label><input type="password" class="form-control"
									id="psw" name="userBean.user_psw" />
							</div>
							<div class="form-group">
								<label>确认密码：</label><input type="password" class="form-control"
									id="checkPsw" onblur="check();" />
							</div>
							<div class="form-group">
								<input type="file" name="head" value="选择头像"/>
							</div>
							<input type="submit" class="btn btn-default"></input>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>
	</div>
</body>
</html>