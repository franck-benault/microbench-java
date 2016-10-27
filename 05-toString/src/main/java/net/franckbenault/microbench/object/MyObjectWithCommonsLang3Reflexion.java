package net.franckbenault.microbench.object;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MyObjectWithCommonsLang3Reflexion extends MyObject {

	
	public MyObjectWithCommonsLang3Reflexion() {
	}
	
	public MyObjectWithCommonsLang3Reflexion(String att1, String att2, String att3) {
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
	}
	
	@Override
	public String toString() {
	    return ReflectionToStringBuilder.toString(this);
	}

	
	
}
