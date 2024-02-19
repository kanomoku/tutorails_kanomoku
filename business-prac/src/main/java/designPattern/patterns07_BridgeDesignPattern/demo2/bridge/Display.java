package designPattern.patterns07_BridgeDesignPattern.demo2.bridge;

import designPattern.patterns07_BridgeDesignPattern.demo2.interfaces.IPrint;

public class Display {
    private IPrint impl;

    public Display(IPrint impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
