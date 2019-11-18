package com.basic.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 游戏工具类
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\1 0001 16:11
 */
public class GameUtil {
    public static Image getImage(String path){
        BufferedImage bufferedImage = null;
        URL url = GameUtil.class.getClassLoader().getResource(path);
        try {
            bufferedImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}
