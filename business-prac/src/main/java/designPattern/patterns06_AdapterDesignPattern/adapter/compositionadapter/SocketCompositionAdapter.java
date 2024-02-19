package designPattern.patterns06_AdapterDesignPattern.adapter.compositionadapter;

import designPattern.patterns06_AdapterDesignPattern.adapter.ISocketAdapter;
import designPattern.patterns06_AdapterDesignPattern.adapter.Socket;
import designPattern.patterns06_AdapterDesignPattern.bean.Volt;

public class SocketCompositionAdapter implements ISocketAdapter {

	//Using Composition for adapter pattern
	private final Socket sock = new Socket();
	
	@Override
	public Volt get120Volt() {
		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v= sock.getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volt get3Volt() {
		Volt v= sock.getVolt();
		return convertVolt(v,40);
	}
	
	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVoltValue()/i);
	}
}

