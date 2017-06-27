<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>ZHKU娱乐网|话题</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/selectStyle.css">

<link href="css/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="css/postStyle.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/topic_show.js"></script>
<script type="text/javascript">
	$(function() {
		if (<%out.print(session.getAttribute("user") != null);%>) {
			$("#user").html("<i class='Hui-iconfont'>&#xe62c;</i>用户");
		}
		if (<%out.print(request.getAttribute("msg") != null);%>) {
			alert("发表成功！等待审核！");
		}
	});
</script>
<style type="text/css">
.dif_mod {
	margin: 15px 0px 15px 0px;
	background: url(img/hr.jpg);
	height: 100px;
	background-size: 100% 100px;
}
</style>
</head>
<body>
	<div class="container" style="padding: 30px;">
		<!-- 導航欄 -->
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
					<li><a href="index.action"><i class="Hui-iconfont">&#xe625;</i>首页</a></li>
					<li><a href="music.action"><i class="Hui-iconfont">&#xe60f;</i>音乐</a></li>
					<li><a href="film.action"><i class="Hui-iconfont">&#xe64b;</i>电影</a></li>
					<li><a href="book.action"><i class="Hui-iconfont">&#xe720;</i>读书</a></li>
					<li   class="active"><a href="topic.action"><i class="Hui-iconfont">&#xe622;</i>话题</a></li>
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
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="topic.action">分类</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" id="classfiy">
						<li><a href="topicType.action?actyType=文化">文化</a></li>
						<li><a href="topicType.action?actyType=娱乐">娱乐</a></li>
						<li><a href="topicType.action?actyType=时尚">时尚</a></li>
						<li><a href="topicType.action?actyType=生活">生活</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> 更多<strong class="caret"></strong>
						</a>
							<ul class="dropdown-menu">
								<li><a href="topicType.action?actyType=科技">科技</a></li>
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
						 <div class="div1">
                        <div class="span1" style="background-color: white;">
                        <s:if test="#session.head!=null">
                        	<img src='<s:property value="#session.head"/>' style="width: 60px;height: 60px;">
                        </s:if>
                        <s:else>
                        	<img src='images/bg.jpg' style="width: 60px;height: 60px;">
                        </s:else>
                        </div>
                        <form action="insertTopic.action" method="post" enctype="multipart/form-data">
                        <div class="span2">
                            活动标题:<input type="text" class="input-text radius size-S" style="width: 200px;" name="actyBean.acty_title">
                            <span style="display: inline-block;width: 163px;"></span>类型：
                            <span class="select-box radius size-m" style="width: 100px;">
                                <select class="select" size="1" name="actyBean.acty_type">
                                    <option value="文化" selected>文化</option>
                                    <option value="娱乐">娱乐</option>
                                    <option value="时尚">时尚</option>
                                    <option value="生活">生活</option>
                                    <option value="科技">科技</option>
                                </select>
                            </span>
                            <div class="span3" style="background-color: white;">
                                <div class="span4"><textarea class="form-control" placeholder="说点什么..."
                                                             style="width: 590px;height: 100px;" name="actyBean.acty_content"></textarea>
                                </div>
                            </div>
                            <div style="margin-top: 10px;">
                                <span class="span5">
                                    <span class="btn-upload"><a href="#" class="btn btn-primary radius">
                                        <i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
                                        <input type="file" multiple name="actyImg" class="input-file">
                                    </span>
                                    <span style="display: inline-block;width: 406px;"></span>
                                    <span class="btn-upload"><a href="#" class="btn btn-primary radius">
                                        <i class="Hui-iconfont">&#xe603;</i> 发表</a>
                                        <input type="submit" name="file_0" class="input-file">
                                    </span>
                                </span>
                            </div>
                        </div>
                        </form>
                    </div>
                    <br>
                    <hr>
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
									<span class="span5">来自:<a href="searchUser.action?userBean.user_id=<s:property value="user_id"/>"><s:property value="user_nick"/></a></span> <span class="span5"><s:property value="acty_time"/></span>
								</div>
							</div>
						</div>
						<hr>
						</s:iterator>
						<div class="col-md-12 column">
						<form action="topic.action" method="get">
							<ul class="pager">
								<s:if test="#attr.page!=null">
									<s:if test="#attr.page<=1">
										<li><a>←</a></li>
									</s:if>
									<s:else>
										<li><a
											href="topic.action?page=<s:property value="#attr.page-1"/>">←</a></li>
									</s:else>
								</s:if>
								<li><a href="topic.action?page=1">首页</a></li>
								<li>第<input type="text" name="page" value="1"
									style="width: 30px;" />页
								</li>
								<li><a
									href="topic.action?page=<s:property value="#attr.end"/>">尾页</a></li>
								<s:if test="#attr.page!=null">
									<s:if test="#attr.page>=#attr.end">
										<li><a>→</a></li>
									</s:if>
									<s:else>
										<li><a
											href="topic.action?page=<s:property value="#attr.page+1"/>">→</a></li>
									</s:else>
								</s:if>
								<li><a><button>翻到</button></a></li>
							</ul>
						</form>
						</div>
					</div>
					<div class="col-md-4 column">
						<h2>大伙参加</h2>
						<div class="list-group">
							<s:iterator value="arrayListHotActy" status="rank">
								<a class="list-group-item" href="topicInstruct.action?actyBean.acty_id=<s:property value="acty_id"/>"> <span class="badge"><s:property value="acty_people"/></span> <s:if test="#rank.index==0">
										<img src="img/first.png" />
									</s:if> <s:elseif test="#rank.index==1">
										<img src="img/second.png" />
									</s:elseif> <s:elseif test="#rank.index==2">
										<img src="img/third.png" />
									</s:elseif> <s:else>
										<s:property value="#rank.index+1" />
									</s:else> .<s:property value="acty_title" />
								</a>
							</s:iterator>
						</div>
						<hr>
						<h2>最新发布</h2>
						<div class="list-group">
							<s:iterator value="arrayListLatestActy" status="rank">
								<a class="list-group-item" href="topicInstruct.action?actyBean.acty_id=<s:property value="acty_id"/>"> <span class="badge"></span> <s:if test="#rank.index==0">
										<img src="img/first.png" />
									</s:if> <s:elseif test="#rank.index==1">
										<img src="img/second.png" />
									</s:elseif> <s:elseif test="#rank.index==2">
										<img src="img/third.png" />
									</s:elseif> <s:else>
										<s:property value="#rank.index+1" />
									</s:else> .<s:property value="acty_title" />
								</a>
							</s:iterator>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>