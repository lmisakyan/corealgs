package ru.corealgs.stacks.set;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import ru.corealgs.stacks.stack.MinListStack;
import ru.corealgs.stacks.stack.Stack;

public class SetOfStacks {
	LinkedList<Entry> stacks;
	private int trashold;

	private static class Entry {
		Stack element;
		int count;

		Entry(Stack element, int count) {
			this.element = element;
			this.count = count;
		}
	}

	public SetOfStacks(int trashold) {
		this.stacks = new LinkedList<Entry>();
		this.trashold = trashold;
	}

	public void push(int data) {
		Entry stack = stacks.peekLast();
		if (stack != null && stack.count < trashold) {
			stack.count++;
		} else {
			stack = new Entry(new MinListStack(), 1);
			stacks.addLast(stack);
		}

		stack.element.push(data);
	}

	public int pop() {
		Entry stack = stacks.peekLast();
		if (stack == null)
			throw new NoSuchElementException("Stack is empty");

		return doPop(stack);
	}

	public int popAt(int index) {
		Entry stack = stacks.get(index);
		return doPop(stack);
	}

	private int doPop(Entry stack) {
		int result = stack.element.pop();
		stack.count--;
		if (stack.count == 0)
			stacks.remove(stack);

		return result;
	}
}
