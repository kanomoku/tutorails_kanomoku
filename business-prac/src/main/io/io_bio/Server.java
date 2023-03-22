package io.io_bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) {

        // 模拟获取端口号
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 9998;

        ServerSocket serverSocket = null;

        try {
            // 在服务端启动一个 ServerSocket 来监听网络请求
            serverSocket = new ServerSocket(port);
            System.out.println("server started!");

            // 一直保持监听状态
            while (true) {
                // 获取到客户端的网络请求
                Socket socket = serverSocket.accept();
                // 创建一个线程来处理客户端的网络请求
                new Thread(new Handler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            serverSocket = null;
        }
    }

    static class Handler implements Runnable {
        Socket socket = null;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;
            try {
                // 用sorket建立两个读写流
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));


                String readMessage = null;
                while (true) {
                    System.out.println("server reading... ");
                    if ((readMessage = reader.readLine()) == null) {
                        break;
                    }
                    System.out.println(readMessage);

                    // 把数据发到客户端
                    writer.println("server receive : " + readMessage);
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                socket = null;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                reader = null;
                if (writer != null) {
                    writer.close();
                }
                writer = null;
            }
        }
    }
}
