/***********************************************************************
 * Module:  Message.java
 * Author:  Administrator
 * Purpose: Defines the Class Message
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 注册短信，订单短信，支付短信，验证码短信
 * 
 * @pdOid 55b35a7d-bee5-428f-b1e6-53be9b14a3ae */
public class Message {
   /** @pdOid e6ae5033-6c39-4cd5-93f9-3b7dcdc4f77d */
   public double mId;
   /** @pdOid 8913418e-842a-4b5b-8eb8-46213cac26f7 */
   public java.lang.String mTitle;
   /** @pdOid 04cf30ea-a84d-4bda-b289-fa8f60da3e09 */
   public java.lang.String mContent;
   /** @pdOid e707eb0e-4c98-4bee-8b1e-9996848fdde4 */
   public double mPhone;
   /** @pdOid 63639f59-448e-4794-8407-b6729104a6a2 */
   public java.util.Date mSendTime;
   /** @pdOid 26c05d31-ecf7-4c2e-875f-0623cba665e3 */
   public java.lang.String mSendState;
   /** @pdOid 374b704b-e89b-4c04-b226-7ea056d781ff */
   public java.lang.String mType;
   /** @pdOid 6ae4b177-ed8b-4b85-94c5-4c394725658f */
   public java.util.Date createTime;
   /** @pdOid a0f45778-a4f4-404c-a82b-f2ae7501b092 */
   public java.lang.String creator;
   /** @pdOid d8ce0571-77a6-420e-a866-ef5ccccfec6a */
   public java.lang.String state;

}