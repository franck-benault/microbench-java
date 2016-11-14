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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBenchmark {

	private static final Logger logger = LoggerFactory.getLogger(MyBenchmark.class);

	@State(Scope.Benchmark)
	public static class ATripletList {

		List<Triplet> list = new ArrayList<Triplet>(100);

		@Setup(Level.Trial)
		public void initList() {
			int size =100;
			list = IntStream.range(0,size)
				.mapToObj( Triplet::new)
				.collect(Collectors.toCollection(
						() -> new ArrayList<Triplet>(size)));
		}

		List<Triplet> getTripletList() {
			List<Triplet> dest = new ArrayList<Triplet>(list);

			return dest;
		}
	}

	@Benchmark
	public void empty() {

	}

	@Benchmark
	public ATripletList checkCostObjectCreation(ATripletList list) {
		return list;

	}

	@Benchmark
	public void testConcatenatingStrings(ATripletList list) {

		for (Triplet t : list.getTripletList()) {

			logger.debug("Concatenating strings " + t.getA() + t.getB() + t.getC());
		}
	}

	@Benchmark
	public void testVariableArguments(ATripletList list) {

		for (Triplet t : list.getTripletList()) {
			logger.debug("Variable arguments {} {} {}", t.getA(), t.getB(), t.getC());
		}
	}

	@Benchmark
	public void testIfDebugEnabled(ATripletList list) {

		for (Triplet t : list.getTripletList()) {

			if (logger.isDebugEnabled())
				logger.debug("Variable arguments {} {} {}", t.getA(), t.getB(), t.getC());

		}
	}
}
