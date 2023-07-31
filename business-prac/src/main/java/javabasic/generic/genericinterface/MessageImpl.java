package generic.genericinterface;

class MessageImpl<T> implements IMessage<T> {
    @Override
    public void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        IMessage<String> msg = new MessageImpl();
        msg.print("Hello World"); //Hello World

        IMessage<Integer> msg2 = new MessageImpl();
        msg2.print(100); // 100
    }
}