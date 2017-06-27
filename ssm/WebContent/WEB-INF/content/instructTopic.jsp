<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/instruction/topic_ins.css">
<link rel="stylesheet" href="css/instruction/common.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		if(<%out.print(request.getAttribute("nice") != null);%>){
			alert("评论成功！");
		}
	});

</script>
</head>
<body>
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
	<div id="main">
		<div class="ins">
			<div class="topicName">
				
				<br>
			</div>
			<div class="playbill">
				<img src="<s:property value="#attr.actyPic" />" style="width: 90%;">
			</div>
			<div class="right">
				<h2><s:property value="actyBean.acty_title" /></h2>
				<div class="initiator">
					<span class="initTime">来自:<a style="text-decoration: none;" href="searchUser.action?userBean.user_id=<s:property value="userBean.user_id"/>"><s:property value="userBean.user_nick" /></a></span>
					<span style="position:relative;left:20px;"><s:property value="actyBean.acty_time" /></span>
				</div>
				<br>
				<div class="topic_content">
					<s:property value="actyBean.acty_content" />
				</div>
			</div>
		</div>
		<div class="discuss">
			<form action="replyTopic.action" method="post">
				<input type="text" style="display: none" name="actyReplyBean.acty_id" value="<s:property value="actyBean.acty_id" />" />
				<p>你的回复</p>
				<hr class="spe" />
				<div class="self">
					<s:if test="#session.head!=null">
                        	<img src='<s:property value="#session.head"/>'>
                        </s:if>
                        <s:else>
                        	<img src='images/bg.jpg'>
                        </s:else>
					<div class="writeArea">
						<textarea rows="5" cols="60" placeholder="你的回复" autoFocus name="actyReplyBean.reply_content" required="required"></textarea>
					</div>
				</div>
				<div class="sub_reply">
					<input type="submit" value="发表" />
				</div>
			</form>
		</div>
		<div class="other" style="margin-bottom: 5px;">
				<h4>别人的评论</h4>
				<hr />
				<s:iterator value="arrayListActyReply" status="reply">
					<div class="each">
					<a href="searchUser.action?userBean.user_id=<s:property value="user_id"/>"><img src='<s:property value="mapUserHead[user_id]"/>' /></a>
					<div class="content">
						<span class="author"><s:property value="user_nick"/>：</span> 
						<s:property value="reply_content"/>
						<div>
							<span class="time" style="float:right;"><s:property value="reply_time"/></span>
						</div>
					</div>
				</div>
				<hr />
				</s:iterator>
			</div>
		
	</div>
</body>
</html>