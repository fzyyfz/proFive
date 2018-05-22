$(function(){
	
	var address = new Object();
	$.get("AddAddServlet",function(data){
		
		if(data.length>0){
			for(var i=0;i<data.length;i++){
				if(data[i].state == "默认"){
					$("#addUl").append(
							'<li class="user-addresslist defaultAddr">'+
							'<span class="new-option-r" onclick="defaultClick(this);"><i class="am-icon-check-circle"></i>默认地址</span>'+
							'<p class="new-tit new-p-re">'+
								'<span class="new-txt">'+data[i].ra_Person+'</span>'+
								'<span class="new-txt-rd2">'+data[i].ra_Phone+'</span>'+
							'</p>'+
							'<div class="new-mu_l2a new-p-re">'+
								'<p class="new-mu_l2cw">'+
									'<span class="title">地址：</span>'+
									'<span class="province">'+data[i].ra_Country+'</span>'+
									'<span class="city">'+data[i].ra_Province+'</span>省'+
									'<span class="dist">'+data[i].ra_City+'</span>市'+
									'<span class="street">'+data[i].ra_Detail+'</span></p>'+
							'</div>'+
							'<div class="new-addr-btn">'+
								'<a href="javascript:void(0);" onclick="editClick(this);"><i class="am-icon-edit"></i>编辑</a>'+
								'<span class="new-addr-bar">|</span>'+
								'<a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>'+
								'<span hidden id="hidden">'+data[i].ra_Id+'</span>'+
							'</div>'+
						'</li>'
					);
					continue;
				}
				$("#addUl").append(
						'<li class="user-addresslist">'+
						'<span class="new-option-r" onclick="defaultClick(this);"><i class="am-icon-check-circle"></i>设为默认</span>'+
						'<p class="new-tit new-p-re">'+
							'<span class="new-txt">'+data[i].ra_Person+'</span>'+
							'<span class="new-txt-rd2">'+data[i].ra_Phone+'</span>'+
						'</p>'+
						'<div class="new-mu_l2a new-p-re">'+
							'<p class="new-mu_l2cw">'+
								'<span class="title">地址：</span>'+
								'<span class="province">'+data[i].ra_Country+'</span>'+
								'<span class="city">'+data[i].ra_Province+'</span>省'+
								'<span class="dist">'+data[i].ra_City+'</span>市'+
								'<span class="street">'+data[i].ra_Detail+'</span></p>'+
						'</div>'+
						'<div class="new-addr-btn">'+
							'<a href="javascript:void(0);" onclick="editClick(this);"><i class="am-icon-edit"></i>编辑</a>'+
							'<span class="new-addr-bar">|</span>'+
							'<a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>'+
							'<span hidden id="hidden">'+data[i].ra_Id+'</span>'+
						'</div>'+
					'</li>'
				);
			}
		}
	},"json");
	
//	$("#addBut").on("click",function(){
//		
//		$("#addForm").submit();
//	});
	$(".new-option-r").live("click",function(){
//	    $(".new-option-r").parent().class == 'user-addresslist defaultAddr';
//		alert("a");
//		$(".new-option-r").parent().class == 'user-addresslist defaultAddr';
		$(this).parent().attr("class","user-addresslist defaultAddr");
		$(this).html("默认地址");
		$(this).parent().siblings().attr("class","user-addresslist");
		$(this).parent().siblings().children('.new-option-r').html("设为默认");
	 });
	
})

function submitForm(){
	
//		$.post("AddAddServlet",function(data){
//			if(data>0){
//				alert("添加成功！");
//			}else{
//				alert("添加失败！");
//			}
//		});
		
	$.ajax({
        //几个参数需要注意一下
            type: "POST",//方法类型
            url: "AddAddServlet" ,//url
            data: $('#addForm').serialize(),
            success: function (data) {
            	if(data>0){
    				alert("添加成功！");
    				window.location.reload();
    			}else{
    				alert("添加失败！");
    			}
            }
        });
}

function editForm(){
	
		$.ajax({
        //几个参数需要注意一下
            type: "POST",//方法类型
            url: "EditAddressServlet" ,//url
            data: $('#editForm').serialize(),
            success: function (data) {
            	if(data==1){
    				alert("修改成功！");
    			}else{
    				alert("修改失败！");
    			}
                window.location.reload();
            }
        });
}

function delClick(a){
	
	var id = $(a).next().text();
	if (confirm("确定要删除吗？")) {
		$.get("DelAddressServlet",{"id":id},function(data){
			if(data == 1){
				alert("删除成功！");
				window.location.reload();
			}else if(data == 2){
				alert("删除失败！");
			}
		});
	}
}

function editClick(a){
	var id = $(a).next().next().next().text();
	$.get("EditAddressServlet",{"id":id},function(data){
		if(data.length>0){
			$("#addDiv").css('display','none');
			$("#editDiv").css('display','block');
			$("#euser_name").attr('value',data[0].ra_Person);
			$("#euser_phone").attr('value',data[0].ra_Phone);
			$("#edetail").attr('value',data[0].ra_Detail);
			$("#ecountry").val(data[0].ra_Country).attr('selected',true);
			$("#eprovince").val(data[0].ra_Province).attr('selected',true);
			$("#ecity").val(data[0].ra_City).attr('selected',true);
		}
	},"json");
}

function defaultClick(a){
	
	var id = $(a).next().next().next().children(":last-child").text();
	$.get("DefaultServlet",{"id":id},function(data){
		if(data == 1){
		}else{
			alert("设置失败！");
		}
	});
}

function cancelEdit(){
	$("#addDiv").css('display','block');
	$("#editDiv").css('display','none');
}
