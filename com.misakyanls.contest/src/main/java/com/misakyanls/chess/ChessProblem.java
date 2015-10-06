package com.misakyanls.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ChessProblem {
	private static int[][] board;

	static List<ChessPiece> createPieces(BufferedReader in) throws IOException {
		int kings = 0, queens = 0, bishops = 0, rooks = 0, knights = 0;
		List<ChessPiece> result = new ArrayList<>();
		String line = null;
		while ((line = in.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			switch (tokenizer.nextToken()) {
			case "K":
				kings = Integer.parseInt(tokenizer.nextToken());
				break;
			case "Q":
				queens = Integer.parseInt(tokenizer.nextToken());
				break;
			case "B":
				bishops = Integer.parseInt(tokenizer.nextToken());
				break;
			case "R":
				rooks = Integer.parseInt(tokenizer.nextToken());
				break;
			case "N":
				knights = Integer.parseInt(tokenizer.nextToken());
				break;
			}
		}
		for (int i = 0; i < queens; ++i)
			result.add(new Queen());
		for (int i = 0; i < rooks; ++i)
			result.add(new Rook());
		for (int i = 0; i < knights; ++i)
			result.add(new Knight());
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		int result = 0;

		board = new int[m][n];
		List<ChessPiece> pieces = createPieces(in);
		int pieceCount = pieces.size();
		int y = 0;
		boolean newPiece = true;
		ChessPiece piece = pieces.get(y);
		while (y >= 0) {
			if (canStand(piece, newPiece))
				if (y < pieceCount - 1) {
					ChessPiece prev = piece;
					piece = pieces.get(++y);
					if (prev.getClass() == piece.getClass()) {
						piece.setRow(prev.getRow());
						piece.setCol(prev.getCol());
					}
					newPiece = true;
				} else {
					++result;
					System.out.println(Arrays.deepToString(board));
					piece.markTakePositions(board, true);
				}
			else if (--y >= 0) {
				piece.remove(board);
				piece = pieces.get(y);
				piece.markTakePositions(board, true);
				newPiece = false;
			}
		}
		out.println(result);
		out.flush();
	}

	private static boolean canStand(ChessPiece piece, boolean newPiece) {
		int r = piece.getRow();
		int c = piece.getCol();
		r = r == -1 ? 0 : r;
		c = c == -1 ? 0 : c + 1;
		while (r < board.length) {
			while (c < board[r].length) {
				if (board[r][c] == 0) {
					if (!newPiece)
						piece.remove(board);
					return piece.set(board, r, c);
				}
				++c;
			}
			c = 0;
			++r;
		}
		return false;
	}
}
