package com.charlie.c1;

import java.nio.ByteBuffer;

import static com.charlie.c1.ByteBufferUtil.debugAll;

/**
 * 向ByteBuffer中写数据
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61);    // 'a'
        debugAll(buffer);
        buffer.put(new byte[] {0x62, 0x63, 0x64});  // b c d
        debugAll(buffer);

        // 不切换为读模式，从position开始读一个字节的数据，读不到
        // System.out.println(buffer.get());   // 0
        buffer.flip();  // 切换为读模式
        System.out.println(buffer.get());   // 97
        debugAll(buffer);

        buffer.compact();   // 切换为写模式，将未读取的数据向前压缩
        debugAll(buffer);

        buffer.put(new byte[] {0x65, 0x66});
        debugAll(buffer);
    }
}
