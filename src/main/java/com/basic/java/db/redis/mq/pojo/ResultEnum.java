package com.basic.java.db.redis.mq.pojo;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 8:38
 */
public enum ResultEnum {
    /**未开始*/
   NOT_STARTED,

    /**升级中*/
   UPGRATING,

    /**升级成功*/
   SUCCESS,

    /**升级失败*/
   FAIL;
}
