$(function(){
	
	$("#inSubmit").on("click",function(){
		
		$("#inforForm").submit();
	});
	
	var addInfo = new Object();
	
	addInfo.loadMas = function(){
		$.get("AddInformationServlet",function(data){
			if(data[0].uhead!=null){
				
				$("#infoHead")[0].src = data[0].uhead;
			}
			
			if(data[0].usex == "男"){
				
				$(":radio[name='radio10'][value='male']").attr("checked", "checked");
			}else if(data[0].usex == "女"){
				
				$(":radio[name='radio10'][value='female']").attr("checked", "checked");
			}else if(data[0].usex == "保密"){
				
				$(":radio[name='radio10'][value='secret']").attr("checked", "checked");
			}
			
			$("#user-name2").attr('value',data[0].uname);
			$("#user-phone").attr('value',data[0].uphone);
			$("#user-email").attr('value',data[0].uemail);
			
//			alert(data[0].usex);
//			alert($(":tel").placeholder);
			
		},"json");
	}
	addInfo.loadMas();
	
//	var img = $("#fileInp").file();
//	alert("a");
	
//	$("#getImg").on("click",function(){
//		var a = $("#fileInp").files;
//		alert(a[0].name);
//	});
//	
})

