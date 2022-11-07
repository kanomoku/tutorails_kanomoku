package thread.threadMethod;

public class Join3_normal_MainTest {
    public static void main(String[] args){
        Join1_One one = new Join1_One();
        Join2_Two two = new Join2_Two();
        one.start();
        two.start();
        //如果这样写的话线程one和线程two是交替执行的,但是不一定谁先启动--所以two线程要在one的run里面创建--这样保证两个有先后顺序
    }
}
