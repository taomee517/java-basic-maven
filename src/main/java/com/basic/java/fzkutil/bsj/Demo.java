package com.basic.java.fzkutil.bsj;

import java.nio.charset.Charset;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/3/16
 * @time 8:45
 */
public class Demo {
    public static void main(String[] args) {
        String origin = "The terminal will restart after 20sec!";
        String secrect = "AB A8";
        char[] chars = origin.toCharArray();
        byte[] bs = origin.getBytes(Charset.forName("gb2312"));
        String encodeSecret = BsjDecoder.encode(origin);
        System.out.println(encodeSecret);
        System.out.println("解密结果：" + BsjDecoder.decode(secrect));
    }
}
