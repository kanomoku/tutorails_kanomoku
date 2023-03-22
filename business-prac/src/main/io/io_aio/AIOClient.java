package io.io_aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class AIOClient {

    private AsynchronousSocketChannel channel;

    public AIOClient(String host, int port) {
        init(host, port);
    }

    // public static void main(String[] args) {
    // AIOClient client = new AIOClient("localhost", 9999);
    // try {
    // System.out.print("enter message send to server > ");
    // Scanner s = new Scanner(System.in);
    // String line = s.nextLine();
    // client.write(line);
    // client.read();
    // } finally {
    // client.doDestory();
    // }
    // }

    private void init(String host, int port) {
        try {
            // 开启通道
            channel = AsynchronousSocketChannel.open();
            // 发起请求，建立连接。
            channel.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            // read方法是异步方法，具体实现由OS实现; get方法是一个阻塞方法，会等待OS处理结束后再返回。
            channel.read(buffer).get();
            // channel.read(dst, attachment, handler);
            buffer.flip();
            System.out.println("from server : " + new String(buffer.array(), StandardCharsets.UTF_8));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(String line) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(line.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        channel.write(buffer);
    }

    public void doDestroy() {
        if (null != channel) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
