package com.basic.java.game;

import com.basic.java.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * 游戏窗口1.0版
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\1 0001 13:36
 */
public class GameFrame1 extends JFrame {
    Image plane = GameUtil.getImage("image/战机.png");
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }

    public void launchFrame(){
        this.setTitle("飞机游戏");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(400,400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.drawLine(0,0,200,200);
        g.drawImage(plane,200,200,null);
    }
}
