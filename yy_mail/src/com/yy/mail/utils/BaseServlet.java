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
 * ͨ�õ�servlet������
 */

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������������
		request.setCharacterEncoding("utf-8");
		//���ղ���
		String methodName = request.getParameter("method");
		//����������ֽ���
		Class cla = this.getClass();
		//�������ִ�����ָ�����Ƶķ���
		try {
			Method method = cla.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//���������ִ��
			String path = (String)method.invoke(this, request,response);
			if(path != null) {
				request.getRequestDispatcher(path).forward(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
