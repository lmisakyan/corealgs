package ru.corealgs.stacks.pets;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PetsBehaviour {
	@Test
	public void shouldDequeueOldestPet() {
		// Given
		Pets pets = new Pets();

		// When
		pets.enqueue(new Dog());
		pets.enqueue(new Cat());
		pets.enqueue(new Cat());
		Pet oldest = pets.dequeue();

		// Then
		Pet expected = new Dog();
		assertThat(oldest, is(equalTo(expected)));
	}

	@Test
	public void shouldDequeueOldestDog() {
		// Given
		Pets pets = new Pets();

		// When
		pets.enqueue(new Cat());
		pets.enqueue(new Dog());
		pets.enqueue(new Cat());
		Pet oldest = pets.dequeueDog();

		// Then
		Pet expected = new Dog();
		assertThat(oldest, is(equalTo(expected)));
	}

	@Test
	public void shouldDequeueOldestCat() {
		// Given
		Pets pets = new Pets();

		// When
		pets.enqueue(new Dog());
		pets.enqueue(new Cat());
		pets.enqueue(new Dog());
		Pet oldest = pets.dequeueCat();

		// Then
		Pet expected = new Cat();
		assertThat(oldest, is(equalTo(expected)));
	}

	@Test
	public void shouldDequeueOldestAfterCat() {
		// Given
		Pets pets = new Pets();

		// When
		pets.enqueue(new Cat());
		pets.enqueue(new Dog());
		pets.enqueue(new Cat());

		Pet oldest = pets.dequeueCat();

		// Then
		Pet expected = new Cat();
		assertThat(oldest, is(equalTo(expected)));

		// When
		oldest = pets.dequeue();

		// Then
		expected = new Dog();
		assertThat(oldest, is(equalTo(expected)));
	}

}
