package net.franckbenault.microbench.source;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Name {
	private String firstName;
	private String lastName;
	
	public Name() {

	}
	
	public Name(int i) {
		this.setFirstName("firstName" + i);
		this.setLastName("lastName" + i);

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() 
	{ 
	    return ToStringBuilder.reflectionToString(this); 
	}
}