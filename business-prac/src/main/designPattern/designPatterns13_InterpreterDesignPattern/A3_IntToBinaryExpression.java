package designPattern.designPatterns13_InterpreterDesignPattern;

public class A3_IntToBinaryExpression implements A2_Expression {

	private int i;
	
	public A3_IntToBinaryExpression(int c){
		this.i=c;
	}
	@Override
	public String interpret(A1_InterpreterContext ic) {
		return ic.getBinaryFormat(this.i);
	}
}

