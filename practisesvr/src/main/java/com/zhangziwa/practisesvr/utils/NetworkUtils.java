package com.zhangziwa.practisesvr.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.*;
import java.util.Enumeration;

public class NetworkUtils {
    public static void main(String[] args) throws SocketException, UnknownHostException {
//        getIPV4InetAddress();
        InetAddress localHostAddress = getLocalHostAddress();
        System.out.println(localHostAddress.getHostAddress());
    }

    // -----------------------------------------判断----------------------------
    // 校验URL
    public boolean checkUrl(String urlStr) {
        if (StringUtils.isBlank(urlStr)) {
            return false;
        }
        try {
            URL url = new URL(urlStr);
            // 限制协议
            if (!url.getProtocol().startsWith("http") && !url.getProtocol().startsWith("https")) {
                return false;
            }
            // 限制环回地址
            InetAddress inetAddress = InetAddress.getByName(url.getHost());
            if (inetAddress.isLoopbackAddress()) {
                return false;
            }
        } catch (MalformedURLException | UnknownHostException e) {
            return false;
        }
        return true;
    }

    // -----------------------------------------查----------------------------
    // 获得本机的所有IPV4网络IP
    public static void getIPV4InetAddress() throws SocketException {
        // 获得本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();

        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();

            // 获得与该网络接口绑定的 IP 地址,一般只有一个
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();

                // 只关心 IPv4 地址
                if (addr instanceof Inet4Address) {
                    System.out.println("网卡接口名称：" + nif.getName());
                    System.out.println("网卡接口地址：" + addr.getHostAddress());
                }
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


    // 获取 host
    public String getHost(String urlStr) {
        try {
            URI uri = new URI(urlStr);
            return uri.getHost();
        } catch (URISyntaxException e) {
            // log
        }
        return "";
    }


    // 获取 端口号
    public int getPort(String urlStr) {
        try {
            URI uri = new URI(urlStr);
            int port = uri.getPort();
            if (port == -1) {
                return 80;
            }
            return port;
        } catch (URISyntaxException e) {
            // log
        }
        return -1;
    }
}