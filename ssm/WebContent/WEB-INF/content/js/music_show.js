function musicType(type){
	if (type!=null){
		$.ajax({
			url:"musicType.action",
			type:"post",
			data:{"param":type},
			success:function(res){
				$('#music_show').css('display','none');
				$('#home').html(res);
			},
			error:function(){alert('error');}
		});
	}
}