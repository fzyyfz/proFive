/***********************************************************************
 * Module:  OrderDetails.java
 * Author:  Administrator
 * Purpose: Defines the Class OrderDetails
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 订单详情
 * 
 * @pdOid 42938b22-4ba8-4674-a2f9-01dec2f3cf49 */
public class OrderDetails {
   /** 订单详情ID
    * 
    * @pdOid 949eb2d0-bef1-4867-b7e8-67cb4834e746 */
   public double odId;
   /** 商品ID
    * 
    * @pdOid 79e85ec3-3600-439f-8c83-33fa0206d64c */
   public double cId;
   /** 商品数量
    * 
    * @pdOid fc1eca96-bc2f-4e13-84cd-1de44c84ce65 */
   public double cNumber;
   /** 商品单价
    * 
    * @pdOid 5e323c3b-6790-4db7-9960-7f4314917dd1 */
   public float cPrice;
   /** 状态
    * 
    * @pdOid 26844247-4ebe-4e1b-a882-79e04d270e47 */
   public java.lang.String state;
   /** 订单ID
    * 
    * @pdOid 4ff6b674-9798-410a-b029-c40c1597ecd2 */
   public double oId;
   /** 创建时间
    * 
    * @pdOid af2712e9-a7ac-4dcd-8a61-eda190ffd001 */
   public java.util.Date createTime;

}