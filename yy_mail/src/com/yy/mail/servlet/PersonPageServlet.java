package com.yy.mail.servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.mail.utils.BaseServlet;

@WebServlet("/person/PersonPageServlet")
public class PersonPageServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	
	public String personalUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/index.jsp";
	}
	public String informationUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/information.jsp";
	}
	public String safetyUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/safety.jsp";
	}
	public String addressUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/address.jsp";
	}
	public String orderUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/order.jsp";
	}
	public String changeUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/change.jsp";
	}
	public String couponUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/coupon.jsp";
	}
	public String bonusUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/bonus.jsp";
	}
	public String billUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/bill.jsp";
	}
	public String collectionUI(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("account") == null) {
			return "/home/login.jsp";
		}
		return "/person/collection.jsp";
	}
	public String footUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/foot.jsp";
	}
	public String commentUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/comment.jsp";
	}
	public String newsUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/news.jsp";
	}
	public String passwordUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/password.jsp";
	}
	public String billlistUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/billlist.jsp";
	}
	public String bindphoneUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/bindphone.jsp";
	}
	public String setpayUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/setpay.jsp";
	}
	public String emailUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/email.jsp";
	}
	public String idcardUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/idcard.jsp";
	}
	public String questionUI(HttpServletRequest request,HttpServletResponse response) {

		return "/person/question.jsp";
	}

}
