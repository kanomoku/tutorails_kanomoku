package method;

import atomicitybusiness.method.MethodUtils;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class MethodUtilsTest {

    @Test
    public void getChangeNoChange() {
        User user1 = new User();
        user1.setName("user2");
        user1.setAge("19");
        user1.setNum("123456");

        User user2 = new User();
        user2.setName("user2");
        user2.setAge("19");
        user2.setNum("123456");

        Map<String, Map<String, Object>> change = MethodUtils.getChange(user1, user2);
        Assert.assertEquals("{}", change.toString());

    }

    @Test
    public void getChangeWithChange() {
        User user1 = new User();
        user1.setName("user1");
        user1.setAge("19");
        user1.setNum("123456");

        User user2 = new User();
        user2.setName("user2");
        user2.setAge("18");
        user2.setNum("123457");

        Map<String, Map<String, Object>> change = MethodUtils.getChange(user1, user2);
        Assert.assertEquals("{num={new=123457, origin=123456}, name={new=user2, origin=user1}, age={new=18, origin=19}}", change.toString());
    }

    @Data
    static class User {
        private String name;
        private String age;
        private String num;
    }
}