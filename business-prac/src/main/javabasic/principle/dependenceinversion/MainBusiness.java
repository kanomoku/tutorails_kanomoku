package principle.dependenceinversion;

public class MainBusiness {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.studyEnglish();
        tom.studyChinese();

        Daming daming = new Daming();
        daming.study(new ChineseCourse());
        daming.study(new EnglishCourse());
    }
}
