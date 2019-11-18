package com.basic.java.file;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownload {
    public static void main(String[] args) {
        try {
            String src = "https://images2018.cnblogs.com/blog/946454/201802/946454-20180223152829583-1999662462.png";
            String alt = "pconline";
            URL url = new URL(src);
            DataInputStream dis = new DataInputStream(url.openStream());

            File f = new File("E:\\private\\spider\\img\\pconline\\" + alt + ".jpg");
            if(!f.exists()){
                f.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(f);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dis.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fos.write(output.toByteArray());
            fos.close();
            dis.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
