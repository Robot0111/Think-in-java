package com.think.容器深入研究;

import java.util.Random;

public class Prediction {
private static Random rand = new Random(47);
private boolean shadow = rand.nextDouble() > 0.5;
@Override
	public String toString() {
	if(shadow)
		 return "Six more weeks of winter!";
	else
	return "Early Spring!";
	}
}
