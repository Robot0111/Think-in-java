/**
 * 
 */
package com.think.generic;

/**
 * @author luQl
 *
 */
public class Holder<T> {
	private T value;

	public Holder(T val) {
		value = val;
	}

	public Holder() {
	}

	public void set(T val) {
		value = val;
	}

	public T get() {
		return value;
	}

	public boolean equals(Object obj) {
		return value.equals(obj);
	}
}
