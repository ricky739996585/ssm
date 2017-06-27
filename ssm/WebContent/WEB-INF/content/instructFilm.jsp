<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/instruction/film_ins.css">
<link rel="stylesheet" href="css/instruction/common.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jquery.raty.js"></script>
<script type="text/javascript">
	$(function() {
		$("#star-1").raty({
			hints : [ '2', '4', '6', '8', '10' ],//自定义分数
			starOff : 'iconpic-star-S-default.png',//默认灰色星星
			starOn : 'iconpic-star-S.png',//黄色星星
			path : 'images/star',//可以是相对路径
			number : 5,//星星数量，要和hints数组对应
			showHalf : true,
			targetKeep : true,
			click : function(score, evt) {//点击事件
				//第一种方式：直接取值
				$('#score').val(score);
				//alert($('#score').val() + ' ' + score);
			}
		});
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
			<div class="filmName"><s:property value="filmBean.film_name"/></div>
			<div class="playbill">
				<img src="<s:property value="#attr.filmPic"/>">
			</div>
			<div class="detail">
				<ul>
				<li><span class="pro">导演:<s:property value="filmBean.film_diretor"/></span></li>
				<li><span class="pro">主演:<s:property value="filmBean.film_actor"/></span></li>
				<li><span class="pro">类型:<s:iterator value="arrayListFilmType"><s:property value="type_name"/>、</s:iterator></span></li>
				<li><span class="pro">上架时间:<s:property value="filmBean.film_time"/></span></li>
				<li><span class="pro">评分:</span>
				<div class="star-bar star-bar-show size-S f-l va-m mr-10">
							<s:if test="mapFilmScore[filmBean.film_id]!=null">
								<span class="star"
									style="width: <s:property value="mapFilmScore[filmBean.film_id]*10"/>%"></span>
							</s:if>
							<s:else>
								<span class="star" style="width: 0%"></span>
							</s:else>
						</div><s:property value="mapFilmScore[filmBean.film_id]"/>分</li>
				</li>
			</ul>
			</div>
			<div class="summary">
				<h3>内容简介：</h3>
				<pre><s:property value="filmBean.film_detail"/></pre>
				<div class="row">
					<s:iterator value="arrayListFilmStills" status="still">
						<img src="<s:property value="film_pic_url"/>"/>
					</s:iterator>
				</div>
				<p>下载地址：<a href="<s:property value="filmBean.film_url"/>"><s:property value="filmBean.film_name"/></a></p>
			</div>
		</div>
		<div class="discuss" id="dis">
			<form action="replyFilm.action" method="post">
				<input type="hidden" style="display: none" name="filmReplyBean.film_id" value="<s:property value="filmBean.film_id"/>"/>
				<input type="hidden"  name="filmReplyBean.film_reply_score" id="score"/>
				<p>评论区</p>
				<hr class="spe" />
				<div class="self">
					<s:if test="#session.head!=null">
                        	<img src='<s:property value="#session.head"/>'>
                        </s:if>
                        <s:else>
                        	<img src='images/bg.jpg'>
                        </s:else>
					<div class="writeArea">
						<textarea rows="5" cols="60" placeholder="评论" autoFocus name="filmReplyBean.film_reply_content" required="required"></textarea>
					</div>
				</div>
				<div class="score">
					<div class="xingxing">
						评分：
						<div id="star-1" class="star-bar size-S f-l mr-10 va-m"></div>
					</div>
					<input type="submit" value="发表" id="sub_comment" />
				</div>
			</form>
			<div class="other">
				<h4>别人的评论</h4>
				<hr />
				<s:iterator value="arrayListFilmReply" status="reply">
					<div class="each">
					<a href="searchUser.action?userBean.user_id=<s:property value="user_id"/>"><img src='<s:property value="mapUserHead[user_id]"/>' /></a>
					<div class="content">
						<span class="author"><s:property value="user_nick"/>：</span> 
						<s:property value="film_reply_content"/>
						<div>
							<span class="time" style="float:right;"><s:property value="film_reply_time"/></span>
						</div>
					</div>
				</div>
				<hr />
				</s:iterator>
			</div>
		</div>
	</div>
</body>
</html>