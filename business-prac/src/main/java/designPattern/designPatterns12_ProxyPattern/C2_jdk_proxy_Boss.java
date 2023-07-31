package designPattern.designPatterns12_ProxyPattern;

public class C2_jdk_proxy_Boss implements C1_jdk_proxy_Function {
	private String name;

	public C2_jdk_proxy_Boss() {
	}

	public C2_jdk_proxy_Boss(String name) {
		this.name = name;
	}

	public void target() {
		System.out.println(name +  "制定一个小目标");
	}

	@Override
	public void eat(String str) {
		System.out.println(name + "老板吃" + str);
	}
}
