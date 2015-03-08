package ru.corealgs.stacks.stack;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ru.corealgs.common.list.AllListsBehaviour;
import ru.corealgs.common.list.Node;

public abstract class StackBehaviour extends AllListsBehaviour {

	protected abstract Stack createStack();

	@Test
	public void shouldCreateStack() {
		assertThat(createStack(), is(not(nullValue())));
	}

	@Test
	public void shouldReturnWhetherStackIsEmpty() {
		// Given
		Stack stack = createStack();

		// When
		assertThat(stack.isEmpty(), is(true));

		// When
		stack.push(1);

		// Then
		assertThat(stack.isEmpty(), is(not(true)));
	}

	@Test
	public void shouldPushElement() {
		// Given
		Stack stack = createStack();

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		int[] expectedArr = { 3, 2, 1 };
		Node expected = newList(expectedArr);
		assertThat(stack.getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldPopElement() {
		// Given
		Stack stack = createStack();

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.pop(), is(equalTo(3)));

		int[] expectedArr = { 2, 1 };
		Node expected = newList(expectedArr);
		assertThat(stack.getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldPeekElement() {
		// Given
		Stack stack = createStack();

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.peek(), is(equalTo(3)));

		int[] expectedArr = { 3, 2, 1 };
		Node expected = newList(expectedArr);
		assertThat(stack.getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnMinimalElementAfterPush() {
		// Given
		Stack stack = createStack();

		// When
		stack.push(10);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.min(), is(equalTo(2)));
	}

	@Test
	public void shouldReturnMinimalElementAfterPushAndPop() {
		// Given
		Stack stack = createStack();

		// When
		stack.push(10);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.pop();

		// Then
		assertThat(stack.min(), is(equalTo(2)));
	}

}