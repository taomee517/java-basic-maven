package com.basic.java.nio.cs;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Nio聊天室案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\12 0012 13:44
 */
public class NioChatServer {
    public static void main(String[] args) throws Exception{
        //1.获取Channel
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //2.设置channel为非阻塞
        ssChannel.configureBlocking(false);

        //3.绑定到固定端口
        ssChannel.bind(new InetSocketAddress(8001));

        //4.获取Selector
        Selector selector = Selector.open();

        //5.将Channel注册到Selector上,关注接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select()>0){
//            //6.获取所有selectionKey
            Set<SelectionKey> selectionkeys = selector.selectedKeys();

            //7.获取selectionKey集合的迭代器
            Iterator<SelectionKey> iterator = selectionkeys.iterator();

            while (iterator.hasNext()){
                //8.遍历selectionKey集合
                SelectionKey selectionKey = iterator.next();

                //9.处理准备就绪的可接收通道
                if(selectionKey.isAcceptable()){

                    //10.获取客户端SocketChannel
                    SocketChannel socketChannel = ssChannel.accept();

                    //11.设置通道为非阻塞
                    socketChannel.configureBlocking(false);

                    //12.将客户端socketChannel注册到Selector,并关注可读事件
                    socketChannel.register(selector,SelectionKey.OP_READ);

                    //13.处理准备就绪的可读通道
                }else if(selectionKey.isReadable()){

                    //14.获取通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    //15.分配缓冲区
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    //16.获取客户端发送的消息
                    int len = 0;
                    while((len = socketChannel.read(buf))>0){
                        buf.flip();
                        System.out.println("收到客户端消息：" + new String(buf.array(),0,len));
                        buf.clear();
                    }
                    //回复时间
                    ByteBuffer resp = ByteBuffer.allocate(1024);
                    resp.put((new Date().toString() + '\n').getBytes());
                    resp.flip();
                    socketChannel.write(resp);
                }
                //17.从迭代器中清除selectionKey
                iterator.remove();
            }

        }
    }
}
