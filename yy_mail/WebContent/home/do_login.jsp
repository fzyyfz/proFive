
aaaaaaaaaaaaaaaaaaaaaaaaaa
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String account = request.getParameter("account");
	String password = request.getParameter("password");
	Object remember = request.getParameter("remember");
	
	//登陆失败
	if(account == null || password == null){
		response.sendRedirect("login.jsp");
	}
	
	if(account != null && password.equals("123456")){
		
		session.setAttribute("account", account);
		session.setAttribute("password", password);
		//如果记住密码 保存到cookie
		if(Boolean.valueOf(remember.toString())){
			//创建账号cookie对象
			Cookie accountCookie = new Cookie("account",account);
			// 创建密码cookie对象
			String ecyPassword = response.encodeUrl(password);
			System.out.println("ecyPassword: " + ecyPassword);
			Cookie passwordCookie = new Cookie("password", ecyPassword);
			//添加cookie 向客户端添加cookie
			response.addCookie(accountCookie);
			response.addCookie(passwordCookie);
		}
		
		response.sendRedirect("home.jsp");
	}else{
		//登陆失败
		response.sendRedirect("login.jsp");
	}
	
%>