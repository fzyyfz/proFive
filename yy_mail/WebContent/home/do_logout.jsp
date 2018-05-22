<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//删除客户信息
	session.removeAttribute("account");
	session.removeAttribute("password");
	
	//清除cookie信息
	response.addCookie(new Cookie("account",null));
	response.addCookie(new Cookie("password",null));

	//注销session
	session.invalidate();

	//返回login页面
	response.sendRedirect("login.jsp");
	
%>