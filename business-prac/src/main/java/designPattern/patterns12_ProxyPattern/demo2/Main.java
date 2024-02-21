package designPattern.patterns12_ProxyPattern.demo2;

import org.junit.Test;

public class Main {

	@Test
	public void test1() {
		IsmsService smsService = new SmsServiceImpl();
		SmsProxy smsProxy = new SmsProxy(smsService);
		smsProxy.send("java");
	}
}
