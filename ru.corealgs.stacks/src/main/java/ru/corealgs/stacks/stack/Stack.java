package ru.corealgs.stacks.stack;

import java.util.NoSuchElementException;

import ru.corealgs.common.list.Node;

public abstract class Stack {

	Node top;

	public void push(int data) {
		if (top == null) {
			top = new Node(data);
		} else {
			Node n = new Node(data);
			n.next = top;
			top = n;
		}
	}

	public int pop() {
		if (top == null)
			throw new NoSuchElementException("Stack is empty");

		int result = top.getData();
		top = top.next;
		return result;
	}

	public int peek() {
		if (top == null)
			throw new NoSuchElementException("Stack is empty");
		return top.getData();
	}

	public abstract int min();

	public Node getData() {
		return top;
	}

	public boolean isEmpty() {
		return (top == null);
	}

}
