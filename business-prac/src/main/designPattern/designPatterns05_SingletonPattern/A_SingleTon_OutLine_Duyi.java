package designPattern.designPatterns05_SingletonPattern;

public class A_SingleTon_OutLine_Duyi {
    //通过设计，让这个类只有一个对象

    //每个类都有默认的无参数构造方法---公有的  在外面可以随意创建
    //1.让构造方法变得私有---保证外面不可以随便创建对象
    private A_SingleTon_OutLine_Duyi() {
    }

    //2.单例 不是无例 --- 在本类中药创建一个对象--- 在哪里？---以下四个位置
    // 构造方法：构造方法本身就是创建对象的，没意义
    // 块：是可以SingleTon singleton = new  SingleTon () 但是块没有返回值，创建的对象无法给别人使用
    // 方法：倒是可以return new SingleTon() 每调用一回都会创建一个对象----不满足唯一性
    // 属性：只剩这里了----行不行呢----试试呗----创建一个本类类型的变量
    // public SingleTon single = new SingleTon(); 套娃那样一直产生对象，栈内存溢出--怎么办？--产生一个对象-----变成静态的
    // public static SingleTon single = new SingleTon(); 外面可以有SingleTon.single---这样可以给赋值----这样不安全--变成私有的
    private static A_SingleTon_OutLine_Duyi single = new A_SingleTon_OutLine_Duyi(); //是变成私有的了----但是外面取不到-----增加一个方法

    //public SingleTon getSingelTon(){
    //如何得到方法呢？---由对象调用方法？----先有鸡还是先有蛋的问题-------不用对象就可以引用-----变成类的，变成静态的
    public static A_SingleTon_OutLine_Duyi getSingelTon() { //起名字柜子  get类名 或者 getInstance
        return single; //把存的地址引用给你------返回地址的引用
    }

    //饿汉式 立即加载 程序启动时就加载  不会产生对象没有就拿来使用的问题 避免空指针----不好在于--项目启动时对象过多--有些还没用--产生服务器承载压力的问题
    //懒汉式 延时加载 对象什么时候用到了 才会加载----可能会由于没有操作好出现异常-----项目启动时只有需要的就加载--不需要就到用的时候再加载--线性的渐进的方式--缓解服务器的承载压力
    //生命周期托管 单例对象别人帮我们管理

    //懒汉式：
    private static A_SingleTon_OutLine_Duyi singleton = null;

    public static A_SingleTon_OutLine_Duyi getInstance() {
        if (singleton == null) {
            return singleton = new A_SingleTon_OutLine_Duyi();
        } else {
            return singleton;
        }
    }

    //但是以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例，
    //要实现线程安全，有以下三种方式，都是对getInstance这个方法改造，保证了懒汉式单例的线程安全

    //1、在getInstance方法上加同步
    public static synchronized A_SingleTon_OutLine_Duyi getInstance1() {
        if (singleton == null) {
            singleton = new A_SingleTon_OutLine_Duyi();
        }
        return singleton;
    }

    //2、双重检查锁定
    public static A_SingleTon_OutLine_Duyi getInstance2() {
        if (singleton == null) {
            synchronized (A_SingleTon_OutLine_Duyi.class) {
                if (singleton == null) {
                    singleton = new A_SingleTon_OutLine_Duyi();
                }
            }
        }
        return singleton;
    }

    //3、静态内部类
    private static class LazyHolder {
        private static final A_SingleTon_OutLine_Duyi INSTANCE = new A_SingleTon_OutLine_Duyi();
    }

    public static final A_SingleTon_OutLine_Duyi getInstance3() {
        return LazyHolder.INSTANCE;
    }
//    这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响。
}




