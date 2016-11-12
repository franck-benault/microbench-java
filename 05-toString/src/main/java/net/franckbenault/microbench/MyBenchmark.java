package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import net.franckbenault.microbench.object.MyObject;
import net.franckbenault.microbench.object.MyObjectWithCommonsLang3Reflexion;
import net.franckbenault.microbench.object.MyObjectWithGuava;
import net.franckbenault.microbench.object.MyObjectWithLombok;
import net.franckbenault.microbench.object.MyObjectWithObjectsToString;
import net.franckbenault.microbench.object.MyObjectWithStringBuilder;

public class MyBenchmark {

	@State(Scope.Benchmark)
	public static class BenchmarkState {

		List<MyObject> list1 = new ArrayList<MyObject>(11);
		List<MyObjectWithObjectsToString> list2 = new ArrayList<MyObjectWithObjectsToString>(11);
		List<MyObjectWithStringBuilder> list3 = new ArrayList<MyObjectWithStringBuilder>(11);
		List<MyObjectWithGuava> list4 = new ArrayList<MyObjectWithGuava>(11);
		List<MyObjectWithCommonsLang3Reflexion> list5 = new ArrayList<MyObjectWithCommonsLang3Reflexion>(11);
		List<MyObjectWithLombok> list6 = new ArrayList<MyObjectWithLombok>(11);
		
		
		@Setup(Level.Trial)
		public void initList() {
			for (int i = 0; i < 10; i++) {
				list1.add(new MyObject("a" + i, "b" + i, "c" + i));
				list2.add(new MyObjectWithObjectsToString("a" + i, "b" + i, "c" + i));
				list3.add(new MyObjectWithStringBuilder("a" + i, "b" + i, "c" + i));
				list4.add(new MyObjectWithGuava("a" + i, "b" + i, "c" + i));
				list5.add(new MyObjectWithCommonsLang3Reflexion("a" + i, "b" + i, "c" + i));
				list6.add(new MyObjectWithLombok("a" + i, "b" + i, "c" + i));
			}
			list1.add(new MyObject());
			list2.add(new MyObjectWithObjectsToString());
			list3.add(new MyObjectWithStringBuilder());
			list4.add(new MyObjectWithGuava());
			list5.add(new MyObjectWithCommonsLang3Reflexion());
			list6.add(new MyObjectWithLombok());
		}
	}




	@Benchmark
	public void nothing() {

	}
	

	@Benchmark
	public void costObjectCreationAndLoop(BenchmarkState bs, Blackhole bh) {
		for (MyObject o : bs.list1) {
			bh.consume(o);
		}
	}

	@Benchmark
	public void simpleToString(BenchmarkState bs, Blackhole bh) {
		for (MyObject o : bs.list1) {
			String s = o.toString();
			bh.consume(s);
		}
	}

	@Benchmark
	public void withObjectsToString(BenchmarkState bs, Blackhole bh) {		
		for (MyObjectWithObjectsToString o : bs.list2) {
			String s = o.toString();
			bh.consume(s);
		}
	}

	@Benchmark
	public void withStringBuilder(BenchmarkState bs, Blackhole bh) {
		for (MyObjectWithStringBuilder o : bs.list3) {
			String s = o.toString();
			bh.consume(s);
		}
	}

	@Benchmark
	public void withGuava(BenchmarkState bs, Blackhole bh) {		
		for (MyObjectWithGuava o : bs.list4) {
			String s = o.toString();
			bh.consume(s);
		}

	}

	@Benchmark
	public void withCommonsLang3Reflexion(BenchmarkState bs, Blackhole bh) {
		
		for (MyObjectWithCommonsLang3Reflexion o : bs.list5) {
			String s = o.toString();
			bh.consume(s);
		}
		

	}

	@Benchmark
	public void withLombok(BenchmarkState bs, Blackhole bh) {
		
		for (MyObjectWithLombok o : bs.list6) {
			String s = o.toString();
			bh.consume(s);
		}
		

	}
}
