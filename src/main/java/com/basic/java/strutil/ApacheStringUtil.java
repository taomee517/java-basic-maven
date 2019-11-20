package com.basic.java.strutil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * 参考原文：StringUtils工具类的常用方法 https://www.iteye.com/blog/janwer-148313
 */
@Slf4j
public class ApacheStringUtil {
    @Test
    public void isEmptyTest(){
        boolean a = StringUtils.isEmpty(null);
        System.out.println(a);

        boolean b = StringUtils.isEmpty("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        boolean c = StringUtils.isEmpty(" ");
        System.out.println(c);

        boolean d = StringUtils.isEmpty("  ");
        System.out.println(d);

        boolean e = StringUtils.isEmpty("bob");
        System.out.println(e);

        boolean f = StringUtils.isEmpty(" bob ");
        System.out.println(f);
    }


    @Test
    public void isNotEmptyTest(){
        boolean a = StringUtils.isNotEmpty(null);
        System.out.println(a);

        boolean b = StringUtils.isNotEmpty("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        boolean c = StringUtils.isNotEmpty(" ");
        System.out.println(c);

        boolean d = StringUtils.isNotEmpty("  ");
        System.out.println(d);

        boolean e = StringUtils.isNotEmpty("bob");
        System.out.println(e);

        boolean f = StringUtils.isNotEmpty(" bob ");
        System.out.println(f);
    }


    @Test
    public void isBlankTest(){
        boolean a = StringUtils.isBlank(null);
        System.out.println(a);

        boolean b = StringUtils.isBlank("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        boolean c = StringUtils.isBlank(" ");
        System.out.println(c);

        boolean d = StringUtils.isBlank("  ");
        System.out.println(d);

        boolean e = StringUtils.isBlank("bob");
        System.out.println(e);

        boolean f = StringUtils.isBlank(" bob ");
        System.out.println(f);
    }

    @Test
    public void isNotBlankTest(){
        boolean a = StringUtils.isNotBlank(null);
        System.out.println(a);

        boolean b = StringUtils.isNotBlank("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        boolean c = StringUtils.isNotBlank(" ");
        System.out.println(c);

        boolean d = StringUtils.isNotBlank("  ");
        System.out.println(d);

        boolean e = StringUtils.isNotBlank("bob");
        System.out.println(e);

        boolean f = StringUtils.isNotBlank(" bob ");
        System.out.println(f);
    }

    @Test
    public void trimTest(){
        String a = StringUtils.trim(null);
        System.out.println(a);

        String b = StringUtils.trim("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        String c = StringUtils.trim(" ");
        System.out.println(c);

        String d = StringUtils.trim("  \b \t \n \f \r    ");
        System.out.println(d);

        String e = StringUtils.trim("     \n\tss   \b");
        System.out.println(e);

        String f = StringUtils.trim(" d   d dd     ");
        System.out.println(f);

        String g = StringUtils.trim("dd     ");
        System.out.println(g);

        String h = StringUtils.trim("     dd       ");
        System.out.println(h);
    }


    @Test
    public void trimToNullTest(){
        String a = StringUtils.trimToNull(null);
        System.out.println(a);

        String b = StringUtils.trimToNull("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        String c = StringUtils.trimToNull(" ");
        System.out.println(c);

        String d = StringUtils.trimToNull("  \b \t \n \f \r    ");
        System.out.println(d);

        String e = StringUtils.trimToNull("     \n\tss   \b");
        System.out.println(e);

        String f = StringUtils.trimToNull(" d   d dd     ");
        System.out.println(f);

        String g = StringUtils.trimToNull("dd     ");
        System.out.println(g);

        String h = StringUtils.trimToNull("     dd       ");
        System.out.println(h);
    }


    @Test
    public void trimToEmptyTest(){
        String a = StringUtils.trimToEmpty(null);
        System.out.println(a);

        String b = StringUtils.trimToEmpty("");
        System.out.println(b);

        //注意在 StringUtils 中空格作非空处理
        String c = StringUtils.trimToEmpty(" ");
        System.out.println(c);

        String d = StringUtils.trimToEmpty("  \b \t \n \f \r    ");
        System.out.println(d);

        String e = StringUtils.trimToEmpty("     \n\tss   \b");
        System.out.println(e);

        String f = StringUtils.trimToEmpty(" d   d dd     ");
        System.out.println(f);

        String g = StringUtils.trimToEmpty("dd     ");
        System.out.println(g);

        String h = StringUtils.trimToEmpty("     dd       ");
        System.out.println(h);
    }


    @Test
    public void stripTest(){
        String msg = "(1*ea|5|613,6,5#b803,1,2,3,#)";
        msg = StringUtils.stripStart(msg,"(");
        msg = StringUtils.stripEnd(msg,")");
        msg = StringUtils.stripEnd(msg,"#");
        msg = StringUtils.stripEnd(msg,",");
        System.out.println(msg);
    }


    @Test
    public void ordinalIndexOfTest(){
        String content = "aabaabaa";
        String regex = "b";
        int ordinal = 2;
        int index = StringUtils.ordinalIndexOf(content, regex, ordinal);
        log.info("字符串:{}中第{}次出现符号:{} 的下标是:{}", content, ordinal, regex, index);
    }

    @Test
    public void countMatchesTest(){
        String content = "aabaabaa";
        String regex = "a";
        int ordinal = StringUtils.countMatches(content, regex);
        log.info("字符串:{}中出现符号:{} 的次数是:{}", content, regex, ordinal);
    }


    @Test
    public void splitTest(){
        String content = "aa.bb.cc.dd";
        //与String自带的split方法比，StringUtil中的split方法分隔符不用转义
        String[] array = StringUtils.split(content,".");
        System.out.println(array.length);


        String msg = "10c,000,001,001,010,,,,010,,";
        //StringUtils.split对空字符串""会进行过滤
        String[] msgArr = StringUtils.split(msg,",");
        System.out.println(msgArr.length);
    }


    @Test
    public void joinTest(){
        String[] array = new String[]{"a", "b", "c"};
        String a = StringUtils.join(array, "-");
        System.out.println(a);
    }

    @Test
    public void subStringBetweenTest(){
        //截取101与|之间的值
        String loginMsg = "*7c|a3|106,201|101,963070011618433|102,460079241205511|104,otu.ost,01022300|105,a1,18|622,a1c2|";
        String imei = StringUtils.substringBetween(loginMsg,"|101,", "|");
        System.out.println(imei);
    }

    @Test
    public void centerTest(){
        String title = "Menu";
        String decoratedTitle = StringUtils.center(title,24, "*");
        System.out.println(decoratedTitle);
    }
}
