package designPattern.designPatterns01_FactoryDesignPattern;

public class B10_TableFactory extends B05_Factory {
    public B02_Link createLink(String caption, String url) {
        return new B11_TableLink(caption, url);
    }
    public B03_Tray createTray(String caption) {
        return new B12_TableTray(caption);
    }
    public B04_Page createPage(String title, String author) {
        return new B13_TablePage(title, author);
    }
}
