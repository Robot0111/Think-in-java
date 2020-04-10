package com.think.generic;

import java.awt.Color;


		interface HasColor {java.awt.Color getColor();}
		
		class Colored<T extends HasColor>{
			T item;
			Colored(T item) {this.item = item;}
			T getItem() {return item;}
			// the bound allows you to call a method ;
			java.awt.Color color(){ return item.getColor();}
		}
		
		class  Dimension {public int x,y,z;};
		
		//This won't work -- class must be first ,then interfaces;
		//class ColoredDimension<T extends HasColor & Dimension> {   这个不能工作 ，class 必须在第一位 ，然后是接口。
		
		class ColoredDimension<T extends Dimension & HasColor>{
			T item;
			ColoredDimension(T item){this.item = item;}
			T getItem() {return item;}
			java.awt.Color color(){return item.getColor();}
			int getX() {return item.x;}
			int getY() {return item.y;}
			int getZ() {return item.z;}
		}
		//TODO 20200317 7:48
		interface Weight {int weight();}
		
		//As with inheritance, you can have only you one 与继承一样，你只能拥有一个
		// concrete class but multiple interfaces; 可以拥有多个接口
		
		class Solid<T extends Dimension & HasColor & Weight>{
			T item;
			Solid(T item) {this.item = item;}
			T getItem() {return this.item;};
			java.awt.Color color() {return item.getColor();}
			int getX() {return item.x;}
			int getY() {return item.y;}
			int getZ() {return item.z;}
			int weight() {return item.weight();}
			
		}
		
		class Bounded extends Dimension implements HasColor ,Weight{
			
			@Override
			public int weight() {
				return 0;
			}

			@Override
			public Color getColor() {
				return Color.red;
			}
			
		}
		//添加边界
		class HoldItem<T>{
			T item;
			HoldItem(T item){this.item = item;}
			
			T getItem() {return item;}
		}
			
			class Colored2<T extends HasColor> extends HoldItem<T>{
				Colored2(T item){super (item);};
				java.awt.Color  color() {return item.getColor();}
			}
			
			class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{

				ColoredDimension2(T item) {super(item);}
				
				int getX() {return item.x;}
				int getY() {return item.y;}
				int getZ() {return item.z;}
				
			}
		class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{
			Solid2(T item){super(item);}
			int weight() {return item.weight();}
		}
			
		public class BasicBounds {
		public static void main(String[] args) {
			Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
			solid.color();
			solid.getY();
			solid.weight();
			System.err.println("color:"+solid.color());
		}
}
