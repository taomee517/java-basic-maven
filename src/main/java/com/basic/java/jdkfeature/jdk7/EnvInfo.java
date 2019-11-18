package com.basic.java.jdkfeature.jdk7;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class EnvInfo {
    public static void main(String[] args) {
        Map<String,String> map = System.getenv();
        log.info("获取服务器环境变量：{}",map.size());
        String javaHome = map.get("JAVA_HOME");
        log.info(javaHome);
    }
}
