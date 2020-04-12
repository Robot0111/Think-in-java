package com.think.generic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
	public void f(String[] args) throws Exception{
		@SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(args[0]));
		List<Widget> shapes = (List<Widget>)in.readObject();
		
		List<Widget>  lw2 = List.class.cast(in.readObject());
	}
}
