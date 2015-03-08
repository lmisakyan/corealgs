package ru.corealgs.trees.tree;

import java.util.List;

import ru.corealgs.trees.node.Node;

/**
 * Tree.
 * 
 * @author Leon Misakyan
 */
public interface Tree<E> {

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree.
	 */
	int size();

	/**
	 * Adds new element.
	 */
	void add(E data);

	/**
	 * Removes element.
	 */
	void remove(Node<E> node);

	/**
	 * Returns a list containing all of the elements in this tree. If tree is empty returns empty list.
	 * 
	 * @return list containing all of the elements in this tree.
	 */
	List<E> toList();

	/**
	 * Returns a sorted list containing all of the elements in this tree. If tree is empty returns empty list.
	 * 
	 * @return sorted list containing all of the elements in this tree.
	 */
	List<E> toSortedList();

	/**
	 * Returns the height of the tree. Empty tree has zero height, just like tree consisting of only one element.
	 * 
	 * 
	 * @return integer value of height of the tree.
	 */
	int height();

	/**
	 * Returns whether this tree is balanced (difference between height of left and right subtrees of any node less than two). If
	 * tree is empty it is balanced.
	 * 
	 * @return whether this node is balanced.
	 */
	boolean isBalanced();
}
