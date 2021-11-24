package com.think.collect;

import java.util.Iterator;
import static net.mindview.util.Print.*;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

class Letters implements Generator<Pair<Integer,String>>, Iterable<Integer>{
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	@Override
	public Pair<Integer,String> next() {
		return new Pair<Integer,String>(number++,"" + letter++);
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public Integer next() {return number++;}
			public void remove() {
				throw new UnsupportedOperationException();
			}
			@Override
			public boolean hasNext() {
				return  number < size;
			}
		};
	}
	
}
public class MapDataTest {
	public static void main(String[] args) {
		print(MapData.map(new Letters(),11));
		//Two separate generators:
		print(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3),8));
		//A key Generator and a single value;
		print(MapData.map(new CountingGenerator.Character(), "Value",6));
		//An Iterable and a value Generator;
		print(MapData.map(new Letters(), new RandomGenerator.String(3)));
		//An Iterable and a single value;
		print(MapData.map(new Letters(), "Pop"));
		
	}
}
