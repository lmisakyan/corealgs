package ru.corealgs.stacks;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ru.corealgs.common.list.AllListsBehaviour;
import ru.corealgs.common.list.Node;
import ru.corealgs.stacks.stack.MinListStack;
import ru.corealgs.stacks.stack.Stack;

public class StacksBehaviour extends AllListsBehaviour {

	@Test
	public void shouldSortStack() {
		// Given
		Stack stack = new MinListStack();

		// When
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		Stacks.sort(stack);

		// Then
		int[] expectedArr = { 1, 2, 3, 4 };
		Node expected = newList(expectedArr);
		assertThat(stack.getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldSortStackWithQuickerMethod() {
		// Given
		Stack stack = new MinListStack();

		// When
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		Stacks.sort2(stack);

		// Then
		int[] expectedArr = { 1, 2, 3, 4 };
		Node expected = newList(expectedArr);
		assertThat(stack.getData(), is(equalTo(expected)));
	}
}
