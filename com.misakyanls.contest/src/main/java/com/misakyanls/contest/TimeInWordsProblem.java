package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TimeInWordsProblem {
	private static final String[] hours = { "", " one", " two", " three",
			" four", " five", " six", " seven", " eight", " nine", " ten",
			" eleven", " twelve" };

	private static final String[] minutes = { "", "one", "two", "three",
			"four", " ive", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "quarter", "sixteen",
			"seventeen", "eighteen", "nineteen", "twenty", "twenty one",
			"twenty  two", "twenty  three", "twenty four", "twenty five",
			"twenty six", "twenty seven", "twenty eight", "twenty nine", "half" };

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int hour = Integer.parseInt(in.readLine());
		int minute = Integer.parseInt(in.readLine());

		if (minute == 0)
			out.print((hours[hour] + " o' clock").trim());
		else if (minute <= 30)
			out.print(minutes[minute]
					+ (minute != 30 && minute != 15 ? " minute" : "")
					+ (minute == 1 || minute == 21 || minute == 15
							|| minute == 30 ? "" : "s") + " past" + hours[hour]);
		else {
			int toMinute = 60 - minute;
			out.print(minutes[toMinute]
					+ (toMinute != 15 ? " minute" : "")
					+ (toMinute == 1 || toMinute == 21 || toMinute == 15 ? ""
							: "s") + " to" + hours[(hour == 12 ? 1 : hour + 1)]);
		}
		out.flush();
	}

}
