package ru.corealgs.stacks.pets;

import java.util.LinkedList;
import java.util.Queue;

public class Pets {
	private Queue<Entry> dogQueue;
	private Queue<Entry> catQueue;
	private int currentNum;

	private static class Entry {
		Pet element;
		int seqNum;

		Entry(Pet element, int seqNum) {
			this.element = element;
			this.seqNum = seqNum;
		}
	}

	public Pets() {
		this.dogQueue = new LinkedList<Entry>();
		this.catQueue = new LinkedList<Entry>();
		this.currentNum = 0;
	}

	public void enqueue(Pet pet) {
		if (pet.getName().equals("Dog"))
			dogQueue.add(new Entry(pet, ++currentNum));
		else
			catQueue.add(new Entry(pet, ++currentNum));
	}

	public Pet dequeue() {
		if (dogQueue.element().seqNum < catQueue.element().seqNum)
			return dogQueue.remove().element;
		else
			return dogQueue.remove().element;
	}

	public Pet dequeueDog() {
		return dogQueue.remove().element;
	}

	public Pet dequeueCat() {
		return catQueue.remove().element;
	}

}
