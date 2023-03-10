package designPattern.designPatterns12_ProxyPattern;

import org.junit.Test;

public class A4_ProxyPatternTest {

	@Test
	public void test1() {
		A1_CommandExecutor executor = new A3_CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}
}
