package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongWords {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		String cur;
		int curLength;

		for (int i = 0; i < n; ++i) {
			cur = in.readLine();
			curLength = cur.length();
			System.out.println(curLength <= 10 ? cur : cur.charAt(0) + String.valueOf(curLength - 2)
					+ cur.charAt(curLength - 1));
		}

	}

}
