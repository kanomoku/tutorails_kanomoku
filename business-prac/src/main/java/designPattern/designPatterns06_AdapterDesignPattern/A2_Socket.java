package designPattern.designPatterns06_AdapterDesignPattern;

public class A2_Socket {

	public A1_Volt getVolt(){
		return new A1_Volt(120);
	}
}

