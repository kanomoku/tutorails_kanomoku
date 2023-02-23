package principle.lawofdemeter;

import java.util.ArrayList;
import java.util.List;

public class Leader {
    public void commandCheck(Employee employee){
        List<Task> taskList = new ArrayList<>();
        employee.checkTask(taskList);
    }

    public void commandCheck1(Employee employee){
        employee.checkTask1();
    }
}
