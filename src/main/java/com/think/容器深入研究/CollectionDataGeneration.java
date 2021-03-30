package com.think.容器深入研究;

import java.util.ArrayList;
import java.util.HashSet;

import net.mindview.util.RandomGenerator;

public class CollectionDataGeneration {
	public static void main(String[] args) {
		//适配器设计模式 将Generator 适配到 集合(CollectionData类) 构造器上，这样无论是Government 类还是RandoGenerator类 都可以适配上去。
		System.out.println(new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9), 10)));
		System.out.println(new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(), 10)));
	}
}
