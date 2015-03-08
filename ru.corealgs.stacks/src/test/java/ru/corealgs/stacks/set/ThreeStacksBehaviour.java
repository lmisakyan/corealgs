package ru.corealgs.stacks.set;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ThreeStacksBehaviour {

	@Test
	public void shouldPushAndPopElementsInCorrectOrder() {
		// Given
		ThreeStacks stack = new ThreeStacks();

		// When
		stack.push(1, 1);
		stack.push(2, 2);
		stack.push(3, 3);
		stack.push(2, 4);

		// Then
		assertThat(stack.pop(1), is(equalTo(1)));
		assertThat(stack.pop(2), is(equalTo(4)));
		assertThat(stack.pop(3), is(equalTo(3)));
		assertThat(stack.pop(2), is(equalTo(2)));
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExceptionIfStackIsEmpty() {
		// Given
		ThreeStacks stack = new ThreeStacks();

		// When
		stack.push(1, 1);

		// Then
		assertThat(stack.pop(2), is(nullValue()));
	}

	@Test
	public void shouldReturnWhetherIsEmpty() {
		// Given
		ThreeStacks stack = new ThreeStacks();

		// When
		stack.push(1, 1);

		// Then
		assertThat(stack.isEmpty(2), is(true));
		assertThat(stack.isEmpty(1), is(not(true)));
	}
}
