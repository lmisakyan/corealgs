package ru.corealgs.stacks.towers;

import ru.corealgs.stacks.stack.DescendingStack;
import ru.corealgs.stacks.stack.Stack;

public class Towers {

	private static final int NUM_LOCATIONS = 3;
	private int height;

	Stack[] towers;

	public void init() {
		Stack stack = towers[0];
		for (int i = this.height; i > 0; i--) {
			stack.push(i);
		}
	}

	public Towers(int elements) {
		// Initializing towers
		this.towers = new Stack[NUM_LOCATIONS];
		for (int i = 0; i < this.towers.length; i++) {
			towers[i] = new DescendingStack();
		}

		// Full first tower with elements
		this.height = elements;
		init();
	}

	public void reset() {
		for (int i = 0; i < towers.length; i++) {
			Stack tower = towers[i];
			while (!tower.isEmpty())
				tower.pop();
		}
		init();
	}

	private Stack getNextTower(Stack tower) {
		int length = towers.length;
		for (int i = 0; i < length; i++) {
			if (towers[i] == tower)
				return towers[i == length - 1 ? 0 : ++i];
		}
		return null;
	}

	private Stack moveToNextTower(Stack tower) {
		Stack nextTower = getNextTower(tower);
		while (nextTower != tower) {
			if (move(tower, nextTower))
				return nextTower;
			nextTower = getNextTower(nextTower);
		}

		return null;
	}

	public boolean move(Stack fromTower, Stack toTower) {
		int data = fromTower.peek();
		try {
			toTower.push(data);
			fromTower.pop();
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private void doMoveRecursive(int height, Stack tower) {
		if (height > 0) {
			doMoveRecursive(height - 1, tower);

			Stack pushed = moveToNextTower(tower);
			Stack nextTower = getNextTower(tower);
			nextTower = (nextTower == pushed ? getNextTower(nextTower)
					: nextTower);

			doMoveRecursive(height - 1, nextTower);
		}
	}

	public void moveTower() {
		Stack tower = towers[0];
		Stack nextTower = getNextTower(tower);
		Stack lastPushed = null;

		do {
			Stack pushed = moveToNextTower(tower);
			Boolean hasPushed = (pushed != null);
			if (hasPushed)
				lastPushed = pushed;
			if (!hasPushed || tower.isEmpty()) {
				tower = getNextTower(tower);
				nextTower = getNextTower(tower);
				tower = (tower == lastPushed ? getNextTower(tower) : tower);
			}
		} while (!(nextTower.isEmpty() && getNextTower(nextTower).isEmpty()));
	}

	public void moveTowerRecursive() {
		doMoveRecursive(this.height, towers[0]);
	}

}
