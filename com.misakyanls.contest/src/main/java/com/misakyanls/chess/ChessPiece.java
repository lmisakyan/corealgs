package com.misakyanls.chess;

public abstract class ChessPiece {
	protected int row = -1, col = -1;

	protected abstract void markTakePositions(int[][] board, boolean remove);

	protected abstract void remove(int[][] board);

	protected abstract boolean set(int[][] board, int row, int col);

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
