package designPattern.designPatterns19_MementoDesignPattern;

public class A3_FileWriterClient {

	public static void main(String[] args) {
		
		A2_FileWriterCaretaker caretaker = new A2_FileWriterCaretaker();
		
		A1_FileWriterUtil fileWriter = new A1_FileWriterUtil("data.txt");
		
		fileWriter.write("First Set of Data ");
		System.out.println(fileWriter);
		// lets save the file
		caretaker.save(fileWriter);
		
		//now write something else
		fileWriter.write("Second Set of Data ");
		//checking file contents
		System.out.println(fileWriter);

		//lets undo to last save
		caretaker.undo(fileWriter);
		//checking file content again
		System.out.println(fileWriter);
	}
}

