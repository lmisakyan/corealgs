package com.misakyanls.chess;

public class Queen extends ChessPiece {

	@Override
	public void takePositions(int[][] board) {
		for (int i = 0; i < board[row].length; ++i) {
			board[row][i]++;
			int offset = Math.abs(col - i);
			if (row - offset >= 0 && row - offset < board.length)
				board[row - offset][i]++;
			if (row + offset >= 0 && row + offset < board.length)
				board[row + offset][i]++;
		}

		for (int i = 0; i < board.length; ++i) {
			board[i][col]++;
		}

		board[row][col] = -1;
	}
}
