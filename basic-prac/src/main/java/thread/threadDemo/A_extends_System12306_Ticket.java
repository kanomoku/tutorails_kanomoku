package thread.threadDemo;

public class A_extends_System12306_Ticket {
	private String strart;
	private String end;
	private Float price;// 用包装类--这样null也能装进去--基本类型存不了这个会报错

	public A_extends_System12306_Ticket() {
	}

	public A_extends_System12306_Ticket(String start, String end, Float price) {
		this.strart = start;
		this.end = end;
		this.price = price;
	}

	public String getStrart() {
		return strart;
	}

	public void setStrart(String strart) {
		this.strart = strart;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		stringBuilder.append(this.strart);
		stringBuilder.append("-->");
		stringBuilder.append(this.end);
		stringBuilder.append(":");
		stringBuilder.append(this.price);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
