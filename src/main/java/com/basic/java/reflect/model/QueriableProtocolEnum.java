package com.basic.java.reflect.model;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2018/12/28
 * @time 17:46
 */
public enum QueriableProtocolEnum {
    IMEI("101","Q","P","设备IMEI号"),
    IMSI("102","Q","P","设备IMSI号"),
    CCID("103","Q","P","设备ccid号"),
    SOFTWARE_INFO("104","Q","P","软件版本"),
    HARDWARE_INFO("105","Q","P","硬件版本"),
    PROTOCOL_INFO("106","Q","P","协议版本"),
    COMMUNICATION_MODULE_VERSION("107","Q","P","通信模块版本"),
    POWER_STATUS("108","Q","P","上电状态"),
    SOFTWARE_BANK("10a","Q","P","程序Bank"),
    OPERATOR_NAME("10b","Q","P","运营商名称"),
    ABILITY("10c","Q","P","能力"),
    GLOBAL_UNIQUE_ID("10d","Q","P","全球唯一标识"),
    PRODUCT_TYPE("110","Q","P","产品类型"),
    APN_INFO("204","QS","P","APN地址"),
    MASTER_AG("206","QS","P","AG主机"),
    OIL_CONTROL("20a","QS","P","OTU油路"),
    SLAVE_AG("20f","QS","P","AG从机"),
    CUSTOM_CAR_MODEL_PARA("217","QS","P","定制车型参数"),
    MILEAGE_REPORT_SPEC("224","QS","P","里程上报阈值"),
    REMAINING_MILEAGE_REPORT_SPEC("227","QS","P","剩余里程上报阈值"),
    REMAINING_CAPACITY_REPORT_SPEC("228","QS","P","剩余电量上报阈值"),
    VOLTAGE_ALARM("230","QS","P","电压亏电告警"),
    TEMP_ALARM("231","QS","P","温度告警"),
    MISFIRE_ALARM("232","QS","P","熄火告警"),
    OIL_ALARM("233","QS","P","余油告警"),
    BLUETOOTH_KEY("240","QS","P","蓝牙钥匙id"),
    NETWORK_AIDED_LOCATION("262","QS","P","网络辅助定位"),
    BLUETOOTH_DEVICE_NAME("281","QS",null,"蓝牙设备名称"),
    BLUETOOTH_DEVICE_AUTH("282","QS",null,"蓝牙设备鉴权"),
    THRESHOLD("2a1","QS","P","驾驶事件阈值"),
    ACC("300","Q","P","ACC状态"),
    ON("301","Q","P","ON状态"),
    ENGINE("302","Q","P","引擎状态"),
    DRIVING_STATUS("303","Q","P","行驶状态"),
    DOOR_STATUS("304","Q","P","门状态"),
    LOCK_STATUS("305","Q","P","锁状态"),
    WINDOWS_STATUS("306","Q","P","窗状态"),
    LIGHT_STATUS("307","Q","P","车灯状态"),
    THEFT_PROOF_STATUS("308","Q","P","原车防盗状态"),
    BATTERY_STATUS("309","Q","P","电瓶状态"),
    REMAINING_OIL("30a","Q","P","余油信息"),
    TEMP("30b","Q","P","温度"),
    GPS_SATELLITE("30c","Q","P","GPS卫星信息"),
    LOCATION_HISTORY("30d","Q","P","历史定位信息"),
    GSM("30f","Q","P","GSM基站"),
    GPS("312","Q",null,"GPS定位信息"),
    INNER_DEVICES("315","Q","P","内部总线设备"),
    VOLTAGE("316","Q","P","电瓶电压"),
    BASE_STATION_INFO("31c","Q","P","基站信息"),
    SAFETY_BELT_SIGNAL("324","Q","P","安全带，有效标志"),
    COPILOT_SAFETY_BELT_STATUS("324","Q","P","安全带，副驾绑定状态"),
    DRIVER_SAFETY_BELT_STATUS("324","Q","P","安全带，主驾绑定状态"),
    ALL_STATUS("331","Q","P","原车状态"),
    DEFENCE_STATUS("333","QS","P","设防状态"),
    OIL_STATUS("334","QS","P","油路状态"),
    BASE_STATION("3d1","QW","P","基站信息");

    private String tag;
    private String gateway;
    private String device;
    private String desc;

    private QueriableProtocolEnum(String tag, String gateway, String device, String desc){
        this.tag = tag;
        this.gateway = gateway;
        this.device = device;
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public String getGateway() {
        return gateway;
    }

    public String getDevice(){
        return device;
    }

    public String getDesc() {
        return desc;
    }
}