package com.think.generic;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
	public static void main(String[] args) {
		
		//compile error : incompatible types; apple 的list 不等价于 fruit
		//List<Fruit> list = new ArrayList<Apple>();
	}
}
