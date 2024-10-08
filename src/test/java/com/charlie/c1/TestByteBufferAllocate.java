package com.charlie.c1;

import java.nio.ByteBuffer;

/**
 * allocate/allocateDirect
 */
public class TestByteBufferAllocate {
    public static void main(String[] args) {
        // class java.nio.HeapByteBuffer - java堆内存，读写效率较低，受到 GC 影响
        System.out.println(ByteBuffer.allocate(16).getClass());
        // class java.nio.DirectByteBuffer - 直接内存，读写效率高（少一次数据拷贝），分配效率低，系统内存不受GC影响
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
    }
}
