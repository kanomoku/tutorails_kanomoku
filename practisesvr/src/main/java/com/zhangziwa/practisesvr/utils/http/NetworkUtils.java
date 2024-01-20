package com.zhangziwa.practisesvr.utils.http;

import lombok.extern.slf4j.Slf4j;

import java.net.*;
import java.util.Enumeration;

@Slf4j
public class NetworkUtils {

    /**
     * 获取本机所有IPv4网络IP地址。
     * <p>
     * 通过遍历本机的所有网络接口，获取与每个接口关联的IP地址，
     * 并筛选出IPv4类型的地址进行输出。对于无法访问或不存在的网络接口，
     * 方法会忽略并继续尝试下一个接口。
     *
     * @throws SocketException 如果在获取网络接口或其IP地址时发生错误
     */
    public static void getLocalIPv4Address() throws SocketException {
        // 获得本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();
            try {
                // 获得与该网络接口绑定的 IP 地址
                Enumeration<InetAddress> addresses = nif.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    // 只关心 IPv4 地址
                    if (addr instanceof Inet4Address) {
                        System.out.printf("网卡接口名称：%s%n", nif.getName());
                        System.out.printf("网卡接口地址：%s%n", addr.getHostAddress());
                    }
                }
            } catch (Exception e) {
                // 如果某个网络接口抛出异常，继续尝试下一个接口
                if (e.getMessage().contains("no such network interface")) {
                    continue;
                }
                throw e; // 如果是其他类型的异常，重新抛出
            }
        }
    }

    // 获取本机IP地址
    // 此方法不管是windows 还是 Linux，亦或开启了vpn与否，都OK
    public static InetAddress getLocalHostAddress() throws SocketException, UnknownHostException {
        InetAddress candidateAddress = null;

        // 获得本机的所有网络接口
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nif = networkInterfaces.nextElement();

            // 获得与该网络接口绑定的IP地址,一般只有一个
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress inetAddr = addresses.nextElement();

                // 排除loopback环回类型地址（不管是IPv4还是IPv6 只要是回环地址isLoopbackAddress都会返回true）
                if (!inetAddr.isLoopbackAddress()) {
                    if (inetAddr.isSiteLocalAddress()) {
                        // 如果是site-local地址，就是它了 就是我们要找的
                        // ~~~~~~~~~~~~~绝大部分情况下都会在此处返回你的ip地址值~~~~~~~~~~~~~
                        return inetAddr;
                    }
                    // 若不是site-local地址 那就记录下该地址当作候选
                    if (candidateAddress == null) {
                        candidateAddress = inetAddr;
                    }
                }
            }
        }
        // 如果除了环回地之外无其它地址了，那就回退到原始方案吧
        return candidateAddress == null ? InetAddress.getLocalHost() : candidateAddress;
    }

    private static String printItnetAddress() throws UnknownHostException {
        InetAddress[] inets = InetAddress.getAllByName("www.baidu.com");
        InetAddress inetAddress = inets[0];

        String hostName = inetAddress.getHostName();
        String canonicalHostName = inetAddress.getCanonicalHostName();

        byte[] address = inetAddress.getAddress();
        String hostAddress = inetAddress.getHostAddress();
        return hostName;
    }
}