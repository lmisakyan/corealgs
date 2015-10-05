package com.misakyanls.chess;

import java.util.Arrays;

import org.junit.Test;

public class QueenTest {
	Queen queen = new Queen();

	@Test
	public void takePositionsTest() {
		int[][] board = new int[3][3];
		queen.set(board, 2, 2);
		System.out.println(Arrays.deepToString(board));
	}

}
