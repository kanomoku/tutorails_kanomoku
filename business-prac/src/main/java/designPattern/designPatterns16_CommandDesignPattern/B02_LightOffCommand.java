package designPattern.designPatterns16_CommandDesignPattern;

public class B02_LightOffCommand implements B01_Command {
	// 聚合 LightReceiver
	B05_LightReceiver light;

	// 构造器
	public B02_LightOffCommand(B05_LightReceiver light) {
		this.light = light;
	}

	@Override
	public void execute() {
		// 调用接收者的方法
		light.off();
	}

	@Override
	public void undo() {
		// 调用接收者的方法
		light.on();
	}
}
