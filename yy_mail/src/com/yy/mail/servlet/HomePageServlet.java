package com.yy.mail.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.mail.utils.BaseServlet;

@WebServlet("/home/HomePageServlet")
public class HomePageServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	
	public String personalUI(HttpServletRequest request,HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if(session.getAttribute("account") == null) {
			return "/home/login.jsp";
		}
		return "/person/index.jsp";
	}
	public String homeUI(HttpServletRequest request,HttpServletResponse response) {

		return "/home/home.jsp";
	}
	public String loginUI(HttpServletRequest request,HttpServletResponse response) {

		return "/home/login.jsp";
	}
	public String shopcartUI(HttpServletRequest request,HttpServletResponse response) {

		return "/home/shopcart.jsp";
	}
	public String introductionUI(HttpServletRequest request,HttpServletResponse response) {

		return "/home/introduction.jsp";
	}
	public String registUI(HttpServletRequest request,HttpServletResponse response) {
		
		return "/home/register.jsp";
	}
}
