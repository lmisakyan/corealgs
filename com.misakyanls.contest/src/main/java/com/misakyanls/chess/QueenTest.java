package com.misakyanls.chess;

import java.util.Arrays;

import org.junit.Test;

public class QueenTest {
	Queen queen = new Queen();

	@Test
	public void takePositionsTest() {
		int[][] board = new int[6][6];
		queen.setCol(1);
		queen.setRow(2);

		queen.takePositions(board);
		System.out.println(Arrays.deepToString(board));
	}

}
