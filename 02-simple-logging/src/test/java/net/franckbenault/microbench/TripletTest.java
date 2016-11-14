package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class TripletTest {

	@Test
	public void testTriplet() {
		int size =20;
		List<Triplet> list = IntStream.range(0,size)
			.mapToObj( Triplet::new)
			.collect(Collectors.toCollection(
					() -> new ArrayList<Triplet>(size)));
		System.out.println(list);
	}

}
