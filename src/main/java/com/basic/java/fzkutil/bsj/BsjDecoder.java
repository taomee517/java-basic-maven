package com.basic.java.fzkutil.bsj;

import java.nio.charset.Charset;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/3/15
 * @time 17:06
 */
public class BsjDecoder {


    /**将明文转为16进制BSJ密文
     *
     * @param origin 明文内容
     * @return
     */
    public static String encode(String origin){
        char[] chars = origin.toCharArray();
        byte[] bs = origin.getBytes(Charset.forName("gb2312"));
        String encodeStr = ByteHexConvertUtil.encodeHexStr(bs,false);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<encodeStr.length();i+=2){
            String unit = encodeStr.substring(i,i+2);
            sb.append(unit);
            sb.append(" ");
        }
        String result = sb.toString();
        //去掉最后一个空格;
        result = result.substring(0,result.lastIndexOf(" "));
        return result;
    }

    /**将16进制BSJ密文转为明文
     *
     * @param secret 16进制BSJ密文
     * @return 明文结果
     */
    public static String decode(String secret){
        String trimSecret = secret.replaceAll(" ","");
        char[] chars = trimSecret.toCharArray();
        byte[] bytes = ByteHexConvertUtil.decodeHex(chars);
        String origin = new String(bytes,Charset.forName("gb2312"));
        return origin;
    }
}
