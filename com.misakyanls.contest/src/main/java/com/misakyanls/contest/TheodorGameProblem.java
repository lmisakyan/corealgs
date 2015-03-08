package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheodorGameProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());

		Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int[] armies = new int[m];

		for (int i = 0; i < m; ++i) {
			tokenizer = new StringTokenizer(in.readLine());
			armies[i] = Integer.parseInt(tokenizer.nextToken());
		}
		tokenizer = new StringTokenizer(in.readLine());
		int theodorsArmy = Integer.parseInt(tokenizer.nextToken());

		int result = 0;
		for (int i = 0; i < m; ++i) {
			if (Integer.bitCount(armies[i] ^ theodorsArmy) <= k)
				++result;
		}
		out.print(result);
		out.flush();
	}

}
