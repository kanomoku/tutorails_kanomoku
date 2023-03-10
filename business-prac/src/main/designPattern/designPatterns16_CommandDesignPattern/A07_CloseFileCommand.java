package designPattern.designPatterns16_CommandDesignPattern;

public class A07_CloseFileCommand implements A04_Command {

	private A01_FileSystemReceiver fileSystem;
	
	public A07_CloseFileCommand(A01_FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	@Override
	public void execute() {
		this.fileSystem.closeFile();
	}
}

