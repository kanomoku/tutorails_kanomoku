package designPattern.pattern02_AbstractFactoryDesignPattern.demo1.factory;

import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.basic.Link;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.list.ListLink;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.bean.list.ListTray;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.factory.basic.IFactory;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.page.ListPage;
import designPattern.pattern02_AbstractFactoryDesignPattern.demo1.page.basic.Page;

public class ListFactory implements IFactory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    public Page createPage(String path, String title, String author) {
        return new ListPage(path, title, author);
    }
}
