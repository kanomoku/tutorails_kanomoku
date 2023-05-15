package generic.genericinterface;

class MessageStringImpl implements IMessage<String> {
    @Override
    public void print(String t) {
        System.out.println(t);
    }
}
