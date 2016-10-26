package net.franckbenault.microbench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import net.franckbenault.microbench.object.MyObject;
import net.franckbenault.microbench.object.MyObjectWithGuava;
import net.franckbenault.microbench.object.MyObjectWithObjectsToString;
import net.franckbenault.microbench.object.MyObjectWithStringBuilder;

public class MyBenchmark {
	
	private MyObject getMyObject(int i) {
		return new MyObject("a"+i,"b"+i, "c"+i);
	}

	private MyObject getMyObjectNull() {
		return new MyObject();
	}
	
	private MyObjectWithObjectsToString getMyObjectWithObjectsToString(int i) {
		return new MyObjectWithObjectsToString("a"+i,"b"+i, "c"+i);
	}

	private MyObjectWithObjectsToString getMyObjectWithObjectsToStringNull() {
		return new MyObjectWithObjectsToString();
	}
	
	private MyObjectWithStringBuilder getMyObjectWithStringBuilder(int i) {
		return new MyObjectWithStringBuilder("a"+i,"b"+i, "c"+i);
	}

	private MyObjectWithStringBuilder getMyObjectWithStringBuilderNull() {
		return new MyObjectWithStringBuilder();
	}
	
	private MyObjectWithGuava getMyObjectWithGuava(int i) {
		return new MyObjectWithGuava("a"+i,"b"+i, "c"+i);
	}

	private MyObjectWithGuava getMyObjectWithGuavaNull() {
		return new MyObjectWithGuava();
	}


	  @Benchmark
	  public void nothing() {

	  }

	  @Benchmark
	  public void costObjectCreation(Blackhole bh) {
		  MyObject o;
		  for(int i=0; i<10; i++) {
			  o = getMyObject(i);		  
			  bh.consume(o);
		  }
		  o = getMyObjectNull();
		  
		  bh.consume(o);
	  }

	  
	  @Benchmark
	  public void simpleToString(Blackhole bh) {
		  String s;
		  MyObject o;
		  for(int i=0; i<10; i++) {
			  o = getMyObject(i);	
			  s = o.toString();
			  bh.consume(s);
		  }
		  o = getMyObjectNull();
		  s = o.toString();		  
		  bh.consume(s);
	  }

	  @Benchmark
	  public void withObjectsToString(Blackhole bh) {
		  String s;
		  MyObject o;
		  for(int i=0; i<10; i++) {
			  o = getMyObjectWithObjectsToString(i);	
			  s = o.toString();
			  bh.consume(s);
		  }
		  o = getMyObjectWithObjectsToStringNull();
		  s = o.toString();		  
		  bh.consume(s);
	  }
	  
	  @Benchmark
	  public void withStringBuilder(Blackhole bh) {
		  String s;
		  MyObject o;
		  for(int i=0; i<10; i++) {
			  o = getMyObjectWithStringBuilder(i);	
			  s = o.toString();
			  bh.consume(s);
		  }
		  o = getMyObjectWithStringBuilderNull();
		  s = o.toString();		  
		  bh.consume(s);
	  }
	  
	  @Benchmark
	  public void withGuava(Blackhole bh) {
		  String s;
		  MyObject o;
		  for(int i=0; i<10; i++) {
			  o = getMyObjectWithGuava(i);	
			  s = o.toString();
			  bh.consume(s);
		  }
		  o = getMyObjectWithGuavaNull();
		  s = o.toString();		  
		  bh.consume(s);
	  }
}
