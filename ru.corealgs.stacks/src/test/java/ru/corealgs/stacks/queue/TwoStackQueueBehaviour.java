package ru.corealgs.stacks.queue;

public class TwoStackQueueBehaviour extends AllQueueBehaviour {

	@Override
	protected Queue createQueue() {
		return new TwoStackQueue();
	}

}
