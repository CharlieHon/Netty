package com.charlie.c1;

import java.nio.ByteBuffer;

import static com.charlie.c1.ByteBufferUtil.debugAll;

/**
 * 粘包/半包处理
 */
public class TestByteBufferExam {
    public static void main(String[] args) {
        /*
        网络上有多条数据发送给服务器，数据之间使用 \n 进行分割
        但由于某种原因导致这些数据在接收时，被进行了重新组合，例如原始数据有3条为
            Hello,world\n
            I'm Charlie\n
            How are you?\n
         变成了下面的两个 byteBuffer (粘包、半包)
            Hello,world\nI'm Charlie\nHo
            w are you?\n
         现在要求编写程序，将错乱的数据恢复成原始的按 \n 分割的数据
         */
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm Charlie\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    public static void split(ByteBuffer source) {
        source.flip();

        for (int i = 0; i < source.limit(); i++) {
            // 找到一条信息
            if (source.get(i) == '\n') {
                // 数据长度 = limit + 1 - position
                int length = i + 1 - source.position();
                // 把这条完整消息存入新的 ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从 source 读，向 target 写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }

        source.compact();
    }
}
