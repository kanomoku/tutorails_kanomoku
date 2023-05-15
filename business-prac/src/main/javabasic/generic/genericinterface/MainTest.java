package generic.genericinterface;

import org.junit.Test;

public class MainTest {

    @Test
    public void test1() {
        IMessage<String> msg = new MessageImpl();
        msg.print("Hello World"); //Hello World
    }

    @Test
    public void test2() {
        IMessage msg = new MessageStringImpl();
        msg.print("Hello World"); // Hello World
    }
}
