package designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.list;

import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>").append("\n");
        sb.append(caption).append("\n");

        sb.append("<ul>").append("\n");
        for (Item item : trayList) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>").append("\n");

        sb.append("</li>").append("\n");
        return sb.toString();
    }
}
