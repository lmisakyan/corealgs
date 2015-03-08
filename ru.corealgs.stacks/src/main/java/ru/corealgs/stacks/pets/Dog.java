package ru.corealgs.stacks.pets;


public class Dog implements Pet {

	@Override
	public String getName() {
		return "Dog";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Dog)) {
			return false;
		}
		
		return true;
	}

}
