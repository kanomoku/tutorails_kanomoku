package io.io_aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AIOServer {

    // 线程池， 提高服务端效率。
    private ExecutorService service;
    // 线程组
    // private AsynchronousChannelGroup group;

    // 服务端通道， 针对服务器端定义的通道。
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AIOServer(int port) {
        init(9999);
    }

    public static void main(String[] args) {
        new AIOServer(9999);
    }

    private void init(int port) {
        try {
            System.out.println("server starting at port : " + port + " ...");

            // 设置一个定长线程池
            service = Executors.newFixedThreadPool(4);

//            // 使用线程组
//            group = AsynchronousChannelGroup.withThreadPool(service);
//            serverChannel = AsynchronousServerSocketChannel.open(group);


            // 开启服务端通道,通过静态方法创建的
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            // 服务器启动成功,但是未监听请求,这里绑定监听端口
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("server started.");
            // 开始监听
            // accept(T attachment, CompletionHandler<AsynchronousSocketChannel, ? super T>)
            // 我理解的是：通道 + 服务 + 处理 --> 在通道里 用服务去做处理
            asynchronousServerSocketChannel.accept(this, new AIOServerHandler());
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ExecutorService getService() {
        return service;
    }

    public void setService(ExecutorService service) {
        this.service = service;
    }

    public AsynchronousServerSocketChannel getAsynchronousServerSocketChannel() {
        return asynchronousServerSocketChannel;
    }

    public void setAsynchronousServerSocketChannel(AsynchronousServerSocketChannel asynchronousServerSocketChannel) {
        this.asynchronousServerSocketChannel = asynchronousServerSocketChannel;
    }
}
