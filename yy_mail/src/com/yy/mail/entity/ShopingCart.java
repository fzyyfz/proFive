/***********************************************************************
 * Module:  ShopingCart.java
 * Author:  Administrator
 * Purpose: Defines the Class ShopingCart
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 购物车
 * 
 * @pdOid 38b1b269-03ff-4dac-b771-f0a8f7d3ba8c */
public class ShopingCart {
   /** 购物车主键
    * 
    * @pdOid c522d710-099a-4987-815d-c772c5a6fc7e */
   public double scId;
   /** 商品ID
    * 
    * @pdOid b847754e-6629-4b1c-b638-b35f3784c919 */
   public double cId;
   /** 商品数量
    * 
    * @pdOid 589d5bde-7f00-4d5b-b5b8-3f3d775757c4 */
   public double cNumber;
   /** 商品单价
    * 
    * @pdOid 082a8be5-7434-4bd0-b349-4f958e01dbbb */
   public float cPrice;
   /** 商品名称
    * 
    * @pdOid 1628e407-7609-4622-8be5-41a24514deef */
   public java.lang.String cName;
   /** 用户ID
    * 
    * @pdOid 3d20283e-15ed-40e6-8a8b-caa4fa1370bf */
   public double uId;

}