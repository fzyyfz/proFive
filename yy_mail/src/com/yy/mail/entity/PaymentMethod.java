/***********************************************************************
 * Module:  PaymentMethod.java
 * Author:  Administrator
 * Purpose: Defines the Class PaymentMethod
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 支付方式，支付平台，支付渠道
 * 
 * @pdOid 1adcbf00-416e-4ae8-86a9-3c6f7717c3a2 */
public class PaymentMethod {
   /** ID
    * 
    * @pdOid e7b1a728-34ed-462a-9832-26a61ba6fead */
   public double pmId;
   /** 支付方式名称
    * 
    * @pdOid 8d90a30d-fac3-4d13-807f-7fac2e8b1bd6 */
   public java.lang.String pmName;
   /** 支付KEY
    * 
    * @pdOid ff0f429d-3cea-4975-9708-e3df35f21021 */
   public java.lang.String pmKey;
   /** 支付通知URL
    * 
    * @pdOid 73358598-ca58-48d0-bb60-5c35921faf1e */
   public java.lang.String pmNotice;
   /** 支付URL
    * 
    * @pdOid 77e27f0c-5676-4e68-9be3-3293d01f2361 */
   public java.lang.String pmUrl;
   /** 支付Token
    * 
    * @pdOid 0f7d2c39-a429-4bd2-8b23-d02d100d93cb */
   public java.lang.String pmToken;
   /** 支付其他参数
    * 
    * @pdOid 0863b36e-24f7-4263-ab97-0c0dc20cb35b */
   public java.lang.String pmOther;
   /** 状态
    * 
    * @pdOid 33cee32d-6fa6-4099-93b9-fdb56c6b6e47 */
   public java.lang.String state;
   /** 创建时间
    * 
    * @pdOid 456ac2fb-1226-4660-aeee-954fc1c6adfc */
   public java.util.Date createTime;
   /** 创建人
    * 
    * @pdOid 929ee69b-3e73-4017-b50e-1e5480e7d426 */
   public java.lang.String creator;
   /** 更新时间
    * 
    * @pdOid 308e7e7f-f147-475d-835a-df0761f9f4eb */
   public java.util.Date updateTime;
   /** 更新人
    * 
    * @pdOid 37932fff-4cfe-4e98-961e-fe1c74718cb4 */
   public java.lang.String updateCreator;

}