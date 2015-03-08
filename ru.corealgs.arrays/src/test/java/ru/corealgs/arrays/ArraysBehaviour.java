package ru.corealgs.arrays;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

public class ArraysBehaviour {

	@Test
	public void isAllCharsUnique_shouldReturnTrueWhenAllCharsUnique() {
		assertThat(Arrays.isAllCharsUnique("abcd"), is(true));
	}

	@Test
	public void isAllCharsUnique_shouldReturnFalseWhenAllCharsNotUnique() {
		assertThat(Arrays.isAllCharsUnique("abcda"), is(not(true)));
	}

	@Test
	public void isFromOtherString_shouldReturnTrueWhenStringIsFromOther() {
		assertThat(Arrays.isFromOtherString("abcd", "badc"), is(true));
		assertThat(Arrays.isFromOtherString("aabbcd", "bbaadc"), is(true));
	}

	@Test
	public void isFromOtherString_shouldReturnFalseWhenStringIsOriginal() {
		assertThat(Arrays.isFromOtherString("abcd", "banc"), is(not(true)));
		assertThat(Arrays.isFromOtherString("abcd", "aacd"), is(not(true)));
	}

	@Test
	public void isFromOtherString_shouldReturnFalseWhenStringsIsEqual() {
		assertThat(Arrays.isFromOtherString("abcd", "abcd"), is(not(true)));
	}

	@Test
	public void replaceSpaces_shouldReplaceSpacesWith20() {
		assertThat(Arrays.replaceSpaces("mr John Smith"),
				is("mr%20John%20Smith"));
	}

	@Test
	public void compressString_shouldCompressOrReturnSameString() {
		assertThat(Arrays.compressString("0aaaabbbccd"), is("01a4b3c2d1"));
		assertThat(Arrays.compressString("aabc"), is("aabc"));
	}

	@Test
	public void rotateMatrix90ClockWise_shouldRotateMatrix3x3() {
		// Given matrix
		int[][] matrix = { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, } };
		int[][] resultMatrix = { { 7, 4, 1, }, { 8, 5, 2, }, { 9, 6, 3, } };

		assertThat(Arrays.rotateNxNMatrix90DegreesClockWise(matrix),
				is(resultMatrix));

	}

	@Test
	public void rotateMatrix90ClockWise_shouldRotateMatrix4x4() {
		// Given matrix
		int[][] matrix = { { 1, 2, 3, 4, }, { 5, 6, 7, 8, },
				{ 9, 10, 11, 12, }, { 13, 14, 15, 16, } };
		int[][] resultMatrix = { { 13, 9, 5, 1, }, { 14, 10, 6, 2, },
				{ 15, 11, 7, 3, }, { 16, 12, 8, 4, } };

		assertThat(Arrays.rotateNxNMatrix90DegreesClockWise(matrix),
				is(resultMatrix));

	}

	@Test
	public void zeroRowNColumn_shouldZeroRowNColumnIfElementIsZero() {
		// Given matrix
		int[][] matrix = { { 1, 2, 3, 4, }, 
				           { 5, 6, 7, 8, }, 
				           { 9, 0, 11, 12, },
				          { 13, 14, 15, 16, } };
		int[][] resultMatrix = { { 1, 0, 3, 4, }, 
				                 { 5, 0, 7, 8, },
				                 { 0, 0, 0, 0, }, 
				                { 13, 0, 15, 16, } };

		// When
		Arrays.zeroRowNColumn(matrix);

		// Then
		assertThat(matrix, is(equalTo(resultMatrix)));
	}

	@Test
	public void zeroRowNColumn_shouldLeaveIfNoElementIsZero() {
		// Given matrix
		int[][] matrix = { { 1, 2, 3, 4, }, { 5, 6, 7, 8, },
				{ 9, 10, 11, 12, }, { 13, 14, 15, 16, } };
		// When
		Arrays.zeroRowNColumn(matrix);

		// Then
		assertThat(matrix, is(equalTo(matrix)));
	}
	
	@Test
	public void zeroRowNColumn_shouldZeroRowNColumnIfMoreThanOneElementIsZero() {
		// Given matrix
		int[][] matrix = { { 1, 2, 0, 4, }, 
				           { 5, 6, 7, 8, }, 
				           { 9, 0, 11, 12, } };
		int[][] resultMatrix = { { 0, 0, 0, 0, }, 
				                 { 5, 0, 0, 8, },
								 { 0, 0, 0, 0, } };

		// When
		Arrays.zeroRowNColumn(matrix);

		// Then
		assertThat(matrix, is(equalTo(resultMatrix)));
	}
}
