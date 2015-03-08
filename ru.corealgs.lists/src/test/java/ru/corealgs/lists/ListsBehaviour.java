package ru.corealgs.lists;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ru.corealgs.common.list.AllListsBehaviour;
import ru.corealgs.common.list.Node;

public class ListsBehaviour extends AllListsBehaviour {

	@Test
	public void shouldDeleteDuplicatesFromMiddleOfList() {
		// Given list
		int[] arr = { 1, 2, 2, 3 };
		Node list = newList(arr);

		// When
		Lists.deleteDuplicates(list);

		// Then
		int[] expectedArr = { 1, 2, 3 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldDeleteDuplicatesInFirstElement() {
		// Given list
		int[] arr = { 2, 2, 2, 1 };
		Node list = newList(arr);

		// When
		Lists.deleteDuplicates(list);

		// Then
		int[] expectedArr = { 2, 1 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldDeleteDuplicatesInLastElement() {
		// Given list
		int[] arr = { 1, 2, 2, 2 };
		Node list = newList(arr);

		// When
		Lists.deleteDuplicates(list);

		// Then
		int[] expectedArr = { 1, 2 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldDeleteDuplicatesInMoreThanOneElement() {
		// Given list
		int[] arr = { 1, 1, 2, 2, 2, 3, 3 };
		Node list = newList(arr);

		// When
		Lists.deleteDuplicates(list);

		// Then
		int[] expectedArr = { 1, 2, 3 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldDeleteDuplicatesNotInRow() {
		// Given list
		int[] arr = { 1, 2, 1, 2, 1, 3, 2, 3, 4 };
		Node list = newList(arr);

		// When
		Lists.deleteDuplicates(list);

		// Then
		int[] expectedArr = { 1, 2, 3, 4 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldNotDeleteIfNoDuplicates() {
		// Given list
		int[] arr = { 1, 2, 3, 4 };
		Node list = newList(arr);

		// When
		Lists.deleteDuplicates(list);

		// Then
		int[] expectedArr = { 1, 2, 3, 4 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldReturnKthElementFromEnd() {
		// Given list
		int[] arr = { 1, 2, 3, 4 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.getFromEnd(list, 1), is(equalTo(4)));
	}

	@Test
	public void shouldReturnFirstElementIfKEqualToLength() {
		// Given list
		int[] arr = { 10 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.getFromEnd(list, 1), is(equalTo(10)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIfKGreaterThanLength() {
		// Given list
		int[] arr = { 1 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.getFromEnd(list, 2), is(equalTo(1)));
	}

	@Test
	public void shouldReturnKthElementFromEndRecursive() {
		// Given list
		int[] arr = { 1, 2, 3, 4 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.getFromEndRecursive(list, 1), is(equalTo(4)));
	}

	@Test
	public void shouldReturnFirstElementIfKEqualToLengthRecursive() {
		// Given list
		int[] arr = { 10 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.getFromEndRecursive(list, 1), is(equalTo(10)));
	}

	@Test
	public void shouldDeleteGivenElement() {
		// Given list
		int[] arr = { 1, 2, 3, 4, 5 };
		Node list = newList(arr);

		// When
		Lists.deleteFromList(list.next.next);

		// Then
		int[] expectedArr = { 1, 2, 4, 5 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldMoveElementsThatSmallerThanGiven() {
		// Given list
		int[] arr = { 1, 5, 3, 5, 2, 4, 1 };
		Node list = newList(arr);

		// When
		Lists.moveElements(list, 3);

		// Then
		int[] expectedArr = { 1, 2, 1, 5, 3, 5, 4 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldMoveElementsThatSmallerThanGivenBeforeHead() {
		// Given list
		int[] arr = { 5, 3, 5, 2, 4, 1 };
		Node list = newList(arr);

		// When
		Lists.moveElements(list, 3);

		// Then
		int[] expectedArr = { 2, 1, 5, 3, 5, 4 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldNotMoveElementsIfAllElementsGreaterThanGiven() {
		// Given list
		int[] arr = { 5, 3, 5, 4 };
		Node list = newList(arr);

		// When
		Lists.moveElements(list, 3);

		// Then
		int[] expectedArr = { 5, 3, 5, 4 };
		Node expected = newList(expectedArr);
		assertThat(list, is(equalTo(expected)));
	}

	@Test
	public void shouldAddTwoListsInReverse() {
		// Given list
		int[] arr1 = { 5, 3, 1 }; // 135
		Node list1 = newList(arr1);
		int[] arr2 = { 7, 5, 4 }; // 457
		Node list2 = newList(arr2);

		// Then
		assertThat(Lists.addTwoListsReverse(list1, list2), is(equalTo(592)));
	}

	@Test
	public void shouldAddTwoLists() {
		// Given list
		int[] arr1 = { 5, 3, 1 }; // 531
		Node list1 = newList(arr1);
		int[] arr2 = { 5, 5, 4 }; // 554
		Node list2 = newList(arr2);

		// Then
		assertThat(Lists.addTwoLists(list1, list2), is(equalTo(1085)));
	}

	@Test
	public void shouldReturnStartOfRingAndRemove() {
		// Given list
		int[] arr = { 5, 2, 5, 3 };
		Node list = newList(arr);
		list.next.next.next.next = list.next; // add ring

		// Then
		int[] expectedArr = { 2, 5, 3 };
		Node expected = newList(expectedArr);
		assertThat(Lists.getStartOfLoopAndRemove(list), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnStartOfRingAndRemoveIfStartIsHead() {
		// Given list
		int[] arr = { 5, 3, 5, 2 };
		Node list = newList(arr);
		list.next.next.next.next = list; // add ring

		// Then
		int[] expectedArr = { 5, 3, 5, 2 };
		Node expected = newList(expectedArr);
		assertThat(Lists.getStartOfLoopAndRemove(list), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnNullIfNoRing() {
		// Given list
		int[] arr = { 5, 3, 5, 2 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.getStartOfLoopAndRemove(list), is(nullValue()));
	}

	@Test
	public void shouldReverseList() {
		// Given list
		int[] arr = { 4, 3, 5, 2, 1, 0 };
		Node list = newList(arr);

		// When
		Node result = Lists.reverseList(list);

		// Then
		int[] expectedArr = { 0, 1, 2, 5, 3, 4 };
		Node expected = newList(expectedArr);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void shouldReturnNullIfGivenNull() {
		// Then
		assertThat(Lists.reverseList(null), is(nullValue()));
	}

	@Test
	public void shouldReturnNewReversedList() {
		// Given list
		int[] arr = { 4, 3, 5, 2, 1, 0 };
		Node list = newList(arr);
		Node listToLeave = newList(arr);

		// When
		Node result = Lists.getReversedList(list);

		// Then
		int[] reversedArr = { 0, 1, 2, 5, 3, 4 };
		Node reversed = newList(reversedArr);
		assertThat(result, is(equalTo(reversed)));
		assertThat(list, is(equalTo(listToLeave)));
	}

	@Test
	public void shouldReturnTrueIfListIsSymmetric() {
		// Given list
		int[] arr = { 4, 3, 5, 5, 3, 4 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.isPalindrome(list), is(true));
	}

	@Test
	public void shouldReturnFalseIfListIsNotSymmetrical() {
		// Given list
		int[] arr = { 4, 3, 2, 5, 3, 4 };
		Node list = newList(arr);

		// Then
		assertThat(Lists.isPalindrome(list), is(false));
	}
}
