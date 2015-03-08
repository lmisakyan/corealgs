package ru.corealgs.stacks;

import ru.corealgs.stacks.stack.MinListStack;
import ru.corealgs.stacks.stack.Stack;

public class Stacks {

	public static void change(Stack from, Stack to) {
		while (!from.isEmpty()) {
			to.push(from.pop());
		}
	}

	public static void sort(Stack stack) {
		if (stack.isEmpty())
			return;

		Stack sorted = new MinListStack();
		Stack buffer = new MinListStack();

		while (!stack.isEmpty()) {
			if (sorted.isEmpty() || sorted.peek() <= stack.peek()) {
				sorted.push(stack.pop());
				if (!buffer.isEmpty())
					change(buffer, sorted);

			} else {
				buffer.push(sorted.pop());
			}
		}

		change(sorted, stack);
	}

	public static void sort2(Stack stack) {
		if (stack.isEmpty())
			return;

		Stack sorted = new MinListStack();
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			while (!sorted.isEmpty() && sorted.peek() > tmp) {
				stack.push(sorted.pop());
			}
			sorted.push(tmp);
		}

		change(sorted, stack);
	}

}
