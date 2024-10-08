package com.charlie.c1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static com.charlie.c1.ByteBufferUtil.debugAll;

/**
 * 字符串与ByteBuffer之间的转换
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        // 1. 字符串转为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("hello".getBytes()); // buffer处于写模式
        debugAll(buffer);

        // 2 Charset    自动切换到读模式
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer2);

        // 3. wrap 同Charset
        ByteBuffer buffer3 = ByteBuffer.wrap("charlie".getBytes());
        debugAll(buffer3);

        // ByteBuffer ---> String
        String str1 = StandardCharsets.UTF_8.decode(buffer3).toString();
        System.out.println(str1);   // charlie

        // 对于法1的buffer，由于没有切换读模式，需要先flip
        buffer.flip();
        String str2 = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(str2);   // hello
    }
}
