package designPattern.designPatterns01_FactoryDesignPattern;

public class B07_ListLink extends B02_Link {
    public B07_ListLink(String caption, String url) {
        super(caption, url);
    }
    public String makeHTML() {
        return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
