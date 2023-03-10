package designPattern.designPatterns01_FactoryDesignPattern;

public abstract class B05_Factory {
    public static B05_Factory getFactory(String classname) {
        B05_Factory factory = null;
        try {
            factory = (B05_Factory)Class.forName(classname).newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("没有找到 " + classname + "类。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
    public abstract B02_Link createLink(String caption, String url);
    public abstract B03_Tray createTray(String caption);
    public abstract B04_Page createPage(String title, String author);
}
