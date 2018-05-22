package com.yy.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.mail.service.other.ReceivingAddressService;

@WebServlet("/person/DefaultServlet")
public class DefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.valueOf(request.getParameter("id"));
		
		HttpSession session = request.getSession(false);
		int uid = (int)session.getAttribute("id");
		
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		int modify = receivingAddressService.setDefault(uid,id);
		
		
		if(modify>0){
			//修改成功
			response.getWriter().println(1);
		}else{
			//修改失败
			response.getWriter().println(2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
