package com.think.generic;

import java.util.ArrayList;
import java.util.List;

interface Processor<T,E extends Exception>{
	void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>>{
	List<T> processAll() throws E{
		List<T> resultCollector = new ArrayList<T>();
		for(Processor<T,E> processor:this)
			processor.process(resultCollector);
		return resultCollector;
	}
}
class Failurel extends Exception{}

class Processor1 implements Processor<String,Failurel>{

	static int count = 3;
	@Override
	public void process(List<String> resultCollector) throws Failurel {
		if(count-- > 1)
			resultCollector.add("hep!");
		else
			resultCollector.add("ho!");
		if(count < 0)
			throw new Failurel();
	}
}
class Failure2  extends Exception{}

class Processor2 implements Processor<Integer,Failure2>{
	static int count = 2;
	public void 
	process(List<Integer> resultCollector) throws Failure2{
		if(count-- == 0) {
			resultCollector.add(47);
		}else {
			resultCollector.add(11);
		}
		if(count < 0)
			throw new Failure2();
	}
}
public class ThrowGenericException {
	public static void main(String[] args) {
		ProcessRunner<String,Failurel> runner = new ProcessRunner<String,Failurel>();
		for (int i = 0; i < 3; i++) {
			runner.add(new Processor1());
		}
		try {
			System.err.println(runner.processAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ProcessRunner<Integer,Failure2> runner2 = new ProcessRunner<Integer,Failure2>();
		for(int i = 0; i < 3; i++)
			runner2.add(new Processor2());
		try {
			System.err.println(runner2.processAll());
		}catch(Exception e) {
			System.err.println(e);
		}
	}
		
}
