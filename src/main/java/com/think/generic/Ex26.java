package com.think.generic;

import java.util.ArrayList;
import java.util.List;

// generics/Ex26.java
// TIJ4 Chapter Generics, Exercise 26, page 680
// Demonstrate array covariance using Numbers and Integers.

public class Ex26 {
//	public static void main(String[] args) {
//		Number[] numbers = new Integer[3];
//		numbers[0] = new Integer(0);
//		numbers[1] = new Integer(1);
//		numbers[2] = new Integer(2);
//		// Number abstract, cannot instantiate:
//		// numbers[0] = new Number();
//		try { // compile OK; runtime ArrayStoreException:
//			numbers[1] = new Double(3.4);
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//		for(Number n : numbers)
//			System.out.println(n);
//		// compile errors: incompatible types:
//		// Integer[] ints = numbers;
//		// for(Integer n : numbers)
//		//	System.out.println(n);
//		// even though runtime type is Integer:
//		for(Number n : numbers)
//			System.out.println(n.getClass().getSimpleName());	
//	}	
//	27
	public static void main(String[] args) {
		// compile error: incompatible types:
		// List<Number> lnum = new ArrayList<Integer>();
		List<? extends Number> nlist = new ArrayList<Integer>();
		// compile error: can't add Integer:
		// nlist.add(new Integer(0));
		nlist.add(null); // can add null
		Number x = nlist.get(0); // can get Number (null)
		System.out.println(nlist);
	}	
}