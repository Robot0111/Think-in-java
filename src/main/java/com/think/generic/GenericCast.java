package com.think.generic;

import java.util.ArrayList;

//class FixedSizeStack<T>{
//	private int index = 0;
//	private Object[] storage;
//	public FixedSizeStack(int size) {
//		storage = new Object[size];
//	}
//	public void push(T item) {
//		storage[index++] = item;
//	}
//	@SuppressWarnings("unchecked")
//	public T pop() {return (T)storage[--index];}
//}
//
//public class GenericCast {
//	public static final int SIZE = 10;
//	public static void main(String[] args) {
//		FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
//		for(String s: "A B C D E F G H I J".split(" "))
//			strings.push(s);
//		for(int i = 0; i< SIZE; i++) {
//			String s = strings.pop();
//			System.err.println(s + " ");
//		}
//	}
//}
class VariableSizeStack<T> { 
	private ArrayList<T> storage = new ArrayList<T>();
    	public int count() {
		return storage.size();
    	} 
    	public void push(T item) { 
		storage.add(item); 
    	}
    	public T pop() { 
		return storage.remove(storage.size() - 1);
    	}
}

public class GenericCast {
 	public static void main(String[] args) {
        	VariableSizeStack<String> strings =
            		new VariableSizeStack<String>();
        	for(String s : "A B C D E F G H I J".split(" "))
            		strings.push(s);
		int currentCount = strings.count();
		for(int i = 0; i < currentCount; i++) {
            	String s = strings.pop();
            	System.out.print(s + " ");
		}	    
    	}        
}