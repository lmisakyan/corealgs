package ru.corealgs.stacks.stack;

public class MinListStackBehaviour extends StackBehaviour {

	protected Stack createStack() {
		return new MinListStack();
	}
}
