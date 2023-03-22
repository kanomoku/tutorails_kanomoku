package io.io_nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 
 * Buffer的应用固定逻辑 写操作顺序 1. clear() 2. put() -> 写操作 3. flip() -> 重置游标 4. SocketChannel.write(buffer); -> 将缓存数据发送到网络的另一端
 * 5.clear()
 * 
 * 读操作顺序 1. clear() 2. SocketChannel.read(buffer); -> 从网络中读取数据 3. buffer.flip() -> 重置游标 4. buffer.get() -> 读取数据
 * 5.buffer.clear()
 *
 */
public class TestBuffer {
    public static void main(String[] args) throws Exception {

    }

    /**
     * position limit capacity pos - 游标位置， lim - 限制数量， cap - 最大容量 flip 是重置游标 : lim = pos (把 pos 赋值给 lim) ; pos = 0;
     * 我理解就是为取值做准备; remaining = lim - pos
     *
     */
    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(8);

        byte[] temp = new byte[] {3, 2, 1};

        // position limit capacity
        // pos - 游标位置， lim - 限制数量， cap - 最大容量
        // flip 是重置游标 : lim = pos (把 pos 赋值给 lim) ; pos = 0; 我理解就是为取值做准备;
        // remaining = lim - pos

        // 写入数据之前 ： java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
        System.out.println("写入数据之前 ： " + buffer);

        // 写入字节数组到缓存
        buffer.put(temp);

        // 写入数据之后 ： java.nio.HeapByteBuffer[pos=3 lim=8 cap=8]
        System.out.println("写入数据之后 ： " + buffer);

        // 重置游标
        buffer.flip();

        // 重置游标之后 ： java.nio.HeapByteBuffer[pos=0 lim=3 cap=8]
        System.out.println("重置游标之后 ： " + buffer);

        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
    }

    @Test
    public void test2() {
        ByteBuffer buffer = ByteBuffer.allocate(8);

        byte[] temp = new byte[] {3, 2, 1};

        // 写入数据之前 ： java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
        System.out.println("写入数据之前 ： " + buffer);
        buffer.put(temp);
        // 写入数据之后 ： java.nio.HeapByteBuffer[pos=3 lim=8 cap=8]
        System.out.println("写入数据之后 ： " + buffer);

        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
    }

    @Test
    public void test3() {
        ByteBuffer buffer = ByteBuffer.allocate(8);

        byte[] temp = new byte[] {3, 2, 1};
        System.out.println("写入数据之前 ： " + buffer);

        buffer.put(temp);
        System.out.println("写入数据之后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
        System.out.println("-------- ");

        buffer.flip();
        System.out.println("flip 后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
        System.out.println("-------- ");

        System.out.println(buffer.get());
        System.out.println("get 后 ： " + buffer);
        System.out.println("-------- ");
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
    }

    @Test
    public void test4() {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        byte[] temp = new byte[] {3, 2, 1};
        System.out.println("写入数据之前 ： " + buffer);
        buffer.put(temp);
        System.out.println("写入数据之后 ： " + buffer);

        buffer.flip();
        buffer.flip();

        System.out.println(buffer.get());
    }

    @Test
    public void test5() {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        byte[] temp = new byte[] {3, 2, 1};
        System.out.println("写入数据之前 ： " + buffer);
        buffer.put(temp);
        System.out.println("写入数据之后 ： " + buffer);

        buffer.flip();
        System.out.println("写入数据之后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
        System.out.println("-----------");

        buffer.clear();
        System.out.println("写入数据之后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
        // System.out.println(buffer.get());
        System.out.println("-----------");

        buffer.put((byte)10);
        System.out.println("写入数据之后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }

        System.out.println("-----------");

        buffer.put((byte)11);
        System.out.println("写入数据之后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }

        buffer.put((byte)12);
        buffer.put((byte)13);
        System.out.println("写入数据之后 ： " + buffer);
        for (int i = 0; i < buffer.remaining(); i++) {
            int data = buffer.get(i);
            System.out.println(i + " - " + data);
        }
    }
}
