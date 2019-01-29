package com.think.collection;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
//队列先进先出
public class QueueDemo {
	public static void printQ(Queue<? extends Object> queue) {
		while(queue.peek()!=null)
			System.out.print(queue.remove()+ " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for(int i = 0; i< 10; i++)
			queue.offer(rand.nextInt(i+10));
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "Brontosaurus".toCharArray())
			qc.offer(c);
		printQ(qc);
	}
}
