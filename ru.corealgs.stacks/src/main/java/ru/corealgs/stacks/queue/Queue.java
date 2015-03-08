package ru.corealgs.stacks.queue;

import ru.corealgs.common.list.Node;

public interface Queue {

	public void enqueue(int data);

	public int dequeue();

	public Node getData();

}