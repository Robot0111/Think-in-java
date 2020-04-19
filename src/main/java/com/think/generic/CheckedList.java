package com.think.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.think.RTTI.Cat;
import com.think.RTTI.Dog;
import com.think.RTTI.Pet;

public class CheckedList {

	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}
	
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStyleMethod(dogs2);
		} catch (Exception e) {
			System.err.println(e);
		}
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		
		pets.add(new Dog());
		pets.add(new Cat());
		
	}
	
}
