package com.think.generic;

class OrdinarySetter{
	void set(Base base) {
		System.err.println("OrdinarySetter.set(Base)");
	}
}

class DerivedSetter extends OrdinarySetter{
	void set(Derived derived) {
		System.err.println("DerivedSetter.set(Derived)");
	}
}
public class OrdinaryArguments {

	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedSetter ds = new DerivedSetter();
		ds.set(derived);
		ds.set(base);
	}
}
