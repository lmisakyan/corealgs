package com.misakyanls.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChessProblem {
	private static int[] b;

	static boolean unsafe(int y) {
		int x = b[y];
		for (int i = 1; i <= y; i++) {
			int t = b[y - i];
			if (t == x || t == x - i || t == x + i) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		b = new int[n];

		int s = 0;
		int y = 0;
		b[0] = -1;
		while (y >= 0) {
			do {
				b[y]++;
			} while ((b[y] < m) && unsafe(y));
			if (b[y] < m) {
				if (y < n - 1) {
					b[++y] = -1;
				} else {
					++s;
				}
			} else {
				y--;
			}
		}

		out.println(s);
		out.flush();
	}
}
