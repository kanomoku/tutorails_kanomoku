package designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic;

import designPattern.designPatterns02_AbstractFactoryDesignPattern.demo1.bean.basic.rule.Item;

//  链接类：要有标题和URL
public abstract class Link extends Item {
    protected String url;

    protected Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
