package ru.corealgs.trees;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ru.corealgs.trees.tree.BinarySearchTree;
import ru.corealgs.trees.tree.Tree;

public class TreeBehaviour {
	private static final Integer[] balansedArray = { 12, 5, 2, 9, 18, 15, 13, 17, 19 };
	private static final Integer[] notBalansedArray = { 3, 2, 1, 9, 8, 7, 10, 9, 11, 12 };

	@Test
	public void shouldReturnSizeOfEmptyTree() {
		// Given
		Tree<Integer> tree = new BinarySearchTree<Integer>();

		// Then
		assertThat(tree.size(), is(equalTo(0)));
	}

	@Test
	public void shouldReturnSizeOfNonEmptyTree() {
		// Given
		Tree<Integer> tree = newBalancedTree();

		// Then
		assertThat(tree.size(), is(equalTo(9)));
	}

	@Test
	public void shouldReturnArrayWithAllNodes() {
		// Given
		Tree<Integer> tree = newBalancedTree();
		List<Integer> expected = Arrays.asList(balansedArray);

		// Then
		assertThat(tree.toList(), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnArrayWithAllNodesInAscendingOrder() {
		// Given
		Tree<Integer> tree = newBalancedTree();
		Integer[] expectedArray = { 2, 5, 9, 12, 13, 15, 17, 18, 19 };
		List<Integer> expected = Arrays.asList(expectedArray);

		// Then
		assertThat(tree.toSortedList(), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnArrayWithAllNodesInAscendingOrderInNonBalancedTree() {
		// Given
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(3);
		tree.add(2);
		tree.add(1);

		Integer[] expectedArray = { 1, 2, 3 };
		List<Integer> expected = Arrays.asList(expectedArray);

		// Then
		assertThat(tree.toSortedList(), is(equalTo(expected)));
	}

	@Test
	public void shouldReturnHeightOfTheTreeConsistedOfOneNode() {
		// Given
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(1);

		// Then
		assertThat(tree.height(), is(equalTo(0)));
	}

	@Test
	public void shouldReturnHeightOfTheTree() {
		// Given
		Tree<Integer> tree = newBalancedTree();

		// Then
		assertThat(tree.height(), is(equalTo(3)));
	}

	@Test
	public void shouldReturnWhetherTreeIsBalanced() {
		// Given
		Tree<Integer> tree = newBalancedTree();

		// Then
		assertThat(tree.isBalanced(), is(true));

		// Given
		tree = newNotBalancedTree();

		// Then
		assertThat(tree.isBalanced(), is(false));
	}

	public static Tree<Integer> newBalancedTree() {
		Tree<Integer> t = new BinarySearchTree<Integer>();

		for (int i = 0; i < balansedArray.length; i++) {
			t.add(balansedArray[i]);
		}
		return t;
	}

	public static Tree<Integer> newNotBalancedTree() {
		Tree<Integer> t = new BinarySearchTree<Integer>();

		for (int i = 0; i < notBalansedArray.length; i++) {
			t.add(notBalansedArray[i]);
		}
		return t;
	}
}
