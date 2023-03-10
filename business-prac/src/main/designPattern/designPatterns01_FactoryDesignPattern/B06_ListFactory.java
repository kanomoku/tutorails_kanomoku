package designPattern.designPatterns01_FactoryDesignPattern;

public class B06_ListFactory extends B05_Factory {
    public B02_Link createLink(String caption, String url) {
        return new B07_ListLink(caption, url);
    }
    public B03_Tray createTray(String caption) {
        return new B08_ListTray(caption);
    }
    public B04_Page createPage(String title, String author) {
        return new B09_ListPage(title, author);
    }
}
