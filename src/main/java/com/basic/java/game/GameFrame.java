package com.basic.java.game;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\1 0001 13:28
 */
public class GameFrame extends JFrame {
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


}
