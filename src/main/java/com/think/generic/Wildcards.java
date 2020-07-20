package com.think.generic;

/**
 * @author luQl
 * @version 2020 04 11
 */
public class Wildcards {

	static void rawArgs(Holder holder,Object arg) {
		//holder.set(arg);
		Object obj = holder.get();
	}
	
	static void unboundedArg(Holder<?> holder ,Object arg) {
		//holder.set(arg);
		Object obj = holder.get();
	}
	
	static <T> T exact1(Holder<T> holder) {
		T t = holder.get();
		return t;
	}
    static <T> T exact2(Holder<T> holder,T arg) {
    	holder.set(arg);
    	T t = holder.get();
    	return t;
    }
	static <T> T wildSubtype(Holder<? extends T> holder,T arg) {
		//holder.set(arg);
		T  t = holder.get();
		return t;
	}
 
	static <T> void wildSupertype(Holder<? super T> holder,T arg) {
		holder.set(arg);
		Object obj = holder.get();
	}
	public static void main(String[] args) {
		Holder raw = new Holder<Long>();
		//or
		raw = new Holder();
		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();
		Holder<? super Long> upbounded = new Holder<Long>();
		Long lng = 1l;
		//原生类行方法
		rawArgs(raw,lng);
		rawArgs(qualified,lng);
		rawArgs(unbounded,lng);
		rawArgs(bounded,lng);
		//无界通配符方法
		unboundedArg(raw,lng);//无界通配符方法  ，原生类行参数
		unboundedArg(qualified,lng);//无界通配符方法，确切类行参数
		unboundedArg(unbounded, lng);//无界通配符方法 ，无界通配符参数
		unboundedArg(bounded,lng);//无界通配符方法 ,下界 是Long 的类行参数
		
		//泛型参数方法
		Object r1 = exact1(raw);//Warnings; 原生类行不能放入泛型方法
		Long r2 = exact1(qualified);//不会产生警告，因为是泛型类
		Object r3 = exact1(unbounded);// must return Object.
		Long r4 = (Long) exact1(bounded);//具有下界的泛型类参数
		
		//确定类型的泛型方法
		Long r5 = exact2(raw,lng);//Warnings;
		Long r6 = exact2(qualified, lng);//确切类型
		//Object r7 = exact2(unbounded, lng);//error,
		//Long r8 = exact2(bounded, lng); 这个泛型方法其实因为第二个参数已经确定了类型，所以使用具有下界的泛型类做为参数 违反了泛型擦除的规则
		
		//具有下界泛型类型的泛型方法
		Long r9 = wildSubtype(raw ,lng);//Warnings 传入原生类行会产生警告，因为他是泛型方法
		Long r10 = wildSubtype(qualified, lng);//泛型参数确切类行
		Object r11 = wildSubtype(unbounded, lng);//只能返回Object,注意r7 和r11 为什么 无界通配符参数应用于确定类行的泛型类会异常？而这里可以返回Object呢？
		//主要是 Holder<T> cannot be applied to Holder <capture of ?> ,也就是说在调用的方法的时候 其实在进行转型，而 T 不能转换为？的。
		Long r12 = wildSubtype(bounded, lng);
		//具有上界泛型类型的泛型方法
		wildSupertype(raw, lng);//warnings.也是因为无法进行类型转型 
		//本质 Holder to Holder<? super Long> unchecked method invocation: 
		//wildSupertype(Holder<? super T>, T) is applied to (Holder,Long)
		
		wildSupertype(qualified, lng);//不解释，确切类型一定可以，上下界通吃
		//wildSupertype(unbounded, lng); error ，与r7 and r11 similar.
		
	}
}
