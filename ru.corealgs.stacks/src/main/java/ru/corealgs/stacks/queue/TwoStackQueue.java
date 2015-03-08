package ru.corealgs.stacks.queue;

import ru.corealgs.common.list.Node;
import ru.corealgs.stacks.stack.MinListStack;
import ru.corealgs.stacks.stack.Stack;

import static ru.corealgs.stacks.Stacks.change;

public class TwoStackQueue implements Queue {
	Stack first, second;

	public TwoStackQueue() {
		this.first = new MinListStack();
		this.second = new MinListStack();
	}

	@Override
	public void enqueue(int data) {
		first.push(data);
	}

	@Override
	public int dequeue() {
		if (second.isEmpty()) {
			change(first, second);
		}
		return second.pop();
	}

	@Override
	public Node getData() {
		if (second.isEmpty()) {
			change(first, second);
		}
		return second.getData();
	}

}
