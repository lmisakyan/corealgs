package ru.corealgs.stacks.stack;

import org.junit.Test;

public class DescendingStackBehaviour {

	protected Stack createStack() {
		return new DescendingStack();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotPushElementIfGreaterThanTop() {
		// Given
		Stack stack = createStack();

		// When
		stack.push(1);
		stack.push(2);
	}

}
