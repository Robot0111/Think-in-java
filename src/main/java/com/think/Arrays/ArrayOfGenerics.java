package com.think.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
@SuppressWarnings("unchecked")
public static void main(String[] args) {
	List<String>[] ls;
	List[] la = new List[10];
	ls = (List<String>[])la;
	ls[0] = new ArrayList<String>();
	
	Object[] objects = ls;// so assignment is ok
	//compiles and runs without complaint
	objects[1] = new ArrayList<Integer>();
	//However , if your needs are straightforward it is possible to create an array of generics ,albeit with an "unchecked" warning;
	List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
	for(int i = 0; i < spheres.length; i++)
		spheres[i] = new ArrayList<BerylliumSphere>();
}
}
 