package designPattern.designPatterns16_CommandDesignPattern;

public class A05_OpenFileCommand implements A04_Command {

	private A01_FileSystemReceiver fileSystem;
	
	public A05_OpenFileCommand(A01_FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	@Override
	public void execute() {
		//open command is forwarding request to openFile method
		this.fileSystem.openFile();
	}
}

