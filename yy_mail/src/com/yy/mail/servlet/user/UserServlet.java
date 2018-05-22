package com.yy.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.mail.cache.CacheContext;
import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.service.other.EmailService;
import com.yy.mail.service.user.UserService;
import com.yy.mail.utils.StringUtil;
import com.yy.mail.utils.VerificationCodeUtil;

import sun.swing.StringUIClientPropertyKey;

/**
 * 用户Servlet
 */
@WebServlet("/home/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//注册用户
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取注册数据
		String email = request.getParameter("email");
		String oldpassword = request.getParameter("oldpassword");
		String conpassword = request.getParameter("conpassword");
		String validateCode = request.getParameter("validateCode");
		
		//验证注册数据 不能为空
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(email) || StringUtil.isEmpty(oldpassword) || StringUtil.isEmpty(conpassword) || StringUtil.isEmpty(validateCode)){
			responseBody.setStatus(-1);
			responseBody.setMessage("注册参数不能为空!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//验证验证码
//		String key = VerificationCodeUtil.VERIFICATION_CODE_PREFIX + validateCode;
//		String code = CacheContext.getCache(key.toUpperCase(), String.class);
//		if(StringUtil.isEmpty(code) || !code.equalsIgnoreCase(validateCode)){
//			responseBody.setStatus(-1);
//			responseBody.setMessage("验证码过期或验证码错误");
//			response.getWriter().write(responseBody.toJson());
//			return;
//		}else{
//			//  移除验证码
//			CacheContext.removeCache(key);
//		}
		
		if(!(oldpassword.equals(conpassword))){
			responseBody.setStatus(-1);
			responseBody.setMessage("密码不一致，请确认密码");
			response.sendRedirect("register.jsp");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//验证账号唯一性
		UserService userService = new UserService();
		boolean exists = false;
		if(StringUtil.isNotEmpty(email)){
			exists = userService.checkedEmail(email);
		}
		
		//如果存在
		if(exists){
			responseBody.setStatus(-1);
			responseBody.setMessage("邮箱已经被使用");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//调用业务类进行处理
		int modify = 0;
		if(StringUtil.isNotEmpty(email)){
			modify = userService.registerEmail(email,oldpassword);
		}
		
		if(modify>0){
			//注册成功后生成邮件通知内容
			responseBody.setMessage("恭喜您！注册成功");
			response.sendRedirect("login.jsp");
		}else{
			responseBody.setMessage("对不起！注册失败");
			response.sendRedirect("register.jsp");
		}
		
		response.getWriter().write(responseBody.toJson());
	}

	//登录
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	//邮箱验证
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		UserService userService = new UserService();
		boolean exists = false;
		//验证邮箱
		if(StringUtil.isNotEmpty(email) && !(email.equals(""))){
			exists = userService.checkedEmail(email);
			if(exists){
				response.getWriter().println(1);
			}else{
				response.getWriter().println(2);
			}
		}
		//验证手机
		if(StringUtil.isNotEmpty(phone) && !(phone.equals(""))){
			exists = userService.checkedPhone(phone);
			if(exists){
				response.getWriter().println(1);
			}else{
				response.getWriter().println(2);
			}
		}
	}
}
