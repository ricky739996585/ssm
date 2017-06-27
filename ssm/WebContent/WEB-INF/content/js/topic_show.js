function topicType(type){
	if (type!=null){
		$.ajax({
			url:"topicType.jsp",
			type:"post",
			data:{"param":type},
			success:function(res){
				$('#home').html(res);
			},
			error:function(){alert('error');}
		});
	}
}