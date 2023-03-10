package designPattern.designPatterns02_AbstractFactoryDesignPattern;

public class A5_PCFactory implements A4_ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public A5_PCFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	@Override
	public A1_Computer createComputer() {
		return new A2_PC(ram,hdd,cpu);
	}

}

