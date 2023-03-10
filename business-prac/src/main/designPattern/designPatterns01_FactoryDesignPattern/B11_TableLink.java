package designPattern.designPatterns01_FactoryDesignPattern;

public class B11_TableLink extends B02_Link {
    public B11_TableLink(String caption, String url) {
        super(caption, url);
    }
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
