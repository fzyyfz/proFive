/***********************************************************************
 * Module:  Email.java
 * Author:  Administrator
 * Purpose: Defines the Class Email
 ***********************************************************************/
package com.yy.mail.entity;

import java.util.*;

/**
 * 系统邮件，注册邮件，订单邮件
 * 
 * @pdOid 7caa0dc4-bd6e-400a-b185-e6b5fb0a83fd
 */
public class Email {
	
	public static final String REGISTER = "REGISTER";
	
	/** @pdOid 3b467d5e-9247-44a0-bd2e-f6496ff302da */
	public double eId;
	/** @pdOid 1295c26b-d63a-43b4-b10a-c637978ab517 */
	public java.lang.String eTitle;
	/** @pdOid 24e0c5c2-1562-41af-9eb9-faa0f31f97c2 */
	public java.lang.String eContent;
	/** @pdOid d6e6d287-23ce-4841-8c81-5e272a805af3 */
	public java.lang.String eEmail;
	/** @pdOid ccf82459-f8ca-447e-9bd3-afc283ac8324 */
	public java.util.Date eSendTime;
	/** @pdOid 7ad69a1a-1df1-4c27-984d-deb8fc387e04 */
	public java.util.Date createTime;
	/** @pdOid d24576e6-72d7-4bd2-950a-3683bae3412d */
	public java.lang.String creator;
	/** @pdOid 806cf79a-1d9a-4a5d-b79f-02eb85d80ecc */
	public java.lang.String eSendState;
	/** @pdOid 8594992e-4c8c-45e4-8610-98af3f5e7184 */
	public java.lang.String state;
	/** @pdOid 0ebfea0c-a10b-4216-9391-ff781270e283 */
	public java.lang.String eType;

	public double geteId() {
		return eId;
	}

	public void seteId(double eId) {
		this.eId = eId;
	}

	public java.lang.String geteTitle() {
		return eTitle;
	}

	public void seteTitle(java.lang.String eTitle) {
		this.eTitle = eTitle;
	}

	public java.lang.String geteContent() {
		return eContent;
	}

	public void seteContent(java.lang.String eContent) {
		this.eContent = eContent;
	}

	public java.lang.String geteEmail() {
		return eEmail;
	}

	public void seteEmail(java.lang.String eEmail) {
		this.eEmail = eEmail;
	}

	public java.util.Date geteSendTime() {
		return eSendTime;
	}

	public void seteSendTime(java.util.Date eSendTime) {
		this.eSendTime = eSendTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getCreator() {
		return creator;
	}

	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}

	public java.lang.String geteSendState() {
		return eSendState;
	}

	public void seteSendState(java.lang.String eSendState) {
		this.eSendState = eSendState;
	}

	public java.lang.String getState() {
		return state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	public java.lang.String geteType() {
		return eType;
	}

	public void seteType(java.lang.String eType) {
		this.eType = eType;
	}

}