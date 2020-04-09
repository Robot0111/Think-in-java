package com.think.generic;

public class Wildcards {

	static void rawArgs(Holder holder,Object arg) {
		//holder.set(arg);
		Object obj = holder.get();
	}
	
	static void unboundedArg(Holder<?> holder ,Object arg) {
		//holder.set(arg);
		Object obj = holder.get();
	}
	
	static <T> T exact1(Holder<T> holder) {
		T t = holder.get();
		return t;
	}
	
	static <T> T wildSubtype(Holder<? extends T> holder,T arg) {
		//holder.set(arg);
		return holder.get();
	}
	
	static <T> void wildSupertype(Holder<? super T> holder,T arg) {
		holder.set(arg);
		
	}
}
