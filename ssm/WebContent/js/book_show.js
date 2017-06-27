function bookType(type){
	if (type!=null){
		$.ajax({
			url:"bookType.jsp",
			type:"post",
			data:{"param":type},
			success:function(res){
				$('#home').html(res);
			},
			error:function(){alert('error');}
		});
	}
}