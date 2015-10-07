package com.misakyanls.chess;

public abstract class ChessPiece {
	protected int row = -1, col = -1;

	protected abstract void markTakePositions(int[][] board, boolean remove);

	protected void remove(int[][] board) {
		if (row == -1)
			return;
		board[row][col] = 0;
		setCol(-1);
		setRow(-1);
	}

	protected boolean set(int[][] board, int row, int col) {
		this.col = col;
		this.row = row;
		markTakePositions(board, false);
		board[row][col] = -1;
		return true;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
