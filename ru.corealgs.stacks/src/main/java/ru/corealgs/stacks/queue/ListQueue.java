package ru.corealgs.stacks.queue;

import java.util.NoSuchElementException;

import ru.corealgs.common.list.Node;

public class ListQueue implements Queue {
	Node first, last;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.corealgs.stacks.queue.Queue#enqueue(int)
	 */
	@Override
	public void enqueue(int data) {
		Node n = new Node(data);
		if (first == null) {
			first = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.corealgs.stacks.queue.Queue#dequeue()
	 */
	@Override
	public int dequeue() {
		if (first == null)
			throw new NoSuchElementException("Queue is empty");
		int data = first.getData();
		first = first.next;
		return data;
	}

	@Override
	public Node getData() {
		return first;
	}

}
