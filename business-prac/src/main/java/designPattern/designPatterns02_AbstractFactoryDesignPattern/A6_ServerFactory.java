package designPattern.designPatterns02_AbstractFactoryDesignPattern;

public class A6_ServerFactory implements A4_ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public A6_ServerFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public A1_Computer createComputer() {
		return new A3_Server(ram,hdd,cpu);
	}

}

