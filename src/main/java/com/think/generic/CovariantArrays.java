package com.think.generic;
class Fruit{};
class Apple extends Fruit{};
class Jonathan extends Apple{};
class Orange extends Apple{};
public class CovariantArrays {
	public static void main(String[] args) {
		//水果
		Fruit[] fruit = new Apple[10];
		
		fruit[0]  = new Apple();
		fruit[1] = new Jonathan();//ok
		try {
			fruit[0] = new Fruit();
		}catch(Exception e) {
			System.err.println(e);
		}
		try {
			fruit[0] = new Orange();
			
		}catch (Exception e) {
			System.err.println(e);
		}
	}
}
