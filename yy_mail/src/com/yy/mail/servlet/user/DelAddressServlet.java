package com.yy.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.service.other.ReceivingAddressService;

/**
 * Servlet implementation class DelAddressServlet
 */
@WebServlet("/person/DelAddressServlet")
public class DelAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		ResponseBody responseBody = new ResponseBody();
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		
		int modify = 0;
		if(id>0){
			modify = receivingAddressService.delAddress(id);
		}
		
		if(modify>0){
			//删除成功
			response.getWriter().println(1);
		}else{
			//删除失败
			response.getWriter().println(2);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
