/***********************************************************************
 * Module:  Commodity.java
 * Author:  Administrator
 * Purpose: Defines the Class Commodity
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 商品
 * 
 * @pdOid 2b8beef3-f9c0-455f-a75c-4b01d49db2a2 */
public class Commodity {
   /** 商品ID
    * 
    * @pdOid 73eff70d-62b9-4aec-bcc4-aeca45658d32 */
   public double cId;
   /** 商品名称
    * 
    * @pdOid 738a20fe-d7e3-4f4a-8ab1-c45ae881c593 */
   public java.lang.String cName;
   /** 商品地址
    * 
    * @pdOid cd563fd7-33d6-4286-94b0-ecf97601dc6d */
   public java.lang.String cUrl;
   /** 商品描述
    * 
    * @pdOid a0dabb7f-2523-4009-b0b2-f7a80b0421ba */
   public java.lang.String cDescribe;
   /** 商品关键字
    * 
    * @pdOid 45b83b8a-8a10-4f4d-9f76-3a990a62133f */
   public java.lang.String cKeywords;
   /** 商品价格
    * 
    * @pdOid 4997c13b-563e-40ec-9d9d-00803312927a */
   public java.lang.String cPrice;
   /** 商品图片: 图片存储的相对路径或绝对路径
    * 
    * @pdOid 6b69c33a-d956-4498-ae25-d188c88a2f3d */
   public float cPic;
   /** 商品状态: 新建/上架/下架/删除
    * 
    * @pdOid 1105b233-6889-4cee-a620-512f6be0ac93 */
   public java.lang.String cState;
   /** 创建时间(当前系统时间)
    * 
    * @pdOid b8288bd6-ce27-47b2-afa5-01e3e432aad0 */
   public java.util.Date createTime;
   /** 创建人(管理员账号)
    * 
    * @pdOid b8683bed-d944-41a0-831a-56831d8813e3 */
   public java.lang.String creator;
   /** 更新时间(当前系统时间)
    * 
    * @pdOid 1c74a29a-70e6-4828-916b-c098f8f12b56 */
   public java.util.Date updateTime;
   /** 更新人(管理员账号)
    * 
    * @pdOid 0b74212f-f7b5-4183-a521-69fbdd4ac31b */
   public java.lang.String updateCreator;

}