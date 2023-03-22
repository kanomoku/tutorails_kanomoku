package io.io_bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = null;
        int port = 0;
        if (args.length > 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        } else {
            host = "127.0.0.1";
            port = 9998;
        }

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        Scanner s = new Scanner(System.in);
        try {
            // 创建一个sorket包括IP+端口
            socket = new Socket(host, port);
            String message = null;

            // 用sorket建立两个读写流
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            writer = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                message = s.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                // 把数据发到服务器
                writer.println(message);
                writer.flush();
                // 读一下服务器返回的消息
                System.out.println(reader.readLine());
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
