package designPattern.designPatterns16_CommandDesignPattern;


public class B07_Client {
 
    public static void main(String[] args) {
 
        //创建电灯的对象(接受者)
        B05_LightReceiver lightReceiver = new B05_LightReceiver();
 
        //创建电灯相关的开关命令
        B03_LightOnCommand lightOnCommand = new B03_LightOnCommand(lightReceiver);
        B02_LightOffCommand lightOffCommand = new B02_LightOffCommand(lightReceiver);
 
        //需要一个遥控器
        B06_RemoteController remoteController = new B06_RemoteController();
 
        //给我们的遥控器设置命令, 比如 no = 0 是电灯的开和关的操作
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);
 
        System.out.println("--------   按下灯的开按钮    -----------");
        remoteController.onButtonWasPushed(0);
        System.out.println("--------   按下灯的关按钮    -----------");
        remoteController.offButtonWasPushed(0);
        System.out.println("--------   按下撤销按钮-----------  ");
        remoteController.undoButtonWasPushed();
    }
}

