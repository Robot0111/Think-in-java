package com.think.collect;

import java.util.ArrayList;

import net.mindview.util.Generator;

public class CollectionData<T> extends ArrayList<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CollectionData(Generator<T> gen, int quantity) {
		for(int i = 0; i < quantity; i++) {
			add(gen.next());
		}
		// A generic convenience method;
	}
	public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
		return new CollectionData<T>(gen,quantity);
	}
}
