package com.think.注解;

import Annotation.ExtractInterface;

@ExtractInterface("IMultiplier")
public class Mulptiplier {
public int multiply(int x,int y) {
	int total = 0;
	for(int i = 0;i<x;i++)
		total = add(total,y);
	return total;
}
private int add(int x,int y) {
	return x + y;
}
public static void main(String[] args) {
	Mulptiplier  m = new Mulptiplier();
	System.out.println("11*16=" +m.multiply(11, 16));
}
}
