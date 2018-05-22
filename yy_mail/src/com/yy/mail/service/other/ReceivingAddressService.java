package com.yy.mail.service.other;

import java.util.List;

import com.yy.mail.entity.ReceivingAddress;
import com.yy.mail.jdbc.JdbcTemplate;

public class ReceivingAddressService extends JdbcTemplate<ReceivingAddress>{

	public int addAddress(String user_name, String user_phone, String country, String province, String city,
			String detail, int id) {
		
		return  execute("insert into RECEIVING_ADDRESS values(ADD_SEQ.nextval,?,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?)",country,province,city,detail,user_name,"非默认",id,"2018-5-20","2018-5-25",user_phone);
	}

	public int  delAddress(int id) {
		
		return execute("delete from RECEIVING_ADDRESS where ra_id = ?",id);
	}

	public List<ReceivingAddress> selAddress(int id) {
		
		return quary("select * from RECEIVING_ADDRESS where ra_Id = ?", id);
	}

	public int editAddress(String user_name, String user_phone, String country, String province, String city,
			String detail, int id) {

		return execute("update RECEIVING_ADDRESS set RA_PERSON=?,RA_PHONE=?,RA_COUNTRY=?,RA_PROVINCE=?,RA_CITY=?,RA_DETAIL=? where RA_ID =?", user_name,user_phone,country,province,city,detail,id);
	}

	public int setDefault(int uid,int id) {

		execute("update RECEIVING_ADDRESS set STATE = '非默认' where U_ID=?",uid);
		
		return execute("update RECEIVING_ADDRESS set STATE = '默认' where ra_id = ?",id);
	}

}
