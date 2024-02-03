package designPattern.pattern02.AbstractFactoryDesignPattern.demo1.bean.basic.rule;

// 所有项目都要有标题
public abstract class Item implements IHtml {
    protected String caption;

    protected Item(String caption) {
        this.caption = caption;
    }
}
