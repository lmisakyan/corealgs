package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntiqProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int v = Integer.parseInt(tokenizer.nextToken());

		int result = 0;
		StringBuilder numbers = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			tokenizer = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(tokenizer.nextToken());
			for (int j = 0; j < cnt; ++j) {
				if (v > Integer.parseInt(tokenizer.nextToken())) {
					result++;
					numbers.append(i + 1 + " ");
					break;
				}
			}
		}

		System.out.println(result);
		System.out.print(numbers.toString());
	}
}
