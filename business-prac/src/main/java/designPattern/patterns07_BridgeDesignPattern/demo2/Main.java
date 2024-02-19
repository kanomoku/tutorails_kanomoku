package designPattern.patterns07_BridgeDesignPattern.demo2;

import designPattern.patterns07_BridgeDesignPattern.demo2.bridge.Display;
import designPattern.patterns07_BridgeDesignPattern.demo2.extend.MultiDisplay;
import designPattern.patterns07_BridgeDesignPattern.demo2.interfaces.StringPrintImpl;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringPrintImpl("Hello, China."));
        Display d2 = new MultiDisplay(new StringPrintImpl("Hello, World."));
        MultiDisplay d3 = new MultiDisplay(new StringPrintImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
