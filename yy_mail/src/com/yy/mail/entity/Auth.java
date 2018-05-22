/***********************************************************************
 * Module:  Auth.java
 * Author:  Administrator
 * Purpose: Defines the Class Auth
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 管理后台系统权限
 * 
 * @pdOid 0a542090-ba00-4969-9d6b-876a9f1853bd */
public class Auth {
   /** 权限ID
    * 
    * @pdOid 19420f50-b842-4edd-82d2-016788cf3a3d */
   public double authId;
   /** 权限名称
    * 
    * @pdOid fce6efad-b3ff-45cd-a2e1-6d27526a019a */
   public java.lang.String authName;
   /** 权限代码
    * 
    * @pdOid c84ed883-1880-41a8-80d9-77bad0d2b4b3 */
   public java.lang.String authCode;
   /** 权限URL
    * 
    * @pdOid 83c0f2cb-e9d5-4075-a2b7-e6bb3b4d1bd4 */
   public java.lang.String authUrl;
   /** 创建时间
    * 
    * @pdOid f1c61b81-b7b9-4b7e-994e-5713d8152682 */
   public java.util.Date createTime;
   /** 创建人(默认为系统,否则为管理员)
    * 
    * @pdOid fefbf57a-6649-4490-ac68-b68d18e1aaa7 */
   public java.lang.String creator;
   /** 更新时间
    * 
    * @pdOid 5258b1e9-ebc8-4cc5-a9d7-f28de8d62c7d */
   public java.util.Date updateTime;
   /** 更新人(默认为系统,否则为管理员账号)
    * 
    * @pdOid 93e1645e-bc4f-46d6-9e2f-401771022019 */
   public java.lang.String updateCreator;
   /** 状态
    * 
    * @pdOid 50cbddf5-28fb-4c3c-9850-8b674bf64704 */
   public java.lang.String state;

}