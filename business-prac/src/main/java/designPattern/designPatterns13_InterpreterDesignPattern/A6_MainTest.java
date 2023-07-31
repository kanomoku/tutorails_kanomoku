package designPattern.designPatterns13_InterpreterDesignPattern;

public class A6_MainTest {
	
	public static void main(String args[]){
		String str1 = "28 in Binary";
		String str2 = "28 in Hexadecimal";
		
		A5_InterpreterClient ec = new A5_InterpreterClient(new A1_InterpreterContext());
		System.out.println(str1+"= "+ec.interpret(str1));
		System.out.println(str2+"= "+ec.interpret(str2));

	}
}

