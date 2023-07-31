package designPattern.designPatterns07_BridgeDesignPattern;
public class B2_CountDisplay extends B1_Display {
    public B2_CountDisplay(B3_DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(int times) {       // 循环显示times次
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
