package designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.table;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.Link;

public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }

    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<td>").append("\n");
        sb.append(String.format("<a href=\"%s\">%s</a>", url, caption));
        sb.append("</td>").append("\n");
        return sb.toString();
    }
}
