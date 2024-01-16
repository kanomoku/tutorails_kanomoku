package com.zhangziwa.practisesvr.utils.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamIUtils {

    /**
     * 读取输入流并转换为字节数组
     *
     * @param inputStream 输入流
     * @return 转换后的字节数组
     * @throws Exception 抛出异常
     */
    public static byte[] readStream2Bytes(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream, 102400);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 复制流中的数据到输出流，最多复制指定字节数的数据。
     *
     * @param inputStream  输入流，不能为null
     * @param outputStream 输出流，不能为null
     * @param byteCount    最大复制字节数
     * @return 返回复制的总字节数
     * @throws Exception 如果流为空或复制过程中发生异常
     */
    public static int copyStream(InputStream inputStream, OutputStream outputStream, long byteCount) throws Exception {
        // 检查流是否为空
        if (inputStream == null || outputStream == null) {
            throw new IOException("流为空");
        }

        byte[] buffer = new byte[512]; // 这里512可以视情况调整
        int totalSize = 0;
        int count;
        // 使用 try-with-resources 语法来自动关闭流
        try (InputStream input = inputStream; OutputStream output = outputStream) {
            while ((count = input.read(buffer, 0, buffer.length)) != -1) {
                totalSize += count;
                if (totalSize > byteCount) {
                    throw new IOException("超过了最大字节数");
                }
                output.write(buffer, 0, count);
            }
        } // 源代码块会自动关闭输入和输出流

        return totalSize;
    }
}
