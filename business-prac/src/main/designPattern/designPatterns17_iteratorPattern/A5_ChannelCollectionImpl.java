package designPattern.designPatterns17_iteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class A5_ChannelCollectionImpl implements A4_ChannelCollection {

	private List<A2_Channel> channelsList;

	public A5_ChannelCollectionImpl() {
		channelsList = new ArrayList<>();
	}

	public void addChannel(A2_Channel c) {
		this.channelsList.add(c);
	}

	public void removeChannel(A2_Channel c) {
		this.channelsList.remove(c);
	}

	@Override
	public A3_ChannelIterator iterator(A1_ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, this.channelsList);
	}

	private class ChannelIteratorImpl implements A3_ChannelIterator {

		private A1_ChannelTypeEnum type;
		private List<A2_Channel> channels;
		private int position;

		public ChannelIteratorImpl(A1_ChannelTypeEnum ty, List<A2_Channel> channelsList) {
			this.type = ty;
			this.channels = channelsList;
		}

		@Override
		public boolean hasNext() {
			while (position < channels.size()) {
				A2_Channel c = channels.get(position);
				if (c.getTYPE().equals(type) || type.equals(A1_ChannelTypeEnum.ALL)) {
					return true;
				} else {
					position++;
				}
			}
			return false;
		}

		@Override
		public A2_Channel next() {
			A2_Channel c = channels.get(position);
			position++;
			return c;
		}
	}
}
