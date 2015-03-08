package ru.corealgs.stacks.stack;

import ru.corealgs.common.list.MinNode;

public class MinNodeStack extends Stack {

	public void push(int data) {
		if (top == null) {
			top = new MinNode(data, data);
		} else {
			int min = ((MinNode) top).getMin();
			if (min > data)
				min = data;
			MinNode n = new MinNode(data, min);
			n.next = top;
			top = n;
		}
	}

	public int pop() {
		return super.pop();
	}

	public int min() {
		return ((MinNode) top).getMin();
	}
}
