package com.yy.mail.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.mail.utils.BaseServlet;

@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	
	public String toIndex(HttpServletRequest request,HttpServletResponse response) {
		
		return "/home/home.jsp";
	}
}
