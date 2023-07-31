package generic.genericinterface;

class MessageStringImpl implements IMessage<String> {
    @Override
    public void print(String t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        IMessage msg = new MessageStringImpl();
        msg.print("Hello World"); // Hello World
    }
}
