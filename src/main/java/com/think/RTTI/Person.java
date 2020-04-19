package com.think.RTTI;

import com.think.容器深入研究.Individual;

public class Person extends Individual {
	public Person(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}



class Mutt extends Dog{

	public Mutt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mutt(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class Pug extends Dog{

	public Pug() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pug(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}

class EgyptianMau extends Cat{

	public EgyptianMau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EgyptianMau(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class Manx extends Cat{

	public Manx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manx(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class Cymric extends Manx{

	public Cymric() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cymric(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
//rodent 
class Rodent extends Pet{
	public Rodent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rodent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
class Rat extends Rodent{

	public Rat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class Mouse extends Rodent{

	public Mouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mouse(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
class Hamster extends Rodent{

	public Hamster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hamster(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}