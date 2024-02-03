package designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.list;

import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.basic.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>").append("\n");
        sb.append(String.format("<a href=\"%s\">%s</a>", url, caption));
        sb.append("</li>").append("\n");
        return sb.toString();
    }
}
