package com.misakyanls.chess;

public class Knight extends ChessPiece {

	@Override
	protected void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		if (row - 2 >= 0) {
			if (col - 1 >= 0)
				board[row - 2][col - 1] = board[row - 2][col - 1] + inc;
			if (col + 1 < board[row - 2].length)
				board[row - 2][col + 1] = board[row - 2][col + 1] + inc;
		}
		if (row - 1 >= 0) {
			if (col - 2 >= 0)
				board[row - 1][col - 2] = board[row - 1][col - 2] + inc;
			if (col + 2 < board[row - 1].length)
				board[row - 1][col + 2] = board[row - 1][col + 2] + inc;
		}
		if (row + 2 < board.length) {
			if (col - 1 >= 0)
				board[row + 2][col - 1] = board[row + 2][col - 1] + inc;
			if (col + 1 < board[row + 2].length)
				board[row + 2][col + 1] = board[row + 2][col + 1] + inc;
		}
		if (row + 1 < board.length) {
			if (col - 2 >= 0)
				board[row + 1][col - 2] = board[row + 1][col - 2] + inc;
			if (col + 2 < board[row + 1].length)
				board[row + 1][col + 2] = board[row + 1][col + 2] + inc;
		}

	}

	@Override
	protected boolean set(int[][] board, int row, int col) {
		if (row - 2 >= 0) {
			if (col - 1 >= 0)
				if (board[row - 2][col - 1] < 0)
					return false;
			if (col + 1 < board[row - 2].length)
				if (board[row - 2][col + 1] < 0)
					return false;
		}
		if (row - 1 >= 0) {
			if (col - 2 >= 0)
				if (board[row - 1][col - 2] < 0)
					return false;
			if (col + 2 < board[row - 1].length)
				if (board[row - 1][col + 2] < 0)
					return false;
		}
		if (row + 2 < board.length) {
			if (col - 1 >= 0)
				if (board[row + 2][col - 1] < 0)
					return false;
			if (col + 1 < board[row + 2].length)
				if (board[row + 2][col + 1] < 0)
					return false;
		}
		if (row + 1 < board.length) {
			if (col - 2 >= 0)
				if (board[row + 1][col - 2] < 0)
					return false;
			if (col + 2 < board[row + 1].length)
				if (board[row + 1][col + 2] < 0)
					return false;
		}
		return super.set(board, row, col);
	}

}
