package designPattern.patterns06_AdapterDesignPattern.adapter.inheritanceadapter;

import designPattern.patterns06_AdapterDesignPattern.adapter.ISocketAdapter;
import designPattern.patterns06_AdapterDesignPattern.adapter.Socket;
import designPattern.patterns06_AdapterDesignPattern.bean.Volt;

//Using inheritance for adapter pattern
public class SocketInheritanceAdapter extends Socket implements ISocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v, 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVoltValue() / i);
    }
}

