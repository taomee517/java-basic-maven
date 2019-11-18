package com.basic.java.db.redis.mq.pojo;

import java.io.Serializable;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 8:35
 */
public class UpgradeTask implements Serializable {
    private int id;
    private String imei;
    private String prod;
    private String version;
    private int totalShard;
    private int currShard;
    private int repeat;
    private ResultEnum result;
    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public ResultEnum getResult() {
        return result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTotalShard() {
        return totalShard;
    }

    public void setTotalShard(int totalShard) {
        this.totalShard = totalShard;
    }

    public int getCurrShard() {
        return currShard;
    }

    public void setCurrShard(int currShard) {
        this.currShard = currShard;
    }
}
