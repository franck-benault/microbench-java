package net.franckbenault.microbench.source;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order {
	private Customer customer;
	private Address billingAddress;
	
	public Order(){
		
	}
	
	public Order(int i) {
		this.setBillingAddress(new Address(i));
		this.setCustomer(new Customer(i));
	}
	
	public void fillOrder() {
		customer = new Customer();
		billingAddress = new Address();
		customer.fillCustomer();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	@Override
	public String toString() 
	{ 
	    return ToStringBuilder.reflectionToString(this); 
	}
}
