package net.franckbenault.microbench.source;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Customer {
	
	public Customer() {

	}
	
	public Customer(int i) {
		this.setName(new Name(i));
	}
	
	public void fillCustomer() {
		name = new Name();
	}
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