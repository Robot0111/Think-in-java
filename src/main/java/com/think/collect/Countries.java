package com.think.collect;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.mindview.util.Print.*;
public class Countries {
	public static final String[][] DATA = {
			{"ALGERIA","ALGIERS"},{"ANGOLA","Gaberone"},
			{"BENIN","Porto-Novo"},{"BOTSWANA","Gaberone"},
			{"BURKINA","FASO"},
			{"BURUNDI","Bujumbura"},{"BOTSWANA","Gaberone"},
			{"CAMEROON","Yaounde"},{"CAPE VERDE","Praia"}
	};
	private static class FlyweighMap extends AbstractMap<String,String>{
		
		private static class Entry implements Map.Entry<String, String>{
			int index;
			Entry(int index){ this.index = index;}
			public boolean equals(Object o) {
				return DATA[index][0].equals(o);
			}
			public String getKey() {return DATA[index][0];}
			public String getValue() {return DATA[index][1];}
			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}
			public int hashCode() {
				return DATA[index][0].hashCode();
			}
		}
		//Use AbstractSet by implementing size() & iterator()
		static class EntrySet extends AbstractSet<Map.Entry<String,String>>{
			private int size;
			EntrySet(int size){
				if(size < 0)
					this.size = 0;
				//Can't be any bigger than the array;
				else if(size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}
			@Override
			public int size() {return size;}
			private class Iter implements Iterator<Map.Entry<String,String>>{
				//Only one Entry object per Iterator;
				private  Entry entry = new Entry(-1);
				public boolean hasNext() {
					return entry.index < size - 1;
				}
				public Map.Entry<String, String> next(){
					entry.index++;
					return entry;
				}
				public void remove() {
					throw new UnsupportedOperationException();
				}
			}
			@Override
			public Iterator<Map.Entry<String, String>> iterator(){
				return new Iter();
			}
		}
		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);
		@Override
		public Set<Map.Entry<String, String>> entrySet(){ return entries;}
		//Create a partial map of 'size' countries;
		static Map<String,String> select(final int size){
			return new FlyweighMap() {
				public Set<Map.Entry<String, String>> entrySet(){
					return new EntrySet(size);
				}
			};
		}
		static Map<String,String> map = new FlyweighMap();
		public static Map<String,String> capitals(){
			return map;// the entire map
		}
		public static Map<String,String> capitals(int size){
			return select(size);//A partial map
		}
		static List<String> names = new ArrayList<String>(map.keySet());
		//All the names;
		public static List<String> names(){return names;}
		//A partial list;
		public static List<String> names(int size){
			return new ArrayList<String>(select(size).keySet());
		}
		public static void main(String[] args) {
			print(capitals(10));
		}
	}
}
