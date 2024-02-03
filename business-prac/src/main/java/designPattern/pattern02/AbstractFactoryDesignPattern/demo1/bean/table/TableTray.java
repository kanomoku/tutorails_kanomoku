package designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.table;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<td>").append("\n");
        sb.append("<table width=\"100%\" border=\"1\">");

        sb.append("<tr>").append("\n");
        sb.append("<td color=\"#cccccc\" align=\"center\" colspan=\"").append(trayList.size()).append("\"><b>").append(caption).append("</b></td>");
        sb.append("</tr>").append("\n");
        sb.append("<tr>").append("\n");
        for (Item item : trayList) {
            sb.append(item.makeHTML());
        }
        sb.append("</tr>");

        sb.append("</table>").append("\n");
        sb.append("</td>");
        return sb.toString();
    }
}
