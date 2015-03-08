package ru.corealgs.arrays;

import java.util.HashMap;
import java.util.Map;

public class Arrays {

	public static void main(String[] args) {

	}

	private static int charCount(char c, String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				cnt++;
			}
		}
		return cnt;
	}

	public static Boolean isAllCharsUnique(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (charCount(s.charAt(i), s) > 1) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isFromOtherString(String original, String str) {
		if (original.equals(str)) {
			return false;
		}

		if (original.length() != str.length()) {
			return false;
		}

		char c;
		String s;
		Map<String, Integer> chars = new HashMap<String, Integer>();

		for (int i = 0; i < original.length(); i++) {
			c = str.charAt(i);
			s = String.valueOf(c);
			if (!chars.containsKey(s)) {
				chars.put(s, charCount(c, original));
			}
		}

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (chars.get(String.valueOf(c)) != charCount(c, str)) {
				return false;
			}
		}
		return true;
	}

	public static String replaceSpaces(String s) {
		int sc = charCount(' ', s);
		char[] value = new char[s.length() + sc * 2];

		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				value[pos] = c;
				pos++;
			} else {
				"%20".getChars(0, 3, value, pos);
				pos += 3;
			}
		}

		return new String(value);
	}

	public static String compressString(String s) {
		char c;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length();) {
			c = s.charAt(i);
			int cnt = inRowCharCount(s, c, i);
			sb.append(c).append(cnt);
			i += cnt;
		}

		return sb.length() < s.length() ? sb.toString() : s;
	}

	private static int inRowCharCount(String s, char c, int pos) {
		Integer cnt = 1;
		for (int i = ++pos; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				cnt++;
			} else {
				return cnt;
			}
		}
		return cnt;
	}

	public static int[][] rotateNxNMatrix90DegreesClockWise(int[][] matrix) {
		int n = matrix.length;
		int[][] rotated = new int[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				rotated[j][i] = matrix[0 + ((n - 1) - i)][j];
			}
		}

		return rotated;
	}

	public static void zeroRowNColumn(int[][] matrix) {
		int[][] result = new int[matrix.length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = java.util.Arrays.copyOf(matrix[i], matrix[i].length);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					doZeroRowNColumn(result, i, j);
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			matrix[i] = java.util.Arrays.copyOf(result[i], result[i].length);
		}
	}

	public static void doZeroRowNColumn(int[][] matrix, int row, int column) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == row || j == column) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
