package com.basic.java.innerclass;

/**
 * 内部类测试
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 10:16
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerShow();
        System.out.println("###########################");
        Outer.InnerB innerB = new Outer.InnerB();
        innerB.innerShow();
    }
}

class Outer{
    int age = 10;
    public void outShow(){
        System.out.println("我是外部类，age =" + age);
    }
    class Inner{
        int age = 20;
        public void innerShow(){
            int age = 30;
            System.out.println("外部类的年纪：" + Outer.this.age);
            System.out.println("内部类Inner的年纪：" + this.age);
            System.out.println("内部类Inner局部变量-年纪：" + age);
        }
    }
    static class InnerB{
        int age = 40;
        public void innerShow(){
            int age = 50;
            Outer outer = new Outer();
            System.out.println("外部类的年纪：" + outer.age);
            System.out.println("内部类InnerB的年纪：" + this.age);
            System.out.println("内部类InnerB局部变量-年纪：" + age);
        }
    }
}