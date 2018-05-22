/***********************************************************************
 * Module:  AdminOperateRecord.java
 * Author:  Administrator
 * Purpose: Defines the Class AdminOperateRecord
 ***********************************************************************/
package com.yy.mail.entity;
import java.util.*;

/** 管理员操作记录
 * 
 * @pdOid 67c5c2d0-e678-4a18-8573-3d973c2c03fb */
public class AdminOperateRecord {
   /** @pdOid 3748e54f-af1d-4ca3-b5e3-7addc5611bfc */
   public double aorId;
   /** 操作人(管理员账号)
    * 
    * @pdOid f6af068a-1a74-4ef5-9373-220bee250249 */
   public java.lang.String creator;
   /** 操作目标(例如:添加商品,来源于权限表数据)
    * 
    * @pdOid ad3a05e8-8088-49f1-8ef7-9a5727107e29 */
   public java.lang.String operateTarget;
   /** 操作时间
    * 
    * @pdOid bda0c4ac-8979-444a-93ea-02637293a364 */
   public java.util.Date operateTime;
   /** 操作详情
    * 
    * @pdOid 15b5d243-a3c7-4558-9139-277e15997cef */
   public java.lang.String operateDetail;

}