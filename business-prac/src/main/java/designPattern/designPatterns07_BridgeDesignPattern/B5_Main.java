package designPattern.designPatterns07_BridgeDesignPattern;
public class B5_Main {
    public static void main(String[] args) {
        B1_Display d1 = new B1_Display(new B4_StringDisplayImpl("Hello, China."));
        B1_Display d2 = new B2_CountDisplay(new B4_StringDisplayImpl("Hello, World."));
        B2_CountDisplay d3 = new B2_CountDisplay(new B4_StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
