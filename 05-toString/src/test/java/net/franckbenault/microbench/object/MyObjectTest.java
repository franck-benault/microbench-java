package net.franckbenault.microbench.object;


import org.junit.Test;

public class MyObjectTest {

	@Test
	public void testToString() {
		MyObject o = new MyObject(null, null, null);
		System.out.println(o.toString());
	}

}
