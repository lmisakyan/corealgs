package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YablovProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		char[][] chessBoard = new char[n][];
		
		for (int i = 0; i < n; ++i) {
			chessBoard[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < n; ++i) 
			for (int j = 0; j < n; ++j) {
				int cnt = (j == 0     ? 0 : (chessBoard[i][j - 1] == 'o' ? 1 : 0)) + 
						  (j == n - 1 ? 0 : (chessBoard[i][j + 1] == 'o' ? 1 : 0)) + 
						  (i == 0     ? 0 : (chessBoard[i - 1][j] == 'o' ? 1 : 0)) + 
						  (i == n - 1 ? 0 : (chessBoard[i + 1][j] == 'o' ? 1 : 0));
				if ((cnt & 1) == 1) {
					System.out.print("NO");
					System.exit(0);
				}
			}
		System.out.print("YES");
	}

}
