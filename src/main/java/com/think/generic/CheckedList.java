package com.think.generic;

import java.util.ArrayList;
import java.util.List;

public class CheckedList {

	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}
	
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
	}
	//FIXME
}
