package ru.corealgs.arrays.buffer;

import java.util.Arrays;

public class StringBuffer {

	final int INCREMENT = 0x00000020;
	private char[] strings;
	private int current;

	void resizeBuffer(int length) {
		strings = Arrays.copyOf(strings, strings.length
				+ ((length / INCREMENT) + 1) * INCREMENT);
	}

	public StringBuffer() {
		this.strings = new char[0];
		this.current = 0;
	}

	public void append(String string) {
		int length = string.length();
		int bufferLength = strings.length;

		if (current + length <= bufferLength) {
			string.getChars(0, length, strings, current);
			current += length;
		} else {
			resizeBuffer(length - (bufferLength - current));
			append(string);
		}
	}

	public String toString() {
		return new String(this.strings, 0, this.current);
	}
}
