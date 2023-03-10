package designPattern.designPatterns01_FactoryDesignPattern;

public abstract class B02_Link extends B01_Item {
    protected String url;
    public B02_Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
