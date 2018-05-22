package com.yy.mail.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用的servlet工具类
 */

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//处理请求乱码
		request.setCharacterEncoding("utf-8");
		//接收参数
		String methodName = request.getParameter("method");
		//反射获得类的字节码
		Class cla = this.getClass();
		//获得正在执行类的指定名称的方法
		try {
			Method method = cla.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//让这个方法执行
			String path = (String)method.invoke(this, request,response);
			if(path != null) {
				request.getRequestDispatcher(path).forward(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
