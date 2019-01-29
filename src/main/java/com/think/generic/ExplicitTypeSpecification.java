package com.think.generic;

import java.util.List;
import java.util.Map;

import com.think.RTTI.*;

public class ExplicitTypeSpecification {

	static void f(Map<Person,List<Pet>> petPeople) {
		
	}
	public static void main(String[] args) {
		f(New.<Person,List<Pet>>map());
	}
}
