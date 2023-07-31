package designPattern.designPatterns06_AdapterDesignPattern;

import org.junit.Test;

public class A6_AdapterPatternTest {

	public static void main(String[] args) {

	}

	@Test
	public void testObjectAdapter() {
		A3_SocketAdapter sockAdapter = new A5_SocketObjectAdapterImpl();
		A1_Volt v3 = getVolt(sockAdapter, 3);
		A1_Volt v12 = getVolt(sockAdapter, 12);
		A1_Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Object Adapter=" + v3.getVolts());
		System.out.println("v12 volts using Object Adapter=" + v12.getVolts());
		System.out.println("v120 volts using Object Adapter=" + v120.getVolts());
	}
	@Test
	public void testClassAdapter() {
		A3_SocketAdapter sockAdapter = new A4_SocketClassAdapterImpl();
		A1_Volt v3 = getVolt(sockAdapter, 3);
		A1_Volt v12 = getVolt(sockAdapter, 12);
		A1_Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Class Adapter=" + v3.getVolts());
		System.out.println("v12 volts using Class Adapter=" + v12.getVolts());
		System.out.println("v120 volts using Class Adapter=" + v120.getVolts());
	}
	private static A1_Volt getVolt(A3_SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}
}
