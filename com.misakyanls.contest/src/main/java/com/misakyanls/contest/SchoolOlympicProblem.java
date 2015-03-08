package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SchoolOlympicProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		List<Integer> t1 = new ArrayList<Integer>(n), t2 = new ArrayList<Integer>(
				n), t3 = new ArrayList<Integer>(n);

		tokenizer = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; ++i) {
			switch (Integer.parseInt(tokenizer.nextToken())) {
			case 1:
				t1.add(i);
				break;
			case 2:
				t2.add(i);
				break;
			case 3:
				t3.add(i);
				break;
			}
		}

		int min = Math.min(t1.size(), Math.min(t2.size(), t3.size()));
		out.println(min);
		for (int i = 0; i < min; ++i) {
			out.println(t1.get(i) + " " + t2.get(i) + " " + t3.get(i));
		}
		out.flush();
	}
}
