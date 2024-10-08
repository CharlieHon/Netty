package com.charlie.c1;

import java.nio.ByteBuffer;

import static com.charlie.c1.ByteBufferUtil.debugAll;

/**
 * 读取ByteBuffer中的数据
 */
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[] {'a', 'b', 'c', 'd'});
        buffer.flip();  // 设置为读模式！

        // rewind从头开始读
        //buffer.get(new byte[4]);
        //debugAll(buffer);
        //buffer.rewind();    // position = 0，从头再读
        //System.out.println((char) buffer.get());    // a

        // mark & reset
        // mark 做一个标记，记录 position 位置，reset 是将 position 重置到 mark 的位置
        //System.out.println((char) buffer.get());    // a
        //System.out.println((char) buffer.get());    // b
        //buffer.mark();  // 记录当前position的位置
        //System.out.println((char) buffer.get());    // c
        //System.out.println((char) buffer.get());    // d
        //buffer.reset(); // 将 position 重置到索引 2(mark)
        //System.out.println((char) buffer.get());    // c
        //System.out.println((char) buffer.get());    // d

        // get(i)，拿个position=i处的数据，不会改变position位置
        System.out.println((char) buffer.get(3));   // d
        debugAll(buffer);
    }
}
