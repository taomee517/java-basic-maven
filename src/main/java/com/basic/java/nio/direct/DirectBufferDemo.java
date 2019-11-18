package com.basic.java.nio.direct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 直接内存缓冲区案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\12 0012 11:18
 * @Desc
 * 一、Channel 通道：用于源节点与目标节点的连接，在JAVA NIO中负责对缓冲数据的传输，
 *     Channel本身不存储任何数据，需配合缓冲区进行传输;
 * 二、通道的主要实现类：
 *     java.nio.channels.Channel接口
 *          |-- FileChannel
 *          |-- SocketChannel
 *          |-- ServerSocketChannel
 *          |-- DatagramChannel
 * 三、获取通道：
 *      1.Java针对支持Channel的类提供了getChannel()方法：
 *          本地IO:
 *              FileInputStream/FileOutputStream
 *              RandomAccessFile
 *          网络IO:
 *              Socket
 *              ServerSocket
 *              DatagramSocket
 *      2.JDK1.7以后的NIO为各个通道提借了静态方法open()
 *      3.JDK1.7以后的NIO的Files工具类的newByteChannel()方法
 * 四、通道之间的数据传输：
 *      transferFrom()
 *      transferTo()
 */
public class DirectBufferDemo {
    public static void main(String[] args){
        try(FileChannel inChannel = FileChannel.open(Paths.get("E:\\迅雷下载\\pandora.rmvb"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\迅雷下载\\2.rmvb"),StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)){
//            inChannel.transferTo(0,inChannel.size(),outChannel);
            MappedByteBuffer inByteBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
            MappedByteBuffer outByteBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
            byte[] buf = new byte[(int)inChannel.size()];
            inByteBuf.get(buf);
            outByteBuf.put(buf);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class CommonBuffer{
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream(new File("E:\\迅雷下载\\pandora.rmvb"));
            FileOutputStream fos = new FileOutputStream(new File("E:\\迅雷下载\\2.rmvb"));
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel()){
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf)>0){
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
