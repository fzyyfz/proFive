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

import com.alibaba.fastjson.JSON;
import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.entity.ReceivingAddress;
import com.yy.mail.service.other.ReceivingAddressService;
import com.yy.mail.utils.StringUtil;

@WebServlet("/person/EditAddressServlet")
public class EditAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		//id
		HttpSession session = request.getSession(false);
		session.setAttribute("ra_Id",id);
		
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		List<ReceivingAddress> list = new ArrayList<ReceivingAddress>();
		
		list = receivingAddressService.selAddress(id);
	
		String json = JSON.toJSONString(list);
		response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String country = request.getParameter("country");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String detail = request.getParameter("detail");
		
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("ra_Id");
		
		//验证为空
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(user_phone)||StringUtil.isEmpty(user_name)||StringUtil.isEmpty(country)||StringUtil.isEmpty(province)||StringUtil.isEmpty(city)||StringUtil.isEmpty(detail)){
			responseBody.setStatus(-1);
			responseBody.setMessage("参数不能为空!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		int modify = receivingAddressService.editAddress(user_name,user_phone,country,province,city,detail,id);
		if(modify>0){
			//成功
			response.getWriter().println(1);
		}else{
			//失败
			response.getWriter().println(2);
		}
	}
}
