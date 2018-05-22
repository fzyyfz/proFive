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
import com.yy.mail.entity.Users;
import com.yy.mail.service.user.UserService;
import com.yy.mail.utils.StringUtil;

@WebServlet("/person/AddInformationServlet")
public class AddInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String account = (String)session.getAttribute("account");
		String phone = request.getParameter("telephonenumber");
		
		UserService userService = new UserService();
		List<Users> list = new ArrayList<Users>();
		
		boolean email = userService.emailExists(account);
		boolean pho = userService.phoneExists(account);
		boolean name = userService.nameExists(account);
		
		if(email){
			list = userService.selectInforByEmail(account);
		}else if(pho){
			list = userService.selectInforByPhone(account);
		}else if(name){
			list = userService.selectInforByName(account);
		}
		
		String json = JSON.toJSONString(list);
		response.getWriter().println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		String radio = request.getParameter("radio10");
		String phone = request.getParameter("telephonenumber");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession(false);
		String account = (String)session.getAttribute("account");
		
		ResponseBody responseBody = new ResponseBody();
		UserService userService = new UserService();
		if(StringUtil.isEmpty(name) || StringUtil.isEmpty(radio) ||StringUtil.isEmpty(phone) || StringUtil.isEmpty(email)){
			responseBody.setStatus(-1);
			responseBody.setMessage("请填写完整信息!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		if(radio.equals("male")){
			radio = "男";
		}else if(radio.equals("female")){
			radio = "女";
		}else if(radio.equals("secret")){
			radio = "保密";
		}
		
		boolean e = userService.emailExists(account);
		boolean p = userService.phoneExists(account);
		boolean n = userService.nameExists(account);

		int modify = 0;
		if(e){
			modify = userService.addInfroByemail(name,radio,phone,account);
		}else if(p){
			modify = userService.addInfroByphone(name,radio,email,account);
		}else if(n){
			modify = userService.addInfroByname(radio,phone,email,account);
		}
		
		if(modify>0){
			responseBody.setStatus(200);
			responseBody.setMessage("修改成功!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
	}
}
