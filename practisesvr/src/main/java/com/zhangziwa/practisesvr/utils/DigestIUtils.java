package com.zhangziwa.practisesvr.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DigestIUtils {
    public static String md5Hex(String originalString) {
        // 需要进行MD5加密的字符串
        originalString = "Hello, World!";

        // 使用DigestUtils.md5Hex方法计算MD5哈希值
        String md5Hash = DigestUtils.md5Hex(originalString);

        // 输出MD5哈希值
        System.out.println("原始字符串: " + originalString); // 原始字符串: Hello, World!
        System.out.println("MD5哈希值: " + md5Hash); // MD5哈希值: 65a8e27d8879283831b664bd8b7f0ad4
        return md5Hash;
    }

    public static String encodeBase64(String originalString) {
        // Base64编码的字符串
        originalString = "Hello, World!";

        // 将字符串转换为字节数组（假设它是UTF-8编码）
        byte[] bytesToEncode = originalString.getBytes(StandardCharsets.UTF_8);
        // 对字节数组进行Base64编码
        String encodedString = Base64.getEncoder().encodeToString(bytesToEncode);

        // 输出Base64编码后的字符串
        System.out.println("原始字符串: " + originalString); // 原始字符串: Hello, World!
        System.out.println("Base64编码后的字符串: " + encodedString); // Base64编码后的字符串: SGVsbG8sIFdvcmxkIQ==
        return encodedString;
    }

    public static String decodeBase64(String encodedString) {
        // Base64编码的字符串
        encodedString = "SGVsbG8sIFdvcmxkIQ==";

        // 获取Base64解码器实例
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        // 将解码后的字节数组转换为字符串（假设它是UTF-8编码）
        String originalString = new String(decodedBytes, StandardCharsets.UTF_8);

        // 输出原始字符串
        System.out.println("Base64解码后的字符串: " + originalString); // Base64解码后的字符串: Hello, World!
        return originalString;
    }
}
