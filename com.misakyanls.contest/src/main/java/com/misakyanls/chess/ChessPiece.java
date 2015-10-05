package com.misakyanls.chess;

public abstract class ChessPiece {
	protected int row, col;

	protected abstract void takePositions(int[][] board);

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
