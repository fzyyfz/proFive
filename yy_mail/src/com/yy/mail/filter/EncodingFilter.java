package com.yy.mail.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ���������
 * 
 * ʹ�ù���������
 * 1. ������ʵ��Filter�ӿڲ�ʵ��init,dofilter,dstory����
 * 2. ��doFilter�����б�д��������󲢵���chain.doFilter���(����ִ�к���Ĺ�������)
 * 3. ��web.xml�����ù�����
 * 
 * @author VIC
 *
 */
public class EncodingFilter implements Filter {
	
	private String charsetName;

	@Override
	public void destroy() {
		System.out.println("EncodingFilter destory");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter doFilter");
		// ͳһ��������������Ӧ�ı���
		request.setCharacterEncoding(charsetName);
		response.setCharacterEncoding(charsetName);
		// ͳһ����������Ӧ�����ݱ���
		response.setContentType("text/html;charset="+charsetName);
		// һ��Ҫִ��chain.doFilter(request, response);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("EncodingFilter init");
		charsetName = config.getInitParameter("charsetName");
	}

}
