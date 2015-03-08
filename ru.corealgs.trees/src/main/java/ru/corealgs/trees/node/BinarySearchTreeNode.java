/**
 * 
 */
package ru.corealgs.trees.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Node of the binary search tree.
 * 
 * @author Leon Misakyan
 * 
 */
public class BinarySearchTreeNode<T> implements BinaryTreeNode<T> {

	private T data;
	private Node<T> parent;
	private BinaryTreeNode<T> left, right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public Node<T> getParent() {
		return parent;
	}

	@Override
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	@Override
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	@Override
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	@Override
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	@Override
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public int height() {
		int lh = this.left == null ? 0 : this.left.height() + 1;
		int rh = this.right == null ? 0 : this.right.height() + 1;
		return Math.max(lh, rh);
	}

	@Override
	public List<T> toList() {
		List<T> result = new ArrayList<T>();
		result.add(this.data);
		if (this.left != null)
			result.addAll(this.left.toList());
		if (this.right != null)
			result.addAll(this.right.toList());
		return result;
	}

	@Override
	public List<T> toSortedList() {
		List<T> result = new ArrayList<T>();
		if (this.left != null)
			result.addAll(this.left.toSortedList());
		result.add(this.data);
		if (this.right != null)
			result.addAll(this.right.toSortedList());
		return result;
	}

	@Override
	public boolean isBalanced() {
		int lh = this.left == null ? 0 : this.left.height();
		int rh = this.right == null ? 0 : this.right.height();
		if (Math.abs(lh - rh) > 1)
			return false;
		else
			return (lh == 0 ? true : this.left.isBalanced()) && (lh == 0 ? true : this.right.isBalanced());
	}
}
