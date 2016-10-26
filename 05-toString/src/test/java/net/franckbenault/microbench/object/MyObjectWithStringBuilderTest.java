package net.franckbenault.microbench.object;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyObjectWithStringBuilderTest {

	@Test
	public void testToStringNull() {
		MyObject o = new MyObjectWithStringBuilder();
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObjectWithStringBuilder{att1=null, att2=null, att3=null}");
	}
	
	@Test
	public void testToString() {
		MyObject o = new MyObjectWithStringBuilder("a", "b", "c");
		System.out.println(o.toString());
		assertEquals(o.toString(), "MyObjectWithStringBuilder{att1=a, att2=b, att3=c}");

	}

}
