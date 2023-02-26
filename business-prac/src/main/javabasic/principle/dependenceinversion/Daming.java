package principle.dependenceinversion;

public class Daming {
    void study(ICourse course){
        course.study();
    }
}
