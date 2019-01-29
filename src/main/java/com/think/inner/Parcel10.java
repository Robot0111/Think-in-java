package com.think.inner;

public class Parcel10 {
	public Destination destination(final String dest, final float price) {
		class a implements Destination{
			private int cost;
			{
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
				
			}
			private String label = dest;

			@Override
			public String readLabel() {
				System.out.println(label);
				return label;
			}
			
		}
		return new a();
	}
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		
		//Destination s = p.new a(); 内部类放到了方法体里 所以无法使用.new
		Destination d = p.destination("Tasmania",101.395F);
		}
}
