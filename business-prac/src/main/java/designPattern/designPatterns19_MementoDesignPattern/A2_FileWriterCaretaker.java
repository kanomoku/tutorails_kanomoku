package designPattern.designPatterns19_MementoDesignPattern;

public class A2_FileWriterCaretaker {

	private Object obj;
	
	public void save(A1_FileWriterUtil fileWriter){
		this.obj=fileWriter.save();
	}
	
	public void undo(A1_FileWriterUtil fileWriter){
		fileWriter.undoToLastSave(obj);
	}
}

