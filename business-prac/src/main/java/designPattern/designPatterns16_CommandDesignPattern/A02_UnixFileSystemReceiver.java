package designPattern.designPatterns16_CommandDesignPattern;

public class A02_UnixFileSystemReceiver implements A01_FileSystemReceiver {
	@Override
	public void openFile() {
		System.out.println("Opening file in unix OS");
	}
	@Override
	public void writeFile() {
		System.out.println("Writing file in unix OS");
	}
	@Override
	public void closeFile() {
		System.out.println("Closing file in unix OS");
	}
}


