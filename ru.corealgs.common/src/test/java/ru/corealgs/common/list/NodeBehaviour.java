package ru.corealgs.common.list;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import ru.corealgs.common.list.Node;

public class NodeBehaviour extends AllListsBehaviour {
	
	@Test
	public void toStringTest() {
		// Given list
		int[] arr = { 1, 2, 3 };
		Node list = newList(arr);

		// When

		// Then
		assertThat(list.toString(), is(equalTo("List [1, 2, 3]")));
	}

	@Test
	public void toStringTestWhenLengthIsOne() {
		// Given list
		int[] arr = { 1 };
		Node list = newList(arr);

		// When

		// Then
		assertThat(list.toString(), is(equalTo("List [1]")));
	}

	@Test
	public void shouldReturnTrueWhenEquals() {
		// Given lists
		int[] arr = { 1, 2, 3 };
		Node list1 = newList(arr);
		Node list2 = newList(arr);

		// Then
		assertThat(list1.equals(list2), is(true));
	}

	@Test
	public void shouldReturnFalseWhenNotEquals() {
		// Given list
		int[] arr = { 1, 2, 3 };
		Node list1 = newList(arr);

		// When
		arr = Arrays.copyOf(arr, 4);
		Node list2 = newList(arr);

		// Then
		assertThat(list1.equals(list2), is(false));

		// When
		arr = Arrays.copyOf(arr, 2);
		list2 = newList(arr);

		// Then
		assertThat(list1.equals(list2), is(false));

		// When
		arr = Arrays.copyOf(arr, 3);
		list2 = newList(arr);

		// Then
		assertThat(list1.equals(list2), is(false));
	}

}
