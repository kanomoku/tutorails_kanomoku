package designPattern.designPatterns16_CommandDesignPattern;


public class B06_RemoteController {
 
    // 开关 按钮的命令数组
    B01_Command[] onCommands;
    B01_Command[] offCommands;
    //执行撤销的命令
    B01_Command undoCommand;
 
    public B06_RemoteController() {
        onCommands = new B01_Command[5];
        offCommands = new B01_Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new B04_NoCommand();
            offCommands[i] = new B04_NoCommand();
        }
    }
 
    // 给我们的按钮设置你需要的命令
    public void setCommand(int no, B01_Command onCommand, B01_Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }
 
    // 按下开按钮
    public void onButtonWasPushed(int no) {
        // 找到你按下的开的按钮，并调用对应方法
        onCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = onCommands[no];
 
    }
 
    // 按下开按钮
    public void offButtonWasPushed(int no) {
        // 找到你按下的关的按钮，并调用对应方法
        offCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }
 
    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
