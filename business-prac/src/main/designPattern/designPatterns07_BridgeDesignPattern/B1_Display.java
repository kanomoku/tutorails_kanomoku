package designPattern.designPatterns07_BridgeDesignPattern;
public class B1_Display {
    private B3_DisplayImpl impl;
    public B1_Display(B3_DisplayImpl impl) {
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
