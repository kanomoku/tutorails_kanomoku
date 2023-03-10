package designPattern.designPatterns07_BridgeDesignPattern;

public abstract class A2_Shape {
	//Composition - implementor
	protected A1_Color color;
	
	//constructor with implementor as input argument
	public A2_Shape(A1_Color c){
		this.color=c;
	}
	abstract public void applyColor();
}

