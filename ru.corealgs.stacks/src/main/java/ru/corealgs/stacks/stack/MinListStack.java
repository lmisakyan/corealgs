package ru.corealgs.stacks.stack;

import ru.corealgs.common.list.Node;

public class MinListStack extends Stack {

	private Node min;

	public void push(int data) {
		super.push(data);
		if (min == null)
			min = new Node(data);
		else if (min.getData() > data) {
			Node nm = new Node(data);
			nm.next = min;
			min = nm;
		}

	}

	public int pop() {
		int result = super.pop();
		if (result == min.getData()) {
			min = min.next;
		}
		return result;
	}

	public int min() {
		return min.getData();
	}

}
