<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/instruction/music_ins.css">
<link rel="stylesheet" href="css/instruction/common.css">
<link rel="stylesheet" href="css/style.css">
<link href="css/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jquery.raty.js"></script>
<script type="text/javascript">
	$(function() {

		$('div1').click(function(){
			$('audio').css('display', 'block');
		});
		$('audio').mouseout(function() {
			setTimeout(function() {
				$('audio').css('display', 'none');
			}, 2000);
		});
		$('#play').click(function() {
			$('audio').css('display', 'block');
			$('audio').mouseout();
		});
		$("#star-1").css('width', '200px');
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
				
			}
		});
	});
	function play(obj) {
		var url = obj.name;
		var audio = document.getElementById("play");
		audio.src = url;
	}
</script>
<style>
.star-bar-show {
	background: url(images/star/iconpic-star-S-default.png) repeat-x 0 0;
	display: inline-block;
}

.star-bar-show .star {
	background: url(images/star/iconpic-star-S.png) repeat-x 0 0
}
</style>
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
			<div class="musicName">&nbsp;</div>
			<div class="playbill">
				<img src="<s:property value="#attr.musicPic"/>">
			</div>
			<div class="right">
				<ul>
					<li><span class="pro">歌名:<s:property
								value="musicBean.music_name" /></span></li>
					<li><span class="pro">歌手:<s:property
								value="musicBean.music_singer" /></span></li>
					<li><span class="pro">类型:<s:property
								value="musicBean.music_type" /></span></li>
					<li><span class="pro">评分:</span>
						<div class="star-bar star-bar-show size-S f-l va-m mr-10">
							<s:if test="mapMusicScore[musicBean.music_id]!=null">
								<span class="star"
									style="width: <s:property value="mapMusicScore[musicBean.music_id]*10"/>%"></span>
							</s:if>
							<s:else>
								<span class="star" style="width: 0%"></span>
							</s:else>
						</div><s:property value="mapMusicScore[musicBean.music_id]"/>分</li>
				</ul>
				<ul class="center">
					<li><button type="button" class="btn btn-info btn-default" onclick="play(this)" name="<s:property value="musicBean.music_play"/>"><i class="Hui-iconfont" style="font-size: 15px;">&#xe6e6;</i>播放</button>
					</li>
					<li><a href="collectMusic.action?music_id=<s:property value="musicBean.music_id"/>">
					<button type="button" class="btn btn-default btn-success">
					<i class="Hui-iconfont" style="font-size: 15px;">&#xe630;</i>收藏</button>
					</a></li>
					<li><a href="#dis">
					<button type="button" class="btn btn-default btn-danger">
					<i class="Hui-iconfont" style="font-size: 15px;">&#xe622;</i>评论</button>
					</a></li>
				</ul>
				<div class="bottom"><h3>歌词:</h3><pre><s:property value="musicBean.music_lyric"/></pre></div>
			</div>
		</div>
		<div class="discuss" id="dis">
			<form action="replyMusic.action" method="post">
				<input type="hidden" style="display: none" name="musicReplyBean.music_id" value="<s:property value="musicBean.music_id"/>"/>
				<input type="hidden"  name="musicReplyBean.music_reply_score" id="score"/>
				<p>评论区</p>
				<hr class="spe" />
				<div class="self">
					<s:if test="#session.head!=null">
                        	<img src='<s:property value="#session.head"/>' style="vertical-align: baseline;">
                        </s:if>
                        <s:else>
                        	<img src='images/bg.jpg' style=" vertical-align: baseline;">
                        </s:else>
					<div class="writeArea">
						<textarea rows="5" cols="60" placeholder="评论" autoFocus name="musicReplyBean.music_reply_content" required="required"></textarea>
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
			<div class="other" style="margin-bottom: 5px;">
				<h4>别人的评论</h4>
				<hr />
				<s:iterator value="arrayListMusicReply" status="reply">
					<div class="each">
					<a href="searchUser.action?userBean.user_id=<s:property value="user_id"/>"><img src='<s:property value="mapUserHead[user_id]"/>' /></a>
					<div class="content">
						<span class="author"><s:property value="user_nick"/>：</span> 
						<s:property value="music_reply_content"/>
						<div>
							<span class="time" style="float:right;"><s:property value="music_reply_time"/></span>
						</div>
					</div>
				</div>
				<hr />
				</s:iterator>
			</div>
		</div>
	</div>
	<div style="height:1px;border:1px solid grey;bottom: 0px;" id="div1"><audio controls="controls" src="#" id="play" autoplay="autoplay"></audio></div>
		
</body>
</html>