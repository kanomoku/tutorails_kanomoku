package designPattern.patterns07_BridgeDesignPattern.demo2.extend;

import designPattern.patterns07_BridgeDesignPattern.demo2.bridge.Display;
import designPattern.patterns07_BridgeDesignPattern.demo2.interfaces.IPrint;

public class MultiDisplay extends Display {
    public MultiDisplay(IPrint impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
