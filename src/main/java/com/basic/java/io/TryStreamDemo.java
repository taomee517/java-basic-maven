package com.basic.java.io;

import java.io.*;

/**
 * io try-resourse案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\8 0008 21:04
 */
public class TryStreamDemo {
    public static void main(String[] args) {
        //1.创建源
        File file = new File("demo.txt");
        //2.选择流 + 4.释放流
        try (InputStream in = new FileInputStream(file)){
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
        }
    }
}
