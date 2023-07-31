package designPattern.designPatterns16_CommandDesignPattern;

//创建命令接口
public interface B01_Command {

	// 执行动作(操作)
	public void execute();

	// 撤销动作(操作)
	public void undo();

}
