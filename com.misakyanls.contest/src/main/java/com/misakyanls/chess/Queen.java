package com.misakyanls.chess;

public class Queen extends ChessPiece {

	@Override
	protected void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		for (int i = 0; i < board[row].length; ++i) {
			board[row][i] = board[row][i] + inc;
			int offset = Math.abs(col - i);
			if (row - offset >= 0 && row - offset < board.length)
				board[row - offset][i] = board[row - offset][i] + inc;
			if (row + offset >= 0 && row + offset < board.length)
				board[row + offset][i] = board[row + offset][i] + inc;
		}

		for (int i = 0; i < board.length; ++i) {
			board[i][col] = board[i][col] + inc;
		}

	}

	@Override
	protected void remove(int[][] board) {
		if (row == -1)
			return;
		board[row][col] = 0;
		//setRow(-1);
		//setCol(-1);
	}

	@Override
	protected boolean set(int[][] board, int row, int col) {
		this.col = col;
		this.row = row;
		markTakePositions(board, false);
		board[row][col] = -1;
		return true;
	}
}
