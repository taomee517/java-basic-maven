package com.basic.java.io;

import java.io.*;

/**
 * io流操作案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\8 0008 20:39
 */
public class StreamDemo {
    public static void main(String[] args) {
        //1.创建源
        File file = new File("demo.txt");
        InputStream in = null;
        try {
            //2.选择流
            in = new FileInputStream(file);
            //3.操作流
            while (true){
                int b = in.read();
                if(b<0){
                    break;
                }
                System.out.print((char)b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }finally {
            //4.释放流
            try {
                if(null != in){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
