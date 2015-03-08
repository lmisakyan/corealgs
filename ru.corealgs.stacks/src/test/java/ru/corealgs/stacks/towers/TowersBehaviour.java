package ru.corealgs.stacks.towers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ru.corealgs.common.list.AllListsBehaviour;
import ru.corealgs.common.list.Node;

public class TowersBehaviour extends AllListsBehaviour {

	@Test
	public void shouldResetTowers() {
		// Given
		Towers t = new Towers(1);

		// When
		t.towers[0].pop();
		t.towers[1].push(1);
		t.reset();

		// Then
		int[] expectedArr = { 1 };
		Node expected = newList(expectedArr);
		assertThat(t.towers[0].getData(), is(equalTo(expected)));
		assertThat(t.towers[1].getData(), is(nullValue()));
		assertThat(t.towers[2].getData(), is(nullValue()));
	}

	@Test
	public void shouldMoveElementaryTowerToAnotherLocation() {
		// Given
		Towers t = new Towers(1);

		// When
		t.moveTower();

		// Then
		int[] expectedArr = { 1 };
		Node expected = newList(expectedArr);
		assertThat(t.towers[1].getData(), is(equalTo(expected)));
		
		//When
		t.reset();
		t.moveTowerRecursive();
		
		// Then
		assertThat(t.towers[1].getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldMoveTwoElementsTowerToAnotherLocation() {
		// Given
		Towers t = new Towers(2);

		// When
		t.moveTower();

		// Then
		int[] expectedArr = { 1, 2 };
		Node expected = newList(expectedArr);
		assertThat(t.towers[2].getData(), is(equalTo(expected)));
		
		//When
		t.reset();
		t.moveTowerRecursive();
		
		// Then
		assertThat(t.towers[2].getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldMoveThreeElementsTowerToAnotherLocation() {
		// Given
		Towers t = new Towers(3);

		// When
		t.moveTower();

		// Then
		int[] expectedArr = { 1, 2, 3 };
		Node expected = newList(expectedArr);
		assertThat(t.towers[1].getData(), is(equalTo(expected)));
		
		//When
		t.reset();
		t.moveTowerRecursive();
		
		// Then
		assertThat(t.towers[1].getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldMoveFourElementsTowerToAnotherLocation() {
		// Given
		Towers t = new Towers(4);

		// When
		t.moveTower();

		// Then
		int[] expectedArr = { 1, 2, 3, 4 };
		Node expected = newList(expectedArr);
		assertThat(t.towers[2].getData(), is(equalTo(expected)));
		
		//When
		t.reset();
		t.moveTowerRecursive();
		
		// Then
		assertThat(t.towers[2].getData(), is(equalTo(expected)));
	}
}
