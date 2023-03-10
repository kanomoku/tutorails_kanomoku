package designPattern.designPatterns12_ProxyPattern;

public class B3_SmsProxy implements B1_SmsService {

    private final B1_SmsService smsService;

    public B3_SmsProxy(B1_SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作，多用于日志记录
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作，多用于日志记录
        System.out.println("after method send()");
        return null;
    }
}
