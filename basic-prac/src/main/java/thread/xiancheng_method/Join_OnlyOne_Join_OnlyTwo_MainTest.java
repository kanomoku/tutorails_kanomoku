package thread.xiancheng_method;

public class Join_OnlyOne_Join_OnlyTwo_MainTest {
    public static void main(String[] args){
        Join_OnlyOne one = new Join_OnlyOne();
        Join_OnlyTwo two = new Join_OnlyTwo();
        one.start();
        two.start();
        //如果这样写的话线程one和线程two是交替执行的,但是不一定谁先启动--所以two线程要在one的run里面创建--这样保证两个有先后顺序
    }
}
