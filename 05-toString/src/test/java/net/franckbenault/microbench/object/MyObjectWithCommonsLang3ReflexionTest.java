package net.franckbenault.microbench.object;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyObjectWithCommonsLang3ReflexionTest {

	@Test
	public void testToStringNull() {
		MyObject o = new MyObjectWithCommonsLang3Reflexion();
		System.out.println(o.toString());
		//assertEquals(o.toString(), "MyObjectWithStringBuilder{att1=null, att2=null, att3=null}");
	}
	
	@Test
	public void testToString() {
		MyObject o = new MyObjectWithCommonsLang3Reflexion(1);
		System.out.println(o.toString());
		//assertEquals(o.toString(), "MyObjectWithStringBuilder{att1=a, att2=b, att3=c}");

	}

}
