package ru.corealgs.stacks.queue;

public class ListQueueBehaviour extends AllQueueBehaviour {

	@Override
	protected Queue createQueue() {
		return new ListQueue();
	}

}
