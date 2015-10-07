package com.misakyanls.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
			for (int i = 0; i < queens; ++i)
				result.add(new Queen());
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		board = new int[m][n];
		List<ChessPiece> pieces = createPieces(in);

		int result = 0;
		int y = 0;
		ChessPiece piece = pieces.get(y);

		while (y >= 0) {
			if (canStand(piece))
				if (y < n - 1) {
					piece = pieces.get(++y);
				} else {
					++result;
				}
			else if (--y >= 0) {
				piece.remove(board);
				piece = pieces.get(y);
			}
		}

		out.println(result);
		out.flush();
	}

	private static boolean canStand(ChessPiece piece) {
		if (piece.getRow() != -1)
			piece.markTakePositions(board, true);

		int r = piece.getRow();
		int c = piece.getCol();
		while ((r = r == -1 ? 0 : r) < board.length) {
			while ((c = c == -1 ? 0 : c) < board[r].length) {
				if (board[r][c] == 0) {
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
