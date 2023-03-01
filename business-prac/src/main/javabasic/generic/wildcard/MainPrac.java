package generic.wildcard;

public class MainPrac {
    public static void main(String[] args) {
        Message<String> msg1 = new Message();
        msg1.setMessage("hello world");
        fun(msg1);// hello world

        Message<Integer> msg2 = new Message();
        msg2.setMessage(100);
        fun(msg2);// 100
    }

    public static void fun(Message<?> temp) {
        System.out.println(temp.getMessage());
    }
}
