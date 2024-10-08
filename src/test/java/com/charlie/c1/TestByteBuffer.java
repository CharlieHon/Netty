package com.charlie.c1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ByteBuffer读写数据演示
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        // FileChannel
        // 1. 输入输出流 2. RandomAccessFile
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 准备缓冲区，分配10byte空间
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 从channel读取数据，向缓冲区 buffer 写
                int len = channel.read(buffer); // 返回读取到的字节数
                log.debug("读取到的字节数 {}", len);
                if (len == -1) {                // -1表示没有内容
                    break;
                }

                // 打印 buffer 的内容
                buffer.flip();  // 切换至读模式
                while (buffer.hasRemaining()) { // 是否还有剩余未读数据
                    byte b = buffer.get();      // 一个字节一个字节的取数据
                    log.debug("实际字节 {}", (char) b);
                }
                buffer.clear(); // 切换为写模式
            }
        } catch (IOException e) {
        }
    }
}
