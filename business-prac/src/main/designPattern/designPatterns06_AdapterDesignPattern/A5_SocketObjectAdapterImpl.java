package designPattern.designPatterns06_AdapterDesignPattern;

public class A5_SocketObjectAdapterImpl implements A3_SocketAdapter{

	//Using Composition for adapter pattern
	private A2_Socket sock = new A2_Socket();
	
	@Override
	public A1_Volt get120Volt() {
		return sock.getVolt();
	}

	@Override
	public A1_Volt get12Volt() {
		A1_Volt v= sock.getVolt();
		return convertVolt(v,10);
	}

	@Override
	public A1_Volt get3Volt() {
		A1_Volt v= sock.getVolt();
		return convertVolt(v,40);
	}
	
	private A1_Volt convertVolt(A1_Volt v, int i) {
		return new A1_Volt(v.getVolts()/i);
	}
}

