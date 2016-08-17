package net.franckbenault.microbench.source;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Customer {
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	@Override
	public String toString() 
	{ 
	    return ToStringBuilder.reflectionToString(this); 
	}
}