package designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;

import java.util.ArrayList;
import java.util.List;

//  托盘类：要有标题和托盘容器
public abstract class Tray extends Item {
    protected List<Item> trayList = new ArrayList<>();
    protected Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        trayList.add(item);
    }
}
