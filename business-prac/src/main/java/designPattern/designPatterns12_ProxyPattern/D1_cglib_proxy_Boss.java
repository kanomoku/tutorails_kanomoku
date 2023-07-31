package designPattern.designPatterns12_ProxyPattern;

public class D1_cglib_proxy_Boss {
	private String name;

	public D1_cglib_proxy_Boss() {
	}

	public D1_cglib_proxy_Boss(String name) {
		this.name = name;
	}

	public void target() {
		System.out.println("制定一个小目标");
	}

	public void eat(String str) {
		System.out.println("老板吃" + str);
	}
}
