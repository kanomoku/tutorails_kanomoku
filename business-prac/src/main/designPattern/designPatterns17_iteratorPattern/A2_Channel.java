package designPattern.designPatterns17_iteratorPattern;

public class A2_Channel {
	private double frequency;
	private A1_ChannelTypeEnum TYPE;
	public A2_Channel(double freq, A1_ChannelTypeEnum type) {
		this.frequency = freq;
		this.TYPE = type;
	}
	public double getFrequency() {
		return frequency;
	}
	public A1_ChannelTypeEnum getTYPE() {
		return TYPE;
	}
	@Override
	public String toString() {
		return "Frequency=" + this.frequency + ", Type=" + this.TYPE;
	}
}
