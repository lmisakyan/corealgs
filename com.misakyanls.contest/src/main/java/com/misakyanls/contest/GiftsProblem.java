package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GiftsProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());

		int[] result = new int[n];

		for (int i = 0; i < n; ++i) {
			result[Integer.parseInt(tokenizer.nextToken()) - 1] = i + 1;
		}

		for (int i = 0; i < n; ++i) {
			System.out.print(result[i] + " ");
		}

	}

}
