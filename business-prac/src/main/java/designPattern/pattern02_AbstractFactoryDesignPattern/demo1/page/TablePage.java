package designPattern.pattern02_AbstractFactoryDesignPattern.demo1.page;

import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.page.basic.Page;

public class TablePage extends Page {
    public TablePage(String path, String title, String author) {
        super(path, title, author);
    }

    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>").append("\n");

        sb.append("<head>").append("\n");
        sb.append("<title>").append(title).append("</title>").append("\n");
        sb.append("</head>").append("\n");

        sb.append("<body>").append("\n");

        sb.append("<h1>" + title + "</h1>").append("\n");

        sb.append("<table width=\"80%\" border=\"3\">\n");
        for (Item item : content) {
            sb.append("<tr>" + item.makeHTML() + "</tr>");
        }
        sb.append("</table>").append("\n");

        sb.append("<hr>");

        sb.append("<address>").append(author).append("</address>").append("\n");

        sb.append("</body>").append("\n");
        sb.append("</html>").append("\n");
        return sb.toString();
    }
}
