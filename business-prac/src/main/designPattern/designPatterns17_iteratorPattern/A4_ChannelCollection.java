package designPattern.designPatterns17_iteratorPattern;

public interface A4_ChannelCollection {
	public void addChannel(A2_Channel c);
	public void removeChannel(A2_Channel c);
	public A3_ChannelIterator iterator(A1_ChannelTypeEnum type);
}

