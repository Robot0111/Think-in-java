package com.think.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;
 
/**
 * 斗地主游戏洗牌发牌
 * 
 * @author fenuang 1,设置一副扑克并存入集合 定义String数组
 *
 *         2,设置一个集合来装做好的扑克牌,拼接字符串
 *
 *         3,设置3个集合来做玩家 4,设置一个集合来做底牌 5,洗牌 6.通过判断发牌 7,打印牌
 */
public class Test {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		String[] num = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] color = { "♣", "♦", "♥", "♠" };
 
		HashMap<Integer, String> poker = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int index = 1;
 
		for (String c : color) {
			for (String n : num) {
				poker.put(index, c.concat(n));
				list.add(index);
				index++;
			}
		}
 
		poker.put(index, "小王");
		list.add(index);
		index++;
		poker.put(index, "大王");
		list.add(index);
		System.out.println(poker);
		System.out.println(list);
 
		// 洗牌
		Collections.shuffle(list);
		System.out.println(list);
 
		// 创建玩家
 
		TreeSet<Integer> user1 = new TreeSet<>();
		TreeSet<Integer> user2 = new TreeSet<>();
		TreeSet<Integer> user3 = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
 
		for (int i = 0; i < list.size(); i++) {
 
			if (i >= (list.size() - 3)) { // 留底牌
				dipai.add(list.get(i));
 
			} else if (i % 3 == 0) {
				user1.add(list.get(i));
			} else if (i % 3 == 1) {
				user2.add(list.get(i));
			} else {
				user3.add(list.get(i));
			}
		}
		/*
		 * 
		 * System.out.println("玩家1的牌是：" + user1.size());
		 * System.out.println("玩家1的牌是：" + user1); System.out.println("玩家2的牌是：" +
		 * user2.size()); System.out.println("玩家2的牌是：" + user2);
		 * System.out.println("玩家3的牌是：" + user3.size());
		 * System.out.println("玩家3的牌是：" + user3);
		 */
 
		// 看牌
 
		seepoker(poker, user1, "玩家一");
		seepoker(poker, user2, "玩家二");
		seepoker(poker, user3, "玩家三");
 
	}
 
	// 看牌
 
	public static void seepoker(HashMap<Integer, String> hm, TreeSet<Integer> ts, String name) {
		System.out.println(name + "的牌是");
		for (Integer integer : ts) {
			System.out.print(hm.get(integer) + " ");
 
		}
		System.out.println();
		System.out.println("-------------------");
	}
 
}
