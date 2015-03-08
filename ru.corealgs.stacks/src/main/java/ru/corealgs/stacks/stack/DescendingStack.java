package ru.corealgs.stacks.stack;

public class DescendingStack extends MinListStack {

	public void push(int data) {
		if (top == null || top.getData() > data)
			super.push(data);
		else
			throw new IllegalArgumentException(
					"New element should be less than top element");

	}

}
