package com.yy.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.service.user.UserService;
import com.yy.mail.utils.StringUtil;

@WebServlet("/home/PhoneRegister")
public class PhoneRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone = request.getParameter("phone");
		String ppass = request.getParameter("ppass");
		String conppass = request.getParameter("conppass");
		
		//验证为空
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(phone) || StringUtil.isEmpty(ppass) || StringUtil.isEmpty(conppass)){
			responseBody.setStatus(-1);
			responseBody.setMessage("注册参数不能为空!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//两次输入密码是否一致
		if(!(ppass.equals(conppass))){
			responseBody.setStatus(-1);
			responseBody.setMessage("密码不一致，请确认密码");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//验证账号唯一性
		UserService userService = new UserService();
		boolean exists = false;
		if(StringUtil.isNotEmpty(phone)){
			exists = userService.phoneExists(phone);
		}
		
		//如果存在
		if(exists){
			responseBody.setStatus(-1);
			responseBody.setMessage("手机已经被使用");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//调用业务类进行处理
		int modify = 0;
		if(StringUtil.isNotEmpty(phone)){
			modify = userService.registerPhone(phone,ppass);
		}
	
		if(modify>0){
			responseBody.setMessage("恭喜您！注册成功");
			response.sendRedirect("login.jsp");
		}else{
			responseBody.setMessage("对不起！注册失败");
			response.sendRedirect("register.jsp");
		}
		
		response.getWriter().write(responseBody.toJson());
	}
}
