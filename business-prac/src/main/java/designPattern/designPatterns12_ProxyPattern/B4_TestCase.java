package designPattern.designPatterns12_ProxyPattern;

import org.junit.Test;

public class B4_TestCase {

	@Test
	public void test1() {
		B1_SmsService smsService = new B2_SmsServiceImpl();
		B3_SmsProxy smsProxy = new B3_SmsProxy(smsService);
		smsProxy.send("java");
	}
}
