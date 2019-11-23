package com.basic.java.reflect.model;

public class CmdApi {

    @MethodSign(name = "查询（指定标签）")
    public static String query(@ParamDesc(name = "标签")String tag){
        return "(1*d5|1|" + tag + "|)";
    }

    @MethodSign(name = "查询（标签枚举）")
    public static String queryByEnum(@ParamDesc(name = "标签枚举") QueriableProtocolEnum queriableTag){
        return "(1*d5|1|" + queriableTag.getTag() + "|)";
    }

    /**
     * @function 设置主机地址
     * @param host 域名/IP
     * @param port 端口
     * @return
     */
    @MethodSign(name = "设置主机地址")
    public static String settingMasterAgServer(@ParamDesc(name = "域名/IP")String host,@ParamDesc(name = "端口")int port){
        String hexPort = Integer.toHexString(port);
        String cmd = "(1*d5|3|206" + host + "," + hexPort + "|)";
        return cmd;
    }
}
