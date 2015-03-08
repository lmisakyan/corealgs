package com.misakyanls.contest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class TramStops {
	@Test
	public void shouldReturnSix() {
		int minCapacity = getMinimalCapacity(4, new OutIn[] { new OutIn(0, 3), new OutIn(2, 5), new OutIn(4, 2),
				new OutIn(4, 0) });
		assertThat(minCapacity, is(6));
	}
	
	@Test
	public void shouldReturnZero() {
		int minCapacity = getMinimalCapacity(2, new OutIn[] { new OutIn(0, 0), new OutIn(0, 0) });
		assertThat(minCapacity, is(0));
	}
	
	@Test
	public void shouldReturnTen() {
		int minCapacity = getMinimalCapacity(4, new OutIn[] { new OutIn(0, 3), new OutIn(0, 5), new OutIn(0, 2),
				new OutIn(10, 0) });
		assertThat(minCapacity, is(10));
	}

	private int getMinimalCapacity(int i, OutIn[] stops) {
		int minimalCapacity = 0;
		int currentCapacity = 0;

		for (OutIn stop : stops) {
			currentCapacity = currentCapacity - stop.getOutCount() + stop.getInCount();
			if (currentCapacity > minimalCapacity)
				minimalCapacity = currentCapacity;
		}

		return minimalCapacity;
	}
}
