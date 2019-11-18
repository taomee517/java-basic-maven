package com.basic.java.regex;

import com.mifmif.common.regex.Generex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static Logger log = LoggerFactory.getLogger(RegexDemo.class);
    /**正则表达式开始符*/
    public static final String REGEX_START_SIGN = "^";

    /**正则表达式结束符*/
    public static final String REGEX_END_SIGN = "$";

    /**
     * 生成一个随机字符
     * @return 随机字符
     */
    public static String getStdChar(){
        List<String> std = new ArrayList<>();
        //匹配0-9中的任意一个数字，等效于[0-9]
        std.add("\\d");

        //匹配非数字字符，等效于[^0-9]
        std.add("\\D");

        //匹配任意一个字母、数字或下划线，等效于[A-Za-z0-9_]
        std.add("\\w");

        //与任何非字母、数字或下划线字符匹配，等效于[^A-Za-z0-9_]
        std.add("\\W");

        //匹配任何空白字符，包括空格、制表符、换页符，等效于 ?[\f\n\r\t\v]
        std.add("\\s");

        //匹配任何非空白字符，等效于[^\f\n\r\t\v]
        std.add("\\S");

//        //匹配换行符
//        std.add("\\n");
//
//        //匹配一个回车符
//        std.add("\\r");
//
//        //匹配制表符
//        std.add("\\t");
//
//        //匹配垂直制表符
//        std.add("\\v");
//
//        //匹配换页符
//        std.add("\\f");

        String regex = std.get(new Random().nextInt(std.size()));
        String result = getRandomString(regex);
        log.info("正则表达式：{}，生成随机字符：{}",regex,result);
        return result;
    }


    public static String getMultiModeWords(){
        String regex = "stop(s|ed|ing)";
        return getRandomString(regex);
    }

    public static String getRandomIp(){
        String regex = "(2(5[0-5]|[0-4]\\d)|[0-1]?\\d{1,2})(\\.(2(5[0-5]|[0-4]\\d)|[0-1]?\\d{1,2})){3}";
        return getRandomString(regex);
    }

    /**
     * 使用字母、数字和符号两种及以上的组合，6-20个字符
     * @return
     */
    public static String getRandomPassword(){
        String regex = "^[A-Za-z0-9@#$]{6,20}$";
        String regex1 = "([A-Za-z]+$)";
        String regex2 = "([0-9]+$)";
        String regex3 = "([@#$]+$)";
        String result = getRandomString(regex);
        while (Pattern.matches(regex1,result)
            || Pattern.matches(regex2,result)
            || Pattern.matches(regex3,result)){
            result = getRandomString(regex);
        }

        return result;
    }

    /**
     * 生成一个随机汉字
     * @return 随机汉字
     */
    public static String getRandomChineseChar(){
        String regex = "^[\u4e00-\u9fa5]$";
        return getRandomString(regex);
    }

    /**
     * @return 随机的中国大陆手机号
     */
    public static String getRandomPhoneNo(){
        String regex = "+86-1(3\\d|45|47|5[0-3]|5[5-9]|66|7[1235678]|8\\d)\\d{8}";
        return getRandomString(regex);
    }

    /**
     * 生成一个1900-2199年的随机日期，还有bug，如2月30，2月31,闰年
     * @return 随机日期
     */
    public static String getRandomDate(){
        String regex = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])";
        return getRandomString(regex);
    }

    /**
     * 生成HH:MM格式的随机时间
     * @return 随机时间
     */
    public static String getRandomTime(){
        String regex = "([0-1][0-9]|2[0-3]):[0-5][0-9]";
//        String regex = "([0-1]{1}[0-9]{1}|2[0-3]{1}):[0-5]{1}[0-9]{1}";
        return getRandomString(regex);
    }

     public static String getRandomDateTime(){
         String regex = "(19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])([0-1][0-9]|2[0-3])[0-5][0-9][0-5][0-9]";
         return getRandomString(regex);
     }

   /**
     * 根据正则表达式生成随机字符串
     * @param regex 正则表达式
     * @return 随机字符串
     */
    public static String getRandomString(String regex){
        if(regex.startsWith(REGEX_START_SIGN)){
            regex = regex.substring(1);
        }
        if(regex.endsWith(REGEX_END_SIGN)){
            regex = regex.substring(0,regex.length()-1);
        }
        Generex generator = new Generex(regex);
        return generator.random();
    }


    public static void main(String[] args) {
        int n = 200;
//        for(int i=0;i<n;i++){
//            String result = getRandomIp();
//            log.info(result);
//        }
//        String regex = "(2(5[0-5]|[0-4]\\d)|[0-1]?\\d{1,2})(\\.(2(5[0-5]|[0-4]\\d)|[0-1]?\\d{1,2})){3},\\d+";
//        String input = "127.0.0.1,8001";
//        log.info("匹配结果：{}",Pattern.matches(regex,input));
        for(int i=0;i<n;i++) {
            String dateTime = getRandomDateTime();
            System.out.println(dateTime);
        }
    }

}
