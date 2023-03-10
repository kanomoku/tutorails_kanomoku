package designPattern.designPatterns16_CommandDesignPattern;

public class A06_WriteFileCommand implements A04_Command {

	private A01_FileSystemReceiver fileSystem;
	
	public A06_WriteFileCommand(A01_FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	@Override
	public void execute() {
		this.fileSystem.writeFile();
	}
}

