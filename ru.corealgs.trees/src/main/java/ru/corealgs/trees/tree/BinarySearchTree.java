package ru.corealgs.trees.tree;

import java.util.ArrayList;
import java.util.List;

import ru.corealgs.trees.node.BinarySearchTreeNode;
import ru.corealgs.trees.node.BinaryTreeNode;
import ru.corealgs.trees.node.Node;

/**
 * Binary Search Tree implementation of tree interface.
 * 
 * @author Leon Misakyan
 * 
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements Tree<E> {

	private BinaryTreeNode<E> root;
	private int size;

	public BinaryTreeNode<E> getRoot() {
		return this.root;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void add(E data) {
		BinaryTreeNode<E> n = new BinarySearchTreeNode<E>(data);
		BinaryTreeNode<E> p = null;
		BinaryTreeNode<E> c = this.root;

		while (c != null) {
			p = c;
			if (data.compareTo(c.getData()) < 0)
				c = c.getLeft();
			else
				c = c.getRight();
		}

		if (p == null)
			this.root = n;
		else {
			n.setParent(p);
			if (data.compareTo(p.getData()) < 0)
				p.setLeft(n);
			else
				p.setRight(n);
		}
		++size;
	}

	@Override
	public void remove(Node<E> node) {

	}

	/**
	 * Implementation uses preorder tree walk algorithm.
	 * 
	 */
	@Override
	public List<E> toList() {
		if (this.root != null)
			return this.root.toList();
		else
			return new ArrayList<E>();
	}

	/**
	 * Implementation uses inorder tree walk algorithm.
	 * 
	 */
	@Override
	public List<E> toSortedList() {
		if (this.root != null)
			return this.root.toSortedList();
		else
			return new ArrayList<E>();
	}

	@Override
	public int height() {
		if (this.root == null)
			return 0;
		else
			return this.root.height();
	}

	@Override
	public boolean isBalanced() {
		return this.root == null ? true : root.isBalanced();
	}

}
