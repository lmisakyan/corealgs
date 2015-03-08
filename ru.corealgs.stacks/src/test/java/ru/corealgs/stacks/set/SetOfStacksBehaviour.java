package ru.corealgs.stacks.set;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.NoSuchElementException;

import org.junit.Test;

public class SetOfStacksBehaviour {

	@Test
	public void shouldPushAndPopElementsInCorrectOrderIfOneStackInSet() {
		// Given
		SetOfStacks stack = new SetOfStacks(5);

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.pop(), is(equalTo(3)));
		assertThat(stack.pop(), is(equalTo(2)));
		assertThat(stack.pop(), is(equalTo(1)));
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExceptionIfAllElementsWasPoped() {
		// Given
		SetOfStacks stack = new SetOfStacks(5);

		// When
		stack.push(1);
		stack.pop();
		stack.pop();

		// Then should throw exception
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExceptionIfNoElementsIn() {
		// Given
		SetOfStacks stack = new SetOfStacks(5);

		// When
		stack.pop();

		// Then should throw exception
	}

	@Test
	public void shouldAddNewStackWhenTrasholdExceeded() {
		// Given
		SetOfStacks stack = new SetOfStacks(1);

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.stacks.size(), is(equalTo(3)));
	}

	@Test
	public void shouldRemoveStackFromSetWhenEmpty() {
		// Given
		SetOfStacks stack = new SetOfStacks(1);

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();

		// Then
		assertThat(stack.stacks.size(), is(equalTo(2)));
	}

	@Test
	public void shouldPushAndPopElementsInCorrectOrderFromSet() {
		// Given
		SetOfStacks stack = new SetOfStacks(2);

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.pop(), is(equalTo(3)));
		assertThat(stack.pop(), is(equalTo(2)));
		assertThat(stack.pop(), is(equalTo(1)));
	}
	
	@Test
	public void shouldPopElementFormGivenStack() {
		// Given
		SetOfStacks stack = new SetOfStacks(2);

		// When
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// Then
		assertThat(stack.popAt(0), is(equalTo(2)));
		assertThat(stack.popAt(1), is(equalTo(3)));
		assertThat(stack.popAt(0), is(equalTo(1)));
	}
}
