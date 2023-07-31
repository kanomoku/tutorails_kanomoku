package designPattern.designPatterns16_CommandDesignPattern;

public class A08_FileInvoker {

	public A04_Command command;
	
	public A08_FileInvoker(A04_Command c){
		this.command=c;
	}
	
	public void execute(){
		this.command.execute();
	}
}

