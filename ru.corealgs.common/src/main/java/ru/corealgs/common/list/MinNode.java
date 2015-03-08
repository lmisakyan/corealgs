package ru.corealgs.common.list;

public class MinNode extends Node {
	private int min;

	public int getMin() {
		return min;
	}

	public MinNode(int data, int min) {
		super(data);
		this.min = min;
	}
	

}
