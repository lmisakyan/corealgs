package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TaxiProblem {
	private static final int CAR_CAPACITY = 4;

	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		String teamsStr = in.readLine();

		List<Integer> teams = new LinkedList<Integer>();

		for (int i = 0; i < teamsStr.length(); i += 2) {
			teams.add(Character.getNumericValue(teamsStr.charAt(i)));
		}

		Collections.sort(teams);
		int reminder;
		while (!teams.isEmpty()) {
			++result;
			reminder = CAR_CAPACITY - teams.remove(teams.size() - 1);
			if (reminder > 0) {
				while (!teams.isEmpty()) {
					if ((reminder -= teams.get(0)) < 0) {
						break;
					}
					teams.remove(0);
				}
			}
		}

		System.out.println(result);
	}
}
