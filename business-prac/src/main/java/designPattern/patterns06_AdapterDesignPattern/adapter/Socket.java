package designPattern.patterns06_AdapterDesignPattern.adapter;

import designPattern.patterns06_AdapterDesignPattern.bean.Volt;

public class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}

