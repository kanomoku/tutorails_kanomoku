package designPattern.designPatterns17_iteratorPattern;

public class A6_IteratorPatternTest {

	public static void main(String[] args) {
		A4_ChannelCollection channels = populateChannels();
		A3_ChannelIterator baseIterator = channels.iterator(A1_ChannelTypeEnum.ALL);
		while (baseIterator.hasNext()) {
			A2_Channel c = baseIterator.next();
			System.out.println(c.toString());
		}
		System.out.println("******");
		// Channel Type Iterator
		A3_ChannelIterator englishIterator = channels.iterator(A1_ChannelTypeEnum.ENGLISH);
		while (englishIterator.hasNext()) {
			A2_Channel c = englishIterator.next();
			System.out.println(c.toString());
		}
	}

	private static A4_ChannelCollection populateChannels() {
		A4_ChannelCollection channels = new A5_ChannelCollectionImpl();
		channels.addChannel(new A2_Channel(98.5, A1_ChannelTypeEnum.ENGLISH));
		channels.addChannel(new A2_Channel(99.5, A1_ChannelTypeEnum.HINDI));
		channels.addChannel(new A2_Channel(100.5, A1_ChannelTypeEnum.FRENCH));
		channels.addChannel(new A2_Channel(101.5, A1_ChannelTypeEnum.ENGLISH));
		channels.addChannel(new A2_Channel(102.5, A1_ChannelTypeEnum.HINDI));
		channels.addChannel(new A2_Channel(103.5, A1_ChannelTypeEnum.FRENCH));
		channels.addChannel(new A2_Channel(104.5, A1_ChannelTypeEnum.ENGLISH));
		channels.addChannel(new A2_Channel(105.5, A1_ChannelTypeEnum.HINDI));
		channels.addChannel(new A2_Channel(106.5, A1_ChannelTypeEnum.FRENCH));
		return channels;
	}

}
