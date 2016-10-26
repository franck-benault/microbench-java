package net.franckbenault.microbench.object;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyObjectWithObjectsToStringTest {

	@Test
	public void testToStringNull() {
		MyObject o = new MyObjectWithObjectsToString();
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObjectWithObjectsToString{att1=null, att2=null, att3=null}");
	}
	
	@Test
	public void testToString() {
		MyObject o = new MyObjectWithObjectsToString("a", "b", "c");
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObjectWithObjectsToString{att1=a, att2=b, att3=c}");

	}

}
