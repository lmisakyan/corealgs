package ru.corealgs.stacks.set;

import java.util.BitSet;
import java.util.NoSuchElementException;

public class ThreeStacks {
	private static final int NUMBER_OF_STACKS = 3;
	private static final int STACKS_SIZE = 100;

	private int[] data;
	private int current;
	private BitSet[] mask;

	public ThreeStacks() {
		this.data = new int[STACKS_SIZE];
		this.current = 0;
		this.mask = new BitSet[NUMBER_OF_STACKS];
		for (int i = 0; i < NUMBER_OF_STACKS; ++i) {
			this.mask[i] = new BitSet();
		}
	}

	public void push(int index, int data) {
		this.data[current] = data;
		mask[index - 1].set(current);
		current++;
	}

	public int pop(int index) {
		if (current == 0)
			throw new NoSuchElementException("Stack #" + index + " is empty");

		int i = this.mask[index - 1].length() - 1;
		if (i == -1)
			throw new NoSuchElementException("Stack #" + index + " is empty");

		this.mask[index - 1].set(i, false);
		return this.data[i];
	}

	public boolean isEmpty(int index) {
		return this.mask[index - 1].length() == 0;
	}

}
