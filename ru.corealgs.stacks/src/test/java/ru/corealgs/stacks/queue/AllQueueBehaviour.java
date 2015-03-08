package ru.corealgs.stacks.queue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ru.corealgs.common.list.AllListsBehaviour;
import ru.corealgs.common.list.Node;

public abstract class AllQueueBehaviour extends AllListsBehaviour {
	protected abstract Queue createQueue();

	@Test
	public void shouldCreateQueue() {
		assertThat(createQueue(), is(not(nullValue())));
	}

	@Test
	public void shouldEnqueueElement() {
		// Given
		Queue q = createQueue();

		// When
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		// Then
		int[] expectedArr = { 1, 2, 3 };
		Node expected = newList(expectedArr);
		assertThat(q.getData(), is(equalTo(expected)));
	}

	@Test
	public void shouldDequeueElement() {
		// Given
		Queue q = createQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		// When
		int i = q.dequeue();
		q.enqueue(4);
		
		// Then
		assertThat(i, is(equalTo(1)));
		assertThat(q.dequeue(), is(equalTo(2)));
	}
}
