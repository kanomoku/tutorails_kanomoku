package designPattern.patterns06_AdapterDesignPattern;

import designPattern.patterns06_AdapterDesignPattern.adapter.ISocketAdapter;
import designPattern.patterns06_AdapterDesignPattern.adapter.compositionadapter.SocketCompositionAdapter;
import designPattern.patterns06_AdapterDesignPattern.adapter.inheritanceadapter.SocketInheritanceAdapter;
import designPattern.patterns06_AdapterDesignPattern.bean.Volt;
import org.junit.Test;

public class Main {
    @Test
    public void testObjectAdapter() {
        ISocketAdapter sockAdapter = new SocketCompositionAdapter();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v120 = getVolt(sockAdapter, 120);
        System.out.println("v3 volts using Object Adapter=" + v3.getVoltValue());
        System.out.println("v12 volts using Object Adapter=" + v12.getVoltValue());
        System.out.println("v120 volts using Object Adapter=" + v120.getVoltValue());
    }

    @Test
    public void testClassAdapter() {
        ISocketAdapter sockAdapter = new SocketInheritanceAdapter();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v120 = getVolt(sockAdapter, 120);
        System.out.println("v3 volts using Class Adapter=" + v3.getVoltValue());
        System.out.println("v12 volts using Class Adapter=" + v12.getVoltValue());
        System.out.println("v120 volts using Class Adapter=" + v120.getVoltValue());
    }

    private static Volt getVolt(ISocketAdapter sockAdapter, int i) {
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
