package com.yy.mail.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.encoding.CachedCodeBase;
import com.yy.mail.cache.CacheContext;
import com.yy.mail.dao.common.ResponseBody;
import com.yy.mail.utils.ImageUtil;
import com.yy.mail.utils.VerificationCode;
import com.yy.mail.utils.VerificationCodeUtil;

/**
 * 验证码Servlet
 */
@WebServlet("/home/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 检查验证码
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//创建相应对象
		ResponseBody responseBody = new ResponseBody();
		//生成验证码对象
		VerificationCode verificationCode = VerificationCodeUtil.generateVerificationCode(200, 50);
		//将验证码保存到缓存中
		String key = VerificationCodeUtil.VERIFICATION_CODE_PREFIX + verificationCode.getCode();
		CacheContext.setCache(key, verificationCode.getCode());
		//讲验证码图片转换成base64位编码并放入响应对象
		responseBody.setData(ImageUtil.encodeToBase64(verificationCode.getImage()));
		responseBody.setMessage("获取验证码成功");
		resp.getWriter().write(responseBody.toJson());
	}
}
