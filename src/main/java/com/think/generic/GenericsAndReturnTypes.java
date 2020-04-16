package com.think.generic;

interface GenericGetter<T extends GenericGetter<T>>{
	T get();
}

interface Getter extends GenericGetter<Getter>{
	
}
public class GenericsAndReturnTypes {
	void test(Getter g) {
		Getter result = g.get();
		//子限定泛型将长生确切的导出类型作为返回值;因为基类是泛型类
		GenericGetter gg = g.get();// Also the base type
	}
}
