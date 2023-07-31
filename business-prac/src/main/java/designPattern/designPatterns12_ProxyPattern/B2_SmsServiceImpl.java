package designPattern.designPatterns12_ProxyPattern;

public class B2_SmsServiceImpl implements B1_SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
