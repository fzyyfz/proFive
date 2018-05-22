package com.yy.mail.service.user;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.yy.mail.entity.Users;

import junit.framework.Assert;

/**
 * 用户业务类测试
 * @author Administrator
 *
 */
public class UserServiceTest {

	@Test
	public void testUserServiceExecute(){
		UserService userService = new UserService();
//		UID        NUMBER                         用户ID   
//		UNAME      VARCHAR2(98)                   用户名   
//		UACCOUNT   VARCHAR2(98)                   用户登录账号 
//		UPASSWORD  VARCHAR2(98)                   用户登录密码 
//		USEX       VARCHAR2(8)   Y                用户性别 
//		UAGE       NUMBER        Y                用户年龄 
//		UHEAD      VARCHAR2(128) Y                用户头像 
//		UEMAIL     VARCHAR2(128) Y                用户邮箱 
//		UPHONE     NUMBER        Y                用户手机 
//		STATE      VARCHAR2(32)  Y                用户状态 
//		CREATETIME TIMESTAMP(6)  Y                注册时间 
		int modify = userService.execute("insert into USERS values(?,?,?,?,?,?,?,?,?,?,?)",1,"成龙","chenglong","chenglong","男",62,"cl.jpg","chenglong@163.com","18138131369","健在",new Timestamp(System.currentTimeMillis()));
		Assert.assertTrue(modify>0);
	}
	
	@Test
	public void testUserServiceQuery(){
		
		UserService userService = new UserService();
		String sql = "select * from USERS";
		List<Users> usersList = userService.quary(sql);
		System.out.println(usersList);
		Assert.assertTrue(usersList.size()>0);
	}
	
	@Test
	public void aa(){
		
		UserService userService = new UserService();
		List<Users> usersList = userService.quary("select u_id from users where uname =?","成龙");
		System.out.println(usersList);
	}
}












