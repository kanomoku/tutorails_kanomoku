package designPattern.pattern02.AbstractFactoryDesignPattern.demo1;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.Link;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.Tray;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.factory.TableFactory;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.factory.basic.IFactory;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo1.page.basic.Page;

public class Main {
    public static void main(String[] args) {
//        IFactory factory  = new ListFactory();
        IFactory factory = new TableFactory();

        Link people = factory.createLink("People's Daily", "http://www.people.com.cn/");
        Link gmw = factory.createLink("Guangming Daily", "http://www.gmw.cn/");
        Link usYahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jpYahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray trayNews = factory.createTray("Daily News");
        trayNews.add(people);
        trayNews.add(gmw);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(usYahoo);
        trayYahoo.add(jpYahoo);

        Tray traySearch = factory.createTray("Search Engines");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage("D:\\projects\\tutorails_kanomoku\\business-prac\\src\\main\\java\\designPattern\\designPatterns01_FactoryDesignPattern\\demo2", "PageTitle1", "Author");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
