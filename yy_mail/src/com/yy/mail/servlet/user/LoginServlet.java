package com.yy.mail.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.entity.Users;
import com.yy.mail.service.user.UserService;
import com.yy.mail.utils.StringUtil;

@WebServlet("/home/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		ResponseBody responseBody = new ResponseBody();
		//不能为空
		if(StringUtil.isEmpty(account) || StringUtil.isEmpty(password)){
			responseBody.setStatus(-1);
			responseBody.setMessage("注册参数不能为空!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//验证邮箱,手机,用户名是否存在
		UserService userService = new UserService();
		boolean emailExists = userService.emailExists(account);
		boolean phoneExists = userService.phoneExists(account);
		boolean nameExists = userService.nameExists(account);
		
		//如果是邮箱登录
		if(emailExists){
			List<Users> userList; 
			userList = userService.loginEmail(account);
				String pw = userList.get(0).upassword;
				String name = userList.get(0).uname;
				int id = userList.get(0).u_id;
				HttpSession session = request.getSession();
				if(pw.equals(password)){
					session.setAttribute("account", account);
					session.setAttribute("name", name);
					session.setAttribute("password", password);
					session.setAttribute("email", account);
					session.setAttribute("id", id);
					response.sendRedirect("home.jsp");
				}else{
					responseBody.setStatus(-1);
					responseBody.setMessage("密码错误!");
					response.getWriter().write(responseBody.toJson());
					return ;
				}
		}
		//如果是手机登录
		else if(phoneExists){
			List<Users> userList; 
			userList = userService.loginPhone(account);
				String pw = userList.get(0).upassword;
				String name = userList.get(0).uname;
				int id = userList.get(0).u_id;
				HttpSession session = request.getSession();
				if(pw.equals(password)){
					session.setAttribute("account", account);
					session.setAttribute("name", name);
					session.setAttribute("password", password);
					session.setAttribute("phone", account);
					session.setAttribute("id", id);
					response.sendRedirect("home.jsp");
				}else{
					responseBody.setStatus(-1);
					responseBody.setMessage("密码错误!");
					response.getWriter().write(responseBody.toJson());
					return ;
				}
		}
		//如果是用户名登录
		else if(nameExists){
			List<Users> userList; 
			userList = userService.loginName(account);
				String pw = userList.get(0).upassword;
				int id = userList.get(0).u_id;
				HttpSession session = request.getSession();
				if(pw.equals(password)){
					session.setAttribute("account", account);
					session.setAttribute("name", account);
					session.setAttribute("id", id);
					session.setAttribute("password", password);
					response.sendRedirect("home.jsp");
				}else{
					responseBody.setStatus(-1);
					responseBody.setMessage("密码错误!");
					response.getWriter().write(responseBody.toJson());
					return ;
				}
		}
		else{
			responseBody.setStatus(-1);
			responseBody.setMessage("账号不存在!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
	}
}

