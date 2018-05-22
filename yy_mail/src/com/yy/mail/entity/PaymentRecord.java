/***********************************************************************
 * Module:  PaymentRecord.java
 * Author:  Administrator
 * Purpose: Defines the Class PaymentRecord
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 支付记录
 * 
 * @pdOid b3356fda-ebac-4d9e-a21c-7ca0a25c66e7 */
public class PaymentRecord {
   /** @pdOid 235bdcc1-318b-4cbd-887e-98bca3d92497 */
   public double prId;
   /** 支付方式
    * 
    * @pdOid a15be061-f617-448c-89d7-c545fe5d8308 */
   public java.lang.String paymentMethod;
   /** 支付状态
    * 
    * @pdOid fe51db32-2018-443f-af9d-0111f36e15c0 */
   public java.lang.String paymentState;
   /** 支付时间
    * 
    * @pdOid 65eabb7a-e8e0-431c-ac44-575dbae8af82 */
   public java.util.Date paymentTime;
   /** 支付总金额
    * 
    * @pdOid 4d022968-ae7e-4989-9b80-5a6002adf732 */
   public float paymentTotal;
   /** 商品数量
    * 
    * @pdOid 7e648650-26e9-4c3d-b770-4edc249bf001 */
   public double paymentNumber;
   /** 支付其他
    * 
    * @pdOid 04ace5c0-260a-44a5-bd8d-40078ed5066f */
   public java.lang.String paymentOther;
   /** 状态
    * 
    * @pdOid d22a39af-ee99-4961-8043-0ed0c41f43c6 */
   public java.lang.String state;
   /** 订单ID
    * 
    * @pdOid e87ab06e-658f-41cb-bd9c-ae354432c5c6 */
   public double oId;
   /** 创建时间
    * 
    * @pdOid b8376762-5a15-48b2-aa4a-53a4305f0260 */
   public java.util.Date createTime;

}