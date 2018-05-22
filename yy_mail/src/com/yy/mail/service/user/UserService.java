package com.yy.mail.service.user;

import java.sql.Timestamp;
import java.util.List;

import com.yy.mail.entity.ReceivingAddress;
import com.yy.mail.entity.Users;
import com.yy.mail.jdbc.JdbcTemplate;

/**
 * 用户业务类
 * @author Administrator
 *
 */
public class UserService extends JdbcTemplate<Users>{

	//验证邮箱
	public boolean checkedEmail(String email) {
		
		return exists("select * from users where uemail=?", email);
	}
	//验证手机
	public boolean checkedPhone(String phone) {
		
		return exists("select * from users where uphone=?", phone);
	}
	//邮箱登录
	public int registerEmail(String email, String oldpassword) {
		//insert into USERS values(USER_SEQ.nextval,'姚明','ym','a','男',40,'ym.jpg','a','15215','健在',sysdate)
		return execute("insert into USERS values(?,?,?,?,?,?,?,?,?,?,USER_SEQ.nextval)","用户",email,oldpassword,"男",15,"/yy_mail/images/getAvatar.do.jpg",email,null,"未激活",new Timestamp(System.currentTimeMillis()));
	}
	//手机登录
	public int registerPhone(String phone, String ppass) {
		//insert into USERS values(USER_SEQ.nextval,'姚明','ym','a','男',40,'ym.jpg','a','15215','健在',sysdate)
		return execute("insert into USERS values(?,?,?,?,?,?,?,?,?,?,USER_SEQ.nextval)","用户",phone,ppass,"男",18,"/yy_mail/images/getAvatar.do.jpg",null,phone,"未激活",new Timestamp(System.currentTimeMillis()));
	}

	//验证邮箱是否存在
	public boolean emailExists(String account) {

		return exists("select * from users where UEMAIL = ?", account);
	}
	//验证号码是否存在
	public boolean phoneExists(String account) {
		
		return exists("select * from users where UPHONE = ?", account);
	}
	//验证用户名是存在
	public boolean nameExists(String account) {
		
		return exists("select * from users where UNAME = ?", account);
	}
	//邮箱登录
	public List<Users> loginEmail(String account) {

		return quary("select u_id,upassword,uname from users where UEMAIL = ?", account);
	}
	//手机登录
	public List<Users> loginPhone(String account) {

		return quary("select u_id,upassword,uname from users where UPHONE = ?", account);
	}
	//用户名登录
	public List<Users> loginName(String account) {

		return quary("select u_id,upassword from users where UNAME = ?", account);
	}
	public List<Users> selectInforByEmail(String account) {

		return quary("select UHEAD,UPHONE,UEMAIL,USEX from USERS where UEMAIL = ?", account);
	}
	public List<Users> selectInforByName(String account) {

		return quary("select UHEAD,UPHONE,UEMAIL,USEX from USERS where UNAME = ?", account);
	}
	public List<Users> selectInforByPhone(String account) {

		return quary("select UHEAD,UPHONE,UEMAIL,USEX from USERS where UPHONE = ?", account);
	}
	
	public int addInfroByemail(String name, String radio, String phone,String account) {

		return execute("update USERS set uname=?,usex=?,uphone=? where uemail = ?", name,radio,phone,account); 
	}
	public int addInfroByphone(String name, String radio, String email,String account) {

		return execute("update USERS set uname=?,usex=?,uemail=? where uphone = ?", name,radio,email,account); 
	}
	public int addInfroByname(String radio, String phone, String email,String account) {

		return execute("update USERS set usex=?,uphone=?,uemail=? where uname = ?",radio,phone,email,account); 
	}
}
