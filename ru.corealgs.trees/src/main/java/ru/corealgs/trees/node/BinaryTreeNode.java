package ru.corealgs.trees.node;

/**
 * Represents node of the binary tree.
 * 
 * @author Misakyan
 */
public interface BinaryTreeNode<T> extends Node<T> {
	/**
	 * Returns the left child node.
	 * 
	 * @return BinaryTreeNode instance of left child node.
	 */
	BinaryTreeNode<T> getLeft();

	/**
	 * Sets the left child node of this node.
	 * 
	 */
	void setLeft(BinaryTreeNode<T> left);

	/**
	 * Returns the right child node of this node.
	 * 
	 * @return BinaryTreeNode instance of right child node.
	 */
	BinaryTreeNode<T> getRight();

	/**
	 * Sets the right child node of this node.
	 * 
	 */
	void setRight(BinaryTreeNode<T> right);

	/**
	 * Returns whether this node is balanced (difference between height of left and right subtrees of this node and all child
	 * nodes less than two).
	 * 
	 * @return whether this node is balanced.
	 */
	boolean isBalanced();

}
