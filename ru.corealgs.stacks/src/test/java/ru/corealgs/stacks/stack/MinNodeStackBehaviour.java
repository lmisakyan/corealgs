package ru.corealgs.stacks.stack;

public class MinNodeStackBehaviour extends StackBehaviour {

	protected Stack createStack() {
		return new MinNodeStack();
	}
}
