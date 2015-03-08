package ru.corealgs.trees.node;

import java.util.List;

/**
 * Represents node of the tree.
 * 
 * @author Leon Misakyan
 */
public interface Node<T> {
	/**
	 * Returns the data associated with node.
	 * 
	 * @return data
	 */
	T getData();

	/**
	 * Returns the parent of the node.
	 * 
	 * @return parent of the this node.
	 */
	Node<T> getParent();

	/**
	 * Sets the parent of the this node.
	 * 
	 */
	void setParent(Node<T> parent);

	/**
	 * Returns the path to the farest leaf child node.
	 * 
	 * @return path to the farest leaf child node.
	 */
	int height();

	/**
	 * Returns a list containing all of the elements in this node and child nodes.
	 * 
	 * @return a list containing all of the elements in this node and child nodes.
	 */
	List<T> toList();

	/**
	 * Returns a sorted list containing all of the elements in this node and child nodes.
	 * 
	 * @return sorted list containing all of the elements in this node and child nodes.
	 */
	List<T> toSortedList();
}