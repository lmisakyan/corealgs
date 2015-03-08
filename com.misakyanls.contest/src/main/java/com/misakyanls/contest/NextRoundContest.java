package com.misakyanls.contest;

import java.util.Scanner;

public class NextRoundContest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		int points[] = new int[n];

		for (int i = 0; i < n; i++) {
			points[i] = sc.nextInt();
		}

		int kp = points[k - 1];
		if (kp > 0) {
			result = k;
			while (k < n && points[k] == kp) {
				++result;
				++k;	
			}
		} else {
			for (int i = 0; i < k - 1; ++i)
				if (points[i] > 0)
					++result;
		}

		System.out.println(result);
	}
}
