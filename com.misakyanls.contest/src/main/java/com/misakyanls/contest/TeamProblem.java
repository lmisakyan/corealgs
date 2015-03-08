package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TeamProblem {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int result = 0;
		int cnt;
		StringTokenizer tokenizer;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; ++i) {
			cnt = 0;
			tokenizer = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; ++j) {
				cnt += Integer.parseInt(tokenizer.nextToken());
			}
			result += cnt >= 2 ? 1 : 0;
		}

		System.out.println(result);
	}

}
