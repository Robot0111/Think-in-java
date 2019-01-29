package com.think.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			int a = rand.nextInt(i + 10);
			priorityQueue.offer(a);
		}
		QueueDemo.printQ(priorityQueue);
		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
		priorityQueue = new PriorityQueue<>(ints);
		QueueDemo.printQ(priorityQueue);
		priorityQueue = new PriorityQueue<>(ints.size(),Collections.reverseOrder());
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ= new PriorityQueue<String>(strings);
		QueueDemo.printQ(stringPQ);
		stringPQ = new PriorityQueue<>(ints.size(),Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);
	}
}
