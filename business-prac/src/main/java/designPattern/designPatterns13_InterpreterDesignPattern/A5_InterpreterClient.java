package designPattern.designPatterns13_InterpreterDesignPattern;

public class A5_InterpreterClient {

	public A1_InterpreterContext ic;
	
	public A5_InterpreterClient(A1_InterpreterContext i){
		this.ic=i;
	}
	
	public String interpret(String str){
		A2_Expression exp = null;
		//create rules for expressions
		if(str.contains("Hexadecimal")){
			exp=new A4_IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else if(str.contains("Binary")){
			exp=new A3_IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else return str;
		return exp.interpret(ic);
	}
}

