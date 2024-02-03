package designPattern.pattern02.AbstractFactoryDesignPattern.demo1.page.basic;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

//  页面类: 页面标题,作者,页面元素
public abstract class Page {
    protected String path;
    protected String title;
    protected String author;
    protected List<Item> content = new ArrayList<>();

    protected Page(String path, String title, String author) {
        this.path = path;
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        try (Writer writer = new FileWriter(path + "/" + title + ".html")) {
            writer.write(this.makeHTML());
            System.out.println(title + ".html 编写完成。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();
}
