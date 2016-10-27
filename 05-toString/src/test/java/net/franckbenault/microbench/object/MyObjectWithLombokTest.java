package net.franckbenault.microbench.object;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyObjectWithLombokTest {

	@Test
	public void testToStringNull() {
		MyObject o = new MyObjectWithLombok();
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObject{att1=null, att2=null, att3=null}");
	}
	
	@Test
	public void testToString() {
		MyObject o = new MyObjectWithLombok("a", "b", "c");
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObject{att1=a, att2=b, att3=c}");

	}

}
