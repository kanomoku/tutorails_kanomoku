package principle.openclosed;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Double price) {
        super(price);
    }

    public Double getDiscountPrice(Double discountRate) {
        return price * discountRate;
    }

    public Double getOriginPrice() {
        return price;
    }
}
