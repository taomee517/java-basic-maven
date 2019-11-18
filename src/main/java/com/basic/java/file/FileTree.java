package com.basic.java.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 打印文件树形结构
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 17:05
 */
public class FileTree {
    public static void main(String[] args) {
//        String path = "F:\\NIIT课程\\HTML";
//        String path = "F:\\sql";
        String path = "C:\\Users\\Administrator\\Documents\\WeChat Files\\All Users";
        printAllFile(path);
    }

    public static void printAllFile(File file,int level){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            level++;
            for(int x=0;x<files.length;x++){
                for(int i=0;i<level;i++){
                    System.out.print(" ");
                }
                System.out.print("| - ");
                System.out.println(files[x].getName());
                if(files[x].isDirectory()){
                    printAllFile(files[x],level);
                }
            }
        }else {
            System.out.println(" | - " + file.getName());
        }
    }

    public static void printAllFile(String path){
        File file = new File(path);
        System.out.println(path);
        printAllFile(file,1);
    }
}
