package net.franckbenault.microbench.source;

public class Address {
	  private String street;
	  private String city;
	  
	public Address() {
		
	}
	
	public Address(int i) {
		this.setCity("City" + i);
		this.setStreet("Street" + i);
	}
	  
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}