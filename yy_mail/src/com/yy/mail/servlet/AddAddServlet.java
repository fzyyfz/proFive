package com.yy.mail.servlet;

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

@WebServlet("/person/AddAddServlet")
public class AddAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		int id = (int)session.getAttribute("id");
		
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		List<ReceivingAddress> list = new ArrayList<ReceivingAddress>();
		list = receivingAddressService.quary("select * from RECEIVING_ADDRESS where u_id =?", id);
		
		String json = JSON.toJSONString(list);
		response.getWriter().println(json);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().print("a");
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String country = request.getParameter("country");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String detail = request.getParameter("detail");
		
		//获取id
		HttpSession session = request.getSession(false);
		int id = (int)session.getAttribute("id");
		
		//验证为空
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(user_phone)||StringUtil.isEmpty(user_name)||StringUtil.isEmpty(country)||StringUtil.isEmpty(province)||StringUtil.isEmpty(city)||StringUtil.isEmpty(detail)){
			responseBody.setStatus(-1);
			responseBody.setMessage("参数不能为空!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		int modify = 0;
		ReceivingAddressService receivingAddressService = new ReceivingAddressService();
		ReceivingAddress receivingAddress = new ReceivingAddress();
		receivingAddress.ra_Person = user_name;
		receivingAddress.ra_Phone = user_phone;
		receivingAddress.ra_Country = country;
		receivingAddress.ra_Province = province;
		receivingAddress.ra_City = city;
		receivingAddress.ra_Detail = detail;
		//插入时返回的主键
		modify = receivingAddressService.addAddress(user_name,user_phone,country,province,city,detail,id);
		
		if(modify > 0){
			response.getWriter().println(modify);
			return ;
		}else{
			responseBody.setStatus(-1);
			responseBody.setMessage("添加失败!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
	}

}
