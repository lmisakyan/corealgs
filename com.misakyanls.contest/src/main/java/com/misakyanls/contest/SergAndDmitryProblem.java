package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SergAndDmitryProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());

		int SResult = 0, DResult = 0, startIndex = 0, n = Integer.parseInt(tokenizer.nextToken()), endIndex = n - 1;
		int[] cards = new int[n];

		tokenizer = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; ++i) {
			cards[i] = Integer.parseInt(tokenizer.nextToken());
		}

		while (startIndex <= endIndex) {
			int valueAtStart = cards[startIndex];
			int valueAtEnd = cards[endIndex];
			if (valueAtStart >= valueAtEnd) {
				SResult += valueAtStart;
				startIndex++;
			} else {
				SResult += valueAtEnd;
				endIndex--;
			}

			if (startIndex <= endIndex) {
				valueAtStart = cards[startIndex];
				valueAtEnd = cards[endIndex];
				if (valueAtStart >= valueAtEnd) {
					DResult += valueAtStart;
					startIndex++;
				} else {
					DResult += valueAtEnd;
					endIndex--;
				}
			}
		}
		System.out.print(SResult + " " + DResult);
	}
}
