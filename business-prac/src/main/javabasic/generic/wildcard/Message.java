package generic.wildcard;

class Message<T> {
    private T message;
    public T getMessage() {
        return message;
    }
    public void setMessage(T message) {
        this.message = message;
    }

    public static void fun(Message<?> temp) {
        System.out.println(temp.getMessage());
    }

    public static void main(String[] args) {
        Message<String> msg1 = new Message();
        msg1.setMessage("hello world");
        fun(msg1);// hello world

        Message<Integer> msg2 = new Message();
        msg2.setMessage(100);
        fun(msg2);// 100
    }
}
