package designPattern.designPatterns13_InterpreterDesignPattern;

public class A4_IntToHexExpression implements A2_Expression {

	private int i;
	
	public A4_IntToHexExpression(int c){
		this.i=c;
	}
	
	@Override
	public String interpret(A1_InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}
}

