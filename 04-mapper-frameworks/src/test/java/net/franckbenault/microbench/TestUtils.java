package net.franckbenault.microbench;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class TestUtils {

	private static Address getAddress() {
		Address address = new Address();
		address.setCity(RandomStringUtils.random(2));
		address.setStreet("street"+2);
		
		return address;
	}
	
	private static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setName(getName());
		
		return customer;
	}
	
	private static Name getName() {
		Name name = new Name();
		name.setFirstName("firstName");
		name.setLastName("lastName");
		
		return name;
	}
	
	public static Order getOrder() {
		Order order = new Order();
		order.setBilling(getAddress());
		order.setCustomer(getCustomer());
		
		return order;
	}
	
	public static OrderDTO getOrderDTO() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBillingCity("billingCity");
		orderDTO.setBillingStreet("billingStreet");
		orderDTO.setCustomerFirstName("customerFirstName");
		orderDTO.setCustomerLastName("customerLastName");
		
		return orderDTO;
	}
	
	public static Order getOrderNull() {
		Order order = new Order();
		return order;
	}
	
	public static void checkMapping(Order order, OrderDTO orderDTO) {
		System.out.println("order="+order);
		System.out.println("orderDTO="+orderDTO);
		
		if(order.getCustomer()!=null && order.getCustomer().getName()!=null) {
			assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
			assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
		}
		if(order.getBilling()!=null) {
			assertEquals(order.getBilling().getStreet(), orderDTO.getBillingStreet());
			assertEquals(order.getBilling().getCity(), orderDTO.getBillingCity());
		}
		checkMapping(orderDTO, order);
	}
	
	public static void checkMapping(OrderDTO orderDTO, Order order) {
		System.out.println("order="+order);
		System.out.println("orderDTO="+orderDTO);
		
		if(orderDTO.getCustomerFirstName()!=null) {
			assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
		}
		if(orderDTO.getCustomerLastName()!=null) {
			assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
		}
		
		if(orderDTO.getBillingCity()!=null) {
			assertEquals(order.getBilling().getCity(), orderDTO.getBillingCity());
		}
		
		if(orderDTO.getBillingStreet()!=null) {
			assertEquals(order.getBilling().getStreet(), 
					orderDTO.getBillingStreet());
		}
	}
}
