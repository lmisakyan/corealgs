package com.misakyanls.chess;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KnightTest {
	Knight knight = new Knight();

	@Test
	public void takePositionsTest() {
		int[][] board = new int[5][5];
		knight.set(board, 2, 2);
		assertThat(board[0], is(new int[] { 0, 1, 0, 1, 0 }));
		assertThat(board[1], is(new int[] { 1, 0, 0, 0, 1 }));
		assertThat(board[2], is(new int[] { 0, 0, -1, 0, 0 }));
		assertThat(board[3], is(new int[] { 1, 0, 0, 0, 1 }));
		assertThat(board[4], is(new int[] { 0, 1, 0, 1, 0 }));
	}

	@Test
	public void takePositionsTLCornerTest() {
		int[][] board = new int[4][4];
		knight.set(board, 0, 0);
		assertThat(board[0], is(new int[] { -1, 0, 0, 0 }));
		assertThat(board[1], is(new int[] { 0, 0, 1, 0 }));
		assertThat(board[2], is(new int[] { 0, 1, 0, 0 }));
		assertThat(board[3], is(new int[] { 0, 0, 0, 0 }));
	}

	@Test
	public void takePositionsDRCornerTest() {
		int[][] board = new int[4][4];
		knight.set(board, 3, 3);
		assertThat(board[0], is(new int[] { 0, 0, 0, 0 }));
		assertThat(board[1], is(new int[] { 0, 0, 1, 0 }));
		assertThat(board[2], is(new int[] { 0, 1, 0, 0 }));
		assertThat(board[3], is(new int[] { 0, 0, 0, -1 }));
	}

	@Test
	public void takePositionsUnderThreatTest() {
		int[][] board = new int[4][4];
		board[2][1] = -1;
		assertThat(knight.set(board, 3, 3), is(false));
		assertThat(board[1], is(new int[] { 0, 0, 0, 0 }));

		board[2][1] = 0;
		board[1][2] = -1;
		assertThat(knight.set(board, 3, 3), is(false));
		assertThat(board[2], is(new int[] { 0, 0, 0, 0 }));
	}
}
