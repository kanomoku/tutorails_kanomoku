package designPattern.pattern02_AbstractFactoryDesignPattern.demo1.page;

import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.page.basic.Page;

public class ListPage extends Page {
    public ListPage(String path, String title, String author) {
        super(path, title, author);
    }

    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>").append("\n");

        sb.append("<head>").append("\n");
        sb.append("<title>").append(title).append("</title>").append("\n");
        sb.append("</head>").append("\n");

        sb.append("<body>").append("\n");

        sb.append("<h1>").append(title).append("</h1>").append("\n");

        sb.append("<ul>").append("\n");
        for (Item item : content) {
            sb.append(item.makeHTML() + "\n");
        }
        sb.append("</ul>").append("\n");

        sb.append("<hr>");

        sb.append("<address>").append(author).append("</address>").append("\n");

        sb.append("</body>").append("\n");
        sb.append("</html>").append("\n");
        return sb.toString();
    }
}
