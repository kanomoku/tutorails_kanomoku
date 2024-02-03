package designPattern.pattern02.AbstractFactoryDesignPattern.demo1.factory.basic;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.Link;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.page.basic.Page;

public interface IFactory {

    Link createLink(String caption, String url);

    Tray createTray(String caption);

    Page createPage(String path, String title, String author);
}
