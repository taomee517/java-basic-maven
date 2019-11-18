package com.basic.java.nio.charset;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;

/**
 * 字符集应用案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\12 0012 12:42
 */
public class CharSetDemo {
    public static void main(String[] args) throws IOException {

        Charset cs = Charset.forName("GBK");
        CharsetDecoder decoder = cs.newDecoder();
        CharsetEncoder encoder = cs.newEncoder();
        CharBuffer charBuf = CharBuffer.allocate(100);
        charBuf.put("我爱你，中国！");
        charBuf.flip();
        ByteBuffer buffer = encoder.encode(charBuf);
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
        buffer.flip();
        CharBuffer charBuf2 = decoder.decode(buffer);
        System.out.println(charBuf2.toString());

    }
}

class ViewAllCharset{
    public static void main(String[] args) throws IOException {
        //遍历所有可用的字符集
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        Set<String> charsetKeys = charsetMap.keySet();
        for(String key:charsetKeys){
            System.out.println(key + "  ==> " + charsetMap.get(key));
        }
    }
}
