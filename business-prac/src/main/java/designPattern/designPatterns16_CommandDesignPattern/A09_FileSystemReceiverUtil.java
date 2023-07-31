package designPattern.designPatterns16_CommandDesignPattern;

public class A09_FileSystemReceiverUtil {
	
	public static A01_FileSystemReceiver getUnderlyingFileSystem(){
		 String osName = System.getProperty("os.name");
		 System.out.println("Underlying OS is:"+osName);
		 if(osName.contains("Windows")){
			 return new A03_WindowsFileSystemReceiver();
		 }else{
			 return new A02_UnixFileSystemReceiver();
		 }
	}
}

