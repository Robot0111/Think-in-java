package com.think.generic;
class Grain{
	public String toString() {return "Grain";};
}

class Wheat extends Grain {
	public String toString() {
		return "Wheat";
	}
}
//协变参数 --- 就是父子类  被覆盖的方法  可以返回父类方法的返回类行的  子类行   
class  Mill {
	Grain process() {return new Grain();}
}

class WheatMIll extends Mill{
	Grain process() {return new Wheat();}
}
public class CovariantReturn {

	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.err.println(g);
		m = new WheatMIll();
		g = m.process();
		System.err.println(g);
	}

}
