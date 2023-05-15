package generic.genericinterface;

class MessageImpl<T> implements IMessage<T> {
    @Override
    public void print(T t) {
        System.out.println(t);
    }
}