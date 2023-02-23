package principle.lawofdemeter;

public class MainBusiness {
    public static void main(String[] args) {
        Leader leader = new Leader();
        Employee employee = new Employee();
        leader.commandCheck(employee);

        Employee employee1 = new Employee();
        leader.commandCheck1(employee1);
    }
}
