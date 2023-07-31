package designPattern.designPatterns01_FactoryDesignPattern;

public class B14_AbstractFactoryMainTest {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main designPatterns1_FactoryDesignPattern.B6_ListFactory");
            System.out.println("Example 2: java Main designPatterns1_FactoryDesignPattern.B10_TableFactory");
            System.exit(0);
        }
        B05_Factory factory = B05_Factory.getFactory(args[0]);

        B02_Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        B02_Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

        B02_Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        B02_Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        B02_Link excite = factory.createLink("Excite", "http://www.excite.com/");
        B02_Link google = factory.createLink("Google", "http://www.google.com/");

        B03_Tray traynews = factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        B03_Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        B03_Tray traysearch = factory.createTray("检索引擎");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        B04_Page page = factory.createPage("PageTitle", "作者");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
