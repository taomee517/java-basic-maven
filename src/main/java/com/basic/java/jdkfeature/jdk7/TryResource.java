package com.basic.java.jdkfeature.jdk7;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class TryResource {
    public static void main(String[] args) {
        try (InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("in.txt");
             ByteArrayOutputStream out = new ByteArrayOutputStream(in.available())) {
            int charRead;
            while ((charRead = in.read()) != -1) {
                out.write(charRead);
            }
            String content = out.toString("UTF-8");
            log.info("读出文件内容为：{}", content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
