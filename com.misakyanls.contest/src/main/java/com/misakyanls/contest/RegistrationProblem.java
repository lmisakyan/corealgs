package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RegistrationProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine());
		Map<String, Integer> names = new HashMap<String, Integer>(n);

		for (int i = 0; i < n; ++i) {
			String name = in.readLine();
			Integer suffix;
			if ((suffix = names.put(name, 0)) != null) {
				suffix = new Integer(suffix.intValue() + 1);
				names.put(name, suffix);
				out.println(name + suffix);
			} else
				out.println("OK");
		}
		out.flush();
	}
}
