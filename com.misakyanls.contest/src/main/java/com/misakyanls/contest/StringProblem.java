package com.misakyanls.contest;

import java.util.Scanner;

public class StringProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("");
		char sep = System.getProperty("line.separator").charAt(0);
		char ch;
		while (sc.hasNext() && (ch = sc.next().charAt(0)) != sep) {
			if (ch != 'A' && ch != 'O' && ch != 'Y' && ch != 'E' && ch != 'U' && ch != 'I' && ch != 'a' && ch != 'o'
					&& ch != 'y' && ch != 'e' && ch != 'u' && ch != 'i') {
				System.out.print('.');
				System.out.print(Character.toLowerCase(ch));
			}
		}
	}
}
