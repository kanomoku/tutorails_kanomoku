package thread.xiancheng_method;

public class volatile_ extends Thread{
    //volatile，这个关键字用于使exit线程同步安全，也就是说在同一时刻只能有一个线程修改exit的值，在exit为true时，while循环退出。
    public volatile  boolean exit = false;
    public void run (){
        while (!exit){
            //执行业务代码逻辑
        }
    }
}
