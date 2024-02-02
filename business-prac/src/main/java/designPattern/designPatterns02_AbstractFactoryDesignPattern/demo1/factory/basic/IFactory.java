package designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.factory.basic;

import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.Link;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.page.basic.Page;

public interface IFactory {

    Link createLink(String caption, String url);

    Tray createTray(String caption);

    Page createPage(String path, String title, String author);
}
