package com.think.generic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import com.think.Generator;

public class Customer {
	private static long counter = 1;
	private final long id = counter++;

	private Customer() {

	}

	@Override
	public String toString() {
		return "Customer" + id;
	}

	public static Generator<Customer> generator() {
		return new Generator<Customer>() {
			public Customer next() {
				return new Customer();
			}
		};

	}
	public static void main(String[] args) {
		Random rand = new Random(47);
		Queue<Customer> line = new LinkedList<Customer>();
	}
}
class Teller{
	private static long counter = 1;
	private final long id = counter++;
	private Teller() {
	}
	@Override
	public String toString() {
		return "Teller "+ id;
	}
	public static Generator<Teller> generator = new Generator<Teller>() {
		public Teller next() {return new Teller();}
	};
}
class BankTeller{
	public static void serve(Teller t,Customer c) {
		System.out.println(t + " serves " +c);
	}
}
