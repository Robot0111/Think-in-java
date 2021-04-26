package com.think.Arrays;

import static net.mindview.util.Print.*;
import java.util.Arrays;

public class FillingArrays {
	public static void main(String[] args) {
		int size = 6;
		boolean[] a1 = new boolean[size];
		byte[] a2 = new byte[size];
		char[] a3 = new char[size];
		short[] a4 = new short[size];
		int[] a5 = new int[size];
		long[] a6 = new long[size];
		float[] a7 = new float[size];
		double[] a8 = new double[size];
		String[] a9 = new String[size];
		
		Arrays.fill(a1, true);
		print("a1 = " + Arrays.toString(a1));
	}
}
