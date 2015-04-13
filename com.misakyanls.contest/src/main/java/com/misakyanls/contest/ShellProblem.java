package com.misakyanls.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShellProblem {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine());
		StringBuilder current = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			if (tokenizer.nextToken().equals("pwd"))
				out.println(current + "/");
			else {
				String curPath = tokenizer.nextToken();
				if (curPath.startsWith("/")) 
					current = new StringBuilder();
				tokenizer = new StringTokenizer(curPath, "/");
				while (tokenizer.hasMoreTokens()) {
					String curDir = tokenizer.nextToken();
					if (curDir.equals(".."))
						current.delete(current.lastIndexOf("/"), current.length());
					else
						current.append("/" + curDir);
				}
			}
		}
		out.flush();
	}
}
