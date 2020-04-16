package com.think.generic;

interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
	void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{
	
}
public class SelfBounding {
	
void testA(Setter s1,Setter s2,SelfBoundSetter sbs) {
	s1.set(s2);
	//FIXME
}
}
