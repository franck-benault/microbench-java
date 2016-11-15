package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
			
			int size =10;
			list1 = IntStream.range(0,size)
				.mapToObj( MyObject::new)
				.collect(Collectors.toCollection(
						() -> new ArrayList<MyObject>(size+1)));
			list2 = IntStream.range(0,size)
					.mapToObj( MyObjectWithObjectsToString::new)
					.collect(Collectors.toCollection(
							() -> new ArrayList<MyObjectWithObjectsToString>(size+1)));
			list3 = IntStream.range(0,size)
					.mapToObj( MyObjectWithStringBuilder::new)
					.collect(Collectors.toCollection(
							() -> new ArrayList<MyObjectWithStringBuilder>(size+1)));

			list4 = IntStream.range(0,size)
					.mapToObj( MyObjectWithGuava::new)
					.collect(Collectors.toCollection(
							() -> new ArrayList<MyObjectWithGuava>(size+1)));
			
			list5 = IntStream.range(0,size)
					.mapToObj( MyObjectWithCommonsLang3Reflexion::new)
					.collect(Collectors.toCollection(
							() -> new ArrayList<MyObjectWithCommonsLang3Reflexion>(size+1)));
			
			list6 = IntStream.range(0,size)
					.mapToObj( MyObjectWithLombok::new)
					.collect(Collectors.toCollection(
							() -> new ArrayList<MyObjectWithLombok>(size+1)));
			
			

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
