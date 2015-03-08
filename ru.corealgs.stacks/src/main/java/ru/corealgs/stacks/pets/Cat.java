package ru.corealgs.stacks.pets;

public class Cat implements Pet {

	@Override
	public String getName() {
		return "Cat";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cat)) {
			return false;
		}
		
		return true;
	}


}
