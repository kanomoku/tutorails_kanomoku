package io.bytebuffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class BytebufferPrac {

    @Test
    public void testAllocate() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

    @Test
    public void testPut() {
        IntBuffer byteBuffer = IntBuffer.allocate(8);
        System.out.println(byteBuffer);

        byteBuffer.put(1);
        System.out.println(byteBuffer);

        byteBuffer.put(2);
        System.out.println(byteBuffer);
    }

    @Test
    public void testFlip() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        System.out.println("写入数据之前 ： " + intBuffer); // 写入数据之前 ： java.nio.HeapIntBuffer[pos=0 lim=8 cap=8]

        intBuffer.put(new int[]{3, 2, 1});
        System.out.println("写入数据之后 ： " + intBuffer); // 写入数据之后 ： java.nio.HeapIntBuffer[pos=3 lim=8 cap=8]

        intBuffer.flip();
        System.out.println("重置游标之后 ： " + intBuffer); // 重置游标之后 ： java.nio.HeapIntBuffer[pos=0 lim=3 cap=8]
    }

    @Test
    public void testGet() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();
        System.out.println(intBuffer); // java.nio.HeapIntBuffer[pos=0 lim=3 cap=8]

        for (int i = 0; i < 3; i++) {
            System.out.println(intBuffer.get());
            System.out.println(intBuffer);
        }
        // 3
        // java.nio.HeapIntBuffer[pos=1 lim=3 cap=8]
        // 2
        // java.nio.HeapIntBuffer[pos=2 lim=3 cap=8]
        // 1
        // java.nio.HeapIntBuffer[pos=3 lim=3 cap=8]
    }

    @Test
    public void testRewind() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();

        for (int i = 0; i < 3; i++) {
            System.out.println(intBuffer.get());
        }

        intBuffer.rewind();
        for (int i = 0; i < 3; i++) {
            System.out.println(intBuffer.get());
        }
    }

    @Test
    public void testMarkReset() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();
    }

    @Test
    public void testClear() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();
        System.out.println(intBuffer); // java.nio.HeapIntBuffer[pos=0 lim=3 cap=8]

        intBuffer.clear();
        System.out.println(intBuffer); // java.nio.HeapIntBuffer[pos=0 lim=8 cap=8]
    }

    @Test
    public void testHasRemaining() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();
        System.out.println(intBuffer.hasRemaining());
    }

    @Test
    public void testRemaining() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();

        System.out.println(intBuffer.remaining()); // 3
        System.out.println(intBuffer);             // java.nio.HeapIntBuffer[pos=0 lim=3 cap=8]

        intBuffer.get();

        System.out.println(intBuffer.remaining()); // 2
        System.out.println(intBuffer);             // java.nio.HeapIntBuffer[pos=1 lim=3 cap=8]
    }

    @Test
    public void testCompact() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        intBuffer.put(new int[]{3, 2, 1});
        intBuffer.flip();
        System.out.println(intBuffer);

        intBuffer.get();

        intBuffer.compact();
        System.out.println(intBuffer);
    }
}
