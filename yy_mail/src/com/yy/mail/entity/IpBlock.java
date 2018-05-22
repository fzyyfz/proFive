/***********************************************************************
 * Module:  IpBlock.java
 * Author:  Administrator
 * Purpose: Defines the Class IpBlock
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** IP黑名单
 * 
 * @pdOid 92505f1a-441a-4f2c-9980-97339140f805 */
public class IpBlock {
   /** ID
    * 
    * @pdOid 8f143ee4-3f18-4dc5-99fe-d38ce11e2ff8 */
   public double ibId;
   /** IP地址
    * 
    * @pdOid dfac69fd-8713-44b2-8c3f-dd10191673e8 */
   public java.lang.String ibIp;
   /** 创建时间
    * 
    * @pdOid 2624d0f6-6656-4b2e-839b-c72f790ad11a */
   public java.util.Date createTime;
   /** 创建人
    * 
    * @pdOid bafab96e-4649-45ab-9deb-7740d9b0346a */
   public java.lang.String creator;
   /** 更新时间
    * 
    * @pdOid 442f5385-1c8a-4b17-8aac-be7336871b2f */
   public java.util.Date updateTime;
   /** 更新人
    * 
    * @pdOid 9b60f176-cade-4a0a-a663-b883607bd210 */
   public java.lang.String updateCreator;
   /** 状态
    * 
    * @pdOid c89e0be8-f5b5-47d5-8c5c-ed38dfb7b550 */
   public java.lang.String state;

}