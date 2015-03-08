package ru.corealgs.arrays.buffer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class StringBufferBehaviour {

	@Test
	public void shouldAppend() {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.append("b");
		assertThat(sb.toString(), is("b"));
	}

	@Test
	public void shouldAppendStringThatIsLongerThanIncrement() {
		StringBuffer sb = new StringBuffer();
		StringBuffer spy = spy(sb);
		
		spy.append("01234567890123456789012345678901234");
		
		verify(spy).resizeBuffer(35);

		assertThat(
				spy.toString(),
				is("01234567890123456789012345678901234"));
	}
}
