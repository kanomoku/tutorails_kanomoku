package designPattern.designPatterns16_CommandDesignPattern;

public class A10_FileSystemClient {

	public static void main(String[] args) {
		//Creating the receiver object
		A01_FileSystemReceiver fileSystemReceiver = A09_FileSystemReceiverUtil.getUnderlyingFileSystem();
		
		//creating command and associating with receiver
		A05_OpenFileCommand openFileCommand = new A05_OpenFileCommand(fileSystemReceiver);
		//Creating invoker and associating with Command
		A08_FileInvoker fileInvoker = new A08_FileInvoker(openFileCommand);
		//perform action on invoker object
		fileInvoker.execute();
		
		A06_WriteFileCommand writeFileCommand = new A06_WriteFileCommand(fileSystemReceiver);
		fileInvoker = new A08_FileInvoker(writeFileCommand);
		fileInvoker.execute();
		
		A07_CloseFileCommand closeFileCommand = new A07_CloseFileCommand(fileSystemReceiver);
		fileInvoker = new A08_FileInvoker(closeFileCommand);
		fileInvoker.execute();
	}

}
