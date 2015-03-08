package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		long n = Long.parseLong(tokenizer.nextToken());
		long m = Long.parseLong(tokenizer.nextToken());
		long a = Long.parseLong(tokenizer.nextToken());
		long result = (n / a + ((n % a) > 0 ? 1 : 0)) * (m / a + ((m % a) > 0 ? 1 : 0));
		System.out.println(result);
	}

}
