package com.think.collect;

import java.util.Arrays;
import java.util.Random;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

public class CompType implements Comparable<CompType> {
	int i, j;
	private static int count = 1;

	public CompType(int n1, int n2) {
		i = n1;
		j = n2;
	}

	@Override
	public String toString() {
		String result = "CompType [i=" + i + ", j=" + j + "]";
		if (count++ % 3 == 0)
			result += "\n";
		return result;
	}

	@Override
	public int compareTo(CompType o) {

		return (i < o.i ? -1 : (i == o.i ? 0 : 1));
	}

	private static Random r = new Random(47);

	public static Generator<CompType> generator() {
		return new Generator<CompType>() {
			@Override
			public CompType next() {
				// TODO Auto-generated method stub
				return new CompType(r.nextInt(100), r.nextInt(100));
			}
		};
	}
	public static void main(String[] args) {
		CompType[] a = Generated.array(new CompType[12], generator());
		System.out.print(Arrays.toString(a));
		
		Arrays.sort(a);
		System.out.print(Arrays.toString(a));
	}
}
