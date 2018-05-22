/***********************************************************************
 * Module:  Order.java
 * Author:  Administrator
 * Purpose: Defines the Class Order
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 订单
 * 
 * @pdOid aff60a81-e2a9-4213-99d0-8323fbaca34a */
public class Order {
   /** 订单ID
    * 
    * @pdOid d7d27229-1f66-4875-8540-0e5f94ecf933 */
   public double oId;
   /** @pdOid d3109cb6-a396-4af8-a3c6-726d47825954 */
   public float oPrice;
   /** @pdOid cb957ae1-6623-4a3b-bbf5-ef4294a2f9f9 */
   public java.util.Date createTime;
   /** @pdOid de529e6e-2b4f-4a5f-b39a-bba674c5dc8d */
   public java.lang.String oState;
   /** 用户ID
    * 
    * @pdOid dc4bc48e-ed8e-405e-9604-e492b869b57f */
   public double uId;
   /** 订单号:系统生成
    * 
    * @pdOid 975badd0-5017-4c4a-9549-d3c8e9939803 */
   public java.lang.String oNumber;

}