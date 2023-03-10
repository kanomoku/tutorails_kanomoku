package designPattern.designPatterns06_AdapterDesignPattern;

//Using inheritance for adapter pattern
public class A4_SocketClassAdapterImpl extends A2_Socket implements A3_SocketAdapter{

	@Override
	public A1_Volt get120Volt() {
		return getVolt();
	}

	@Override
	public A1_Volt get12Volt() {
		A1_Volt v= getVolt();
		return convertVolt(v,10);
	}

	@Override
	public A1_Volt get3Volt() {
		A1_Volt v= getVolt();
		return convertVolt(v,40);
	}
	
	private A1_Volt convertVolt(A1_Volt v, int i) {
		return new A1_Volt(v.getVolts()/i);
	}
}

