package com.yy.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.service.user.UserService;
import com.yy.mail.utils.StringUtil;

/**
 * 用户密码修改
 */
@WebServlet("/person/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String oldpassword = request.getParameter("old_password");
		String newpassword = request.getParameter("new_password");
		String conpassword = request.getParameter("con_password");
		
		//验证数据 不能为空
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(oldpassword) || StringUtil.isEmpty(newpassword) || StringUtil.isEmpty(conpassword)){
			responseBody.setStatus(-1);
			responseBody.setMessage("参数不能为空!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("name");
		String password = (String)session.getAttribute("password");

		//原密码是否匹配
		if(!(oldpassword.equals(password))){
			responseBody.setStatus(-1);
			responseBody.setMessage("原密码错误!");
			response.getWriter().write(responseBody.toJson());
			return ;
		}
		
		//新密码和确认密码是否一致
		UserService userService = new UserService();
		if(newpassword.equals(conpassword)){
			
			int modify = userService.execute("update users set UPASSWORD = ? where UNAME = ?",newpassword, name);
			if(modify>0){
				responseBody.setStatus(200);
				responseBody.setMessage("修改成功！");
				response.getWriter().write(responseBody.toJson());
				session.setAttribute("password", newpassword);
				response.sendRedirect("index.jsp");
				return ;
			}else{
				responseBody.setStatus(-1);
				responseBody.setMessage("修改失败!");
				response.getWriter().write(responseBody.toJson());
				return ;
			}
		}else{
			responseBody.setStatus(-1);
			responseBody.setMessage("两次输入密码不一致!");
			response.getWriter().write(responseBody.toJson());
			return ;
//			response.getWriter().write("<script>alert('两次输入密码不一致!')</script>");
//			response.sendRedirect("index.jsp");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
