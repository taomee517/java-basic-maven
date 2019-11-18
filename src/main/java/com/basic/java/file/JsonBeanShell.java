package com.basic.java.file;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
public class JsonBeanShell {
    public static void main(String[] args) {
        Map<String,String> vars = new HashMap<String,String>();
        vars.put("brand", "{\"name\":\"AC Schnitzer\",\"bfirstletter\":\"A\",\"logo\":\"https:\\/\\/car3.autoimg.cn\\/cardfs\\/series\\/g27\\/M01\\/B0\\/62\\/100x100_f40_autohomecar__ChcCQFs9vBKAO3YSAAAW0WOWvRc555.png\",\"id\":117}");

        //获取获取请求的返回值
        String data = vars.get("brand");

        //日志打印获取请求的返回值
        log.info(data);

        //将String类型的返回值构造成JSONObject对象
        JSONObject obj = JSONObject.parseObject(data);

        String name = obj.get("name").toString();
        String firstletter = obj.get("bfirstletter").toString();
        String logo = obj.get("logo").toString();

        vars.put("name",name);
        vars.put("firstletter",firstletter);
        vars.put("logo",logo);
        log.info("vars: {}",vars);
    }
}
