package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Given a list of N integers, your task is to select K integers from the list
 * such that its unfairness is minimized. 
 * 
 * <p>If (x1,x2,x3,…,xk) are K numbers
 * selected from the list N, the unfairness is defined as
 * <p><blockquote><pre>
 *   max(x1,x2,…,xk)−min(x1,x2,…,xk)
 * </pre></blockquote> 
 * where max denotes the largest integer among
 * the elements of K, and min denotes the smallest integer among the elements of K.
 * 
 * @author lmisakyan
 */
public class MaxMin {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[] list = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(in.readLine());

		Arrays.sort(list);
		int unfairness = Integer.MAX_VALUE;

		for (int i = 0; i < N - K + 1; i++) {
			int min = list[i];
			int max = list[i + K - 1];
			unfairness = Math.min(unfairness, max - min);
		}

		out.print(unfairness);
		out.flush();
	}
}