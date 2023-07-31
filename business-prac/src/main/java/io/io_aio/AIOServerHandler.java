package io.io_aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * CompletionHandler<V,A>接口是一种约束
 * CompletionHandler<AsynchronousSocketChannel, AIOServer> 规定了正常执行操作和异常执行操作必须实现，而且规范了参数
 * 传递AIOServer 的主要作用就是 用它里面的 AsynchronousServerSocketChannel
 */
public class AIOServerHandler implements CompletionHandler<AsynchronousSocketChannel, AIOServer> {


    /**
     * 业务处理逻辑：当请求到来后，监听成功以后应该做什么
     * 一定要实现的逻辑： 为下一次客户端请求开启监听。accept方法调用
     * 一开始没搞懂，后来感觉就是这么回事： 你监听到我了，我要处理我的事了，但是你不能闲着，你继续监听你的别管我了；
     *
     * result参数 ： 就是和客户端直接建立关联的通道;无论BIO、NIO、AIO中，一旦连接建立，两端是平等的。
     * result中有通道中的所有相关数据。如：OS操作系统准备好的读取数据缓存，或等待返回数据的缓存
     */
    @Override
    public void completed(AsynchronousSocketChannel result, AIOServer attachment) {
        // AIO开发中，监听是一个类似递归的监听操作。每次监听到客户端请求后，都需要处理逻辑开启下一次的监听;
        // 下一次的监听，需要服务器的资源继续支持。

        // 此写法就是处理下一次的客户端请求
        attachment.getAsynchronousServerSocketChannel().accept(attachment, this);
        doRead(result);
    }

    /**
     * 异常处理逻辑， 当服务端代码出现异常的时候，做什么事情。
     */
    @Override
    public void failed(Throwable exc, AIOServer attachment) {
        exc.printStackTrace();
    }

    private void doRead(final AsynchronousSocketChannel channel) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /*
         * 异步读操作， read(Buffer destination, A attachment, CompletionHandler<Integer, ? super A> handler)
         * destination - 目的地,是处理客户端传递数据的中转缓存,可以不使用。
         * attachment  - 处理客户端传递数据的对象,通俗的说就是客户端传递过来的数据我拿什么数据对象处理;通常使用Buffer处理。
         * handler     - 处理逻辑
         */
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            /**
             * 业务逻辑，读取客户端传输数据
             *
             * result 指的是数据的长度，数据的多少
             * attachment - 在completed方法执行的时候，OS已经将客户端请求的数据写入到Buffer中了。 但是未复位（flip）。 使用前一定要复位。
             */
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("attachment 的容量 : " + attachment.capacity());
                attachment.flip();// 复位
                System.out.println("from client 的内容 : " + new String(attachment.array(), StandardCharsets.UTF_8));

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                System.out.print("enter message send to client > ");
                Scanner s = new Scanner(System.in);
                String line = s.nextLine();
                buffer.put(line.getBytes(StandardCharsets.UTF_8));
                buffer.flip();// 重点：必须复位，必须复位，必须复位
                // write方法是一个异步操作,具体实现由OS实现; 可以增加get方法，实现阻塞，等待OS的写操作结束。
                // channel.write(buffer);
                try {
                    channel.write(buffer).get(); // 调用get代表服务端线程阻塞，等待写操作完成
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }
}
