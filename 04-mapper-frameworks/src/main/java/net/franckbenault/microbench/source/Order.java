package net.franckbenault.microbench.source;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order {
	private Customer customer;
	private Address billing;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
	@Override
	public String toString() 
	{ 
	    return ToStringBuilder.reflectionToString(this); 
	}
}
