package designPattern.patterns12_ProxyPattern.demo2;

public class SmsServiceImpl implements IsmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
