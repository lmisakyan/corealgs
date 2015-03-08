package com.misakyanls.contest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class NextRound {
	@Test
	public void shouldReturnFive() {
		int nextCnt = getNextRoundCount(8, 5, new int[] { 10, 9, 8, 7, 7, 6, 5, 5 });
		assertThat(nextCnt, is(5));

		nextCnt = getNextRoundCountSmart(8, 5, new int[] { 10, 9, 8, 7, 7, 6, 5, 5 });
		assertThat(nextCnt, is(5));
	}

	@Test
	public void shouldReturnSix() {
		int nextCnt = getNextRoundCount(8, 5, new int[] { 10, 9, 8, 7, 7, 7, 5, 5 });
		assertThat(nextCnt, is(6));

		nextCnt = getNextRoundCountSmart(8, 5, new int[] { 10, 9, 8, 7, 7, 7, 5, 5 });
		assertThat(nextCnt, is(6));
	}

	@Test
	public void shouldReturnZero() {
		int nextCnt = getNextRoundCount(4, 2, new int[] { 0, 0, 0, 0 });
		assertThat(nextCnt, is(0));

		nextCnt = getNextRoundCountSmart(4, 2, new int[] { 0, 0, 0, 0 });
		assertThat(nextCnt, is(0));
	}

	@Test
	public void shouldReturnOne() {
		int nextCnt = getNextRoundCount(1, 1, new int[] { 1 });
		assertThat(nextCnt, is(1));

		nextCnt = getNextRoundCountSmart(1, 1, new int[] { 1 });
		assertThat(nextCnt, is(1));
	}

	@Test
	public void shouldReturnEight() {
		int nextCnt = getNextRoundCount(8, 5, new int[] { 9, 9, 9, 9, 9, 9, 9, 9 });
		assertThat(nextCnt, is(8));

		nextCnt = getNextRoundCountSmart(8, 5, new int[] { 9, 9, 9, 9, 9, 9, 9, 9 });
		assertThat(nextCnt, is(8));
	}

	@Test
	public void shouldReturnTwo() {
		int nextCnt = getNextRoundCount(9, 3, new int[] { 9, 9, 0, 0, 0, 0, 0, 0, 0 });
		assertThat(nextCnt, is(2));

		nextCnt = getNextRoundCountSmart(9, 3, new int[] { 9, 9, 0, 0, 0, 0, 0, 0, 0 });
		assertThat(nextCnt, is(2));

	}

	private int getNextRoundCount(int n, int k, int[] points) {
		int result = 0;
		for (int i = 0; i < points.length; ++i) {
			if (points[i] > 0 && points[i] >= points[k - 1])
				++result;
		}
		return result;
	}

	private int getNextRoundCountSmart(int n, int k, int[] points) {
		int result = 0;
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

		return result;
	}
}
