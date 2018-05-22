/***********************************************************************
 * Module:  ReceivingAddress.java
 * Author:  Administrator
 * Purpose: Defines the Class ReceivingAddress
 ***********************************************************************/
package com.yy.mail.entity;

import java.util.*;

/**
 * 收货地址
 * 
 * @pdOid cc2afbd7-4139-477c-b868-1c02591e8af1
 */
public class ReceivingAddress {
	/**
	 * ID
	 * 
	 * @pdOid c506ca3a-53e8-4194-b41f-32e6be4f0d16
	 */
	public int ra_Id;
	/**
	 * 国家
	 * 
	 * @pdOid fda12ac3-ed8c-4be4-a9d4-b57a7e23df54
	 */
	public java.lang.String ra_Country;
	/**
	 * 省
	 * 
	 * @pdOid b4619fe5-8df4-4dd1-8abb-4481ef57fb70
	 */
	public java.lang.String ra_Province;
	/**
	 * 市
	 * 
	 * @pdOid e741e76e-d2e0-4cea-8bc5-0e6026b44a58
	 */
	public java.lang.String ra_City;
	/**
	 * 详细地址
	 * 
	 * @pdOid b451e25d-94f1-43d0-a88c-7e9552dcd386
	 */
	public java.lang.String ra_Detail;
	/**
	 * 收货人姓名
	 * 
	 * @pdOid 140a899b-a62e-45e7-9966-1fc1633069d7
	 */
	public java.lang.String ra_Person;
	/**
	 * 收货人手机
	 * 
	 * @pdOid 0c658070-bf96-41be-bc60-8ec8e4582625
	 */
	public java.lang.String ra_Phone;
	/**
	 * 状态
	 * 
	 * @pdOid cb2ff5b0-8c49-4811-a7f7-79b0537c87ad
	 */
	public java.lang.String state;
	/**
	 * 用户ID
	 * 
	 * @pdOid a4ce219d-7811-4c06-88d7-de53b37d3559
	 */
	public int u_Id;
	/**
	 * 创建时间
	 * 
	 * @pdOid ed690e82-4492-44f5-a8b8-3b71e3cf5d59
	 */
	public java.util.Date create_Time;
	/**
	 * 更新时间
	 * 
	 * @pdOid ae5e8c3f-e5ca-462b-b1d7-6d7fff3e75c5
	 */
	public java.util.Date update_Time;
	public int getRa_Id() {
		return ra_Id;
	}
	public void setRa_Id(int ra_Id) {
		this.ra_Id = ra_Id;
	}
	public java.lang.String getRa_Country() {
		return ra_Country;
	}
	public void setRa_Country(java.lang.String ra_Country) {
		this.ra_Country = ra_Country;
	}
	public java.lang.String getRa_Province() {
		return ra_Province;
	}
	public void setRa_Province(java.lang.String ra_Province) {
		this.ra_Province = ra_Province;
	}
	public java.lang.String getRa_City() {
		return ra_City;
	}
	public void setRa_City(java.lang.String ra_City) {
		this.ra_City = ra_City;
	}
	public java.lang.String getRa_Detail() {
		return ra_Detail;
	}
	public void setRa_Detail(java.lang.String ra_Detail) {
		this.ra_Detail = ra_Detail;
	}
	public java.lang.String getRa_Person() {
		return ra_Person;
	}
	public void setRa_Person(java.lang.String ra_Person) {
		this.ra_Person = ra_Person;
	}
	public java.lang.String getRa_Phone() {
		return ra_Phone;
	}
	public void setRa_Phone(java.lang.String ra_Phone) {
		this.ra_Phone = ra_Phone;
	}
	public java.lang.String getState() {
		return state;
	}
	public void setState(java.lang.String state) {
		this.state = state;
	}
	public int getU_Id() {
		return u_Id;
	}
	public void setU_Id(int u_Id) {
		this.u_Id = u_Id;
	}
	public java.util.Date getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(java.util.Date create_Time) {
		this.create_Time = create_Time;
	}
	public java.util.Date getUpdate_Time() {
		return update_Time;
	}
	public void setUpdate_Time(java.util.Date update_Time) {
		this.update_Time = update_Time;
	}
	@Override
	public String toString() {
		return "ReceivingAddress [ra_Id=" + ra_Id + ", ra_Country=" + ra_Country + ", ra_Province=" + ra_Province
				+ ", ra_City=" + ra_City + ", ra_Detail=" + ra_Detail + ", ra_Person=" + ra_Person + ", ra_Phone="
				+ ra_Phone + ", state=" + state + ", u_Id=" + u_Id + ", create_Time=" + create_Time + ", update_Time="
				+ update_Time + "]";
	}


}