package com.think.generic;

public class BasicBounds {
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
}
