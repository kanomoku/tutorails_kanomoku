package designPattern.designPatterns01_FactoryDesignPattern;
import java.util.ArrayList;

public abstract class B03_Tray extends B01_Item {
    protected ArrayList tray = new ArrayList();
    public B03_Tray(String caption) {
        super(caption);
    }
    public void add(B01_Item item) {
        tray.add(item);
    }
}
