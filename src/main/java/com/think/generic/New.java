package com.think.generic;

import java.util.*;

public class New {
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	public static <T> Set<T> set(){
		return new HashSet<>();
	}
	public static <T> Queue<T> queue(){
		return new LinkedList<>();                                                                                                                                                                                                                                                                                                                                    
	}
	public static void main(String[] args) {
		Map<String,List<String>> lsl = New.map();
		List<String> ls = New.list();
	}
}
