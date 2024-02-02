package designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.factory;

import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.Link;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.table.TableLink;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.table.TableTray;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.factory.basic.IFactory;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.page.TablePage;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.page.basic.Page;

public class TableFactory implements IFactory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    public Page createPage(String path, String title, String author) {
        return new TablePage(path, title, author);
    }
}
