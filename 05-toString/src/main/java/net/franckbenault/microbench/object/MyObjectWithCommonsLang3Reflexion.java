package net.franckbenault.microbench.object;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MyObjectWithCommonsLang3Reflexion extends MyObject {

	
	public MyObjectWithCommonsLang3Reflexion() {
	}
	
	public MyObjectWithCommonsLang3Reflexion(int i) {
		this.att1 = "att1-"+i;
		this.att2 = "att2-"+i;
		this.att3 = "att3-"+i;
	}
	
	@Override
	public String toString() {
	    return ReflectionToStringBuilder.toString(this);
	}

	
	
}
