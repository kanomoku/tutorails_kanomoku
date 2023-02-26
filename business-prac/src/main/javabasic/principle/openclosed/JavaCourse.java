package principle.openclosed;

public class JavaCourse implements ICourse {
    public Double price;

    public JavaCourse(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
