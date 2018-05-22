$(function() {
	
	var register = new Object();
	register.loadValidateCode = function(){
		$.ajax({
			type:"get",
			url:"ValidateCodeServlet",
			success: function(result){
				var jsonResult = JSON.parse(result);
				if(jsonResult.status == 200){
					var data = jsonResult.data;
					$("#codeImg")[0].src = data;
				}
			},
			error: function(){
			}
		});
	}
	
	//提交
//	register.submit = function(formData){
//		
//		$.ajax({
//			type:"post",
//			url:"UserServlet",
//			data:formData,
//			success: function(result){
//				var jsonResult = JSON.parse(result);
//				if(jsonResult.status == 200){
//					console.info(jsonResult.message);
//				}
//			},
//			error: function(){
//				
//			}
//		});
//	}
	
	//验证邮箱
	register.emailExist = function(){
		
		var email = $("#email").val();
		$.ajax({
			type: "get",
			url: "UserServlet",
			data: {"email":email},
			success: function(data){
				if(data ==1){
					alert("邮箱已存在！");
					$("#subBut").attr("disabled",true);
				}else if(data == 2){
					alert("邮箱可用！");
					$("#subBut").attr("disabled",false);
				}
			}
		});
	}
	
	register.isPoneAvailable = function(phone){
		
		var regexp = new RegExp("^1[3|4|5|7|8][0-9]{9}$"); 
		return regexp.test(phone);
	}
	
	//验证手机
	register.emailPhone = function(){
		
		var phone = $("#phone").val();
		$.ajax({
			type: "get",
			url: "UserServlet",
			data: {"phone":phone},
			success: function(data){
				if(data ==1){
					alert("手机已存在！");
					$("#phoneBut").attr("disabled",true);
				}else if(data == 2){
					if(register.isPoneAvailable($("#phone").val())){
						alert("手机可用！");
						$("#phoneBut").attr("disabled",false);
					}else{
						alert("请输入正确的手机格式！");
						$("#phoneBut").attr("disabled",true);
					}
				}
			}
		});
	}
	
//	$("[type='submit']").bind({click:function(){
//		if(this.id='mailForm'){// 邮箱注册
//			var form = $(document.forms[0]).serialize();
//			register.submit(form);
//		}
//	}});
	
	$("#phoneBut").on("click",function(){
		$("#phoneregist").submit();
	})
	
	$("#subBut").on("click",function(){
		$("#mailForm").submit();
	})
	
	//页面加载获取验证码
	register.loadValidateCode();
	
	//点击验证码自动获取验证码
	$("#codeImg").on("click",function(){
		
		register.loadValidateCode();
	});
	
	//验证邮箱是否存在
	$("#email").blur(function(){
		register.emailExist();
	})
	
	//验证手机是否存在
	$("#phone").blur(function(){
		register.emailPhone();
	})
})

