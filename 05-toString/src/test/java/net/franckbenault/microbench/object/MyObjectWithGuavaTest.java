package net.franckbenault.microbench.object;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyObjectWithGuavaTest {

	@Test
	public void testToStringNull() {
		MyObject o = new MyObjectWithGuava();
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObjectWithGuava{att1=null, att2=null, att3=null}");
	}
	
	@Test
	public void testToString() {
		MyObject o = new MyObjectWithGuava("a", "b", "c");
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObjectWithGuava{att1=a, att2=b, att3=c}");

	}

}
