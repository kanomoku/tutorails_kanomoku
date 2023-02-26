package principle.lawofdemeter;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    void checkTask(List<Task> tasks){}
    void checkTask1(){
        List<Task> taskList = new ArrayList<>();
    }
}
