package designPattern.patterns06_AdapterDesignPattern.adapter;

import designPattern.patterns06_AdapterDesignPattern.bean.Volt;

public interface ISocketAdapter {

	public Volt get120Volt();
		
	public Volt get12Volt();
	
	public Volt get3Volt();
}

