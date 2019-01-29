package com.think.RTTI;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

	private static List<Class <? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
			"com.think.RTTI.Mutt",
			"com.think.RTTI.Pug",
			"com.think.RTTI.EgyptianMau",
			"com.think.RTTI.Cymric",
			"com.think.RTTI.Rat",
			"com.think.RTTI.Mouse",
			"com.think.RTTI.Hamster"
	};
	@SuppressWarnings("unchecked")
	private  static void loader() {
		try {
			for(String name:typeNames)
				types.add((Class<? extends Pet>)Class.forName(name));
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	static {loader();};
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}

}
