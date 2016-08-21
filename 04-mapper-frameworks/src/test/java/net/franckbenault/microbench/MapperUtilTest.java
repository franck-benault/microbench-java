package net.franckbenault.microbench;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class MapperUtilTest {
	
	private Address getAddress() {
		Address address = new Address();
		address.setCity(RandomStringUtils.random(2));
		address.setStreet(String.format("street%d",2));
		
		return address;
	}
	
	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setName(getName());
		
		return customer;
	}
	
	private Name getName() {
		Name name = new Name();
		name.setFirstName("firstName");
		name.setLastName("lastName");
		
		return name;
	}
	
	private Order getOrder() {
		Order order = new Order();
		order.setBillingAddress(getAddress());
		order.setCustomer(getCustomer());
		
		return order;
	}
	
	private Order getOrderNull() {
		Order order = new Order();
		return order;
	}

	
	
	
	@Test
	public void testMapWithModelMapperWithStopWatch() {
		
		Order order = getOrder();
		OrderDTO orderDTO =MapperUtil.mapWithModelMapperWithStopWatch(order);
		checkMapping(order, orderDTO);
		
		order = getOrderNull();
		orderDTO =MapperUtil.mapWithModelMapperWithStopWatch(order);
		checkMapping(order, orderDTO);		
	}
	

	private void checkMapping(Order order, OrderDTO orderDTO) {
		System.out.println("order="+order);
		System.out.println("orderDTO="+orderDTO);
		
		if(order.getCustomer()!=null && order.getCustomer().getName()!=null) {
			assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
			assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
		}
		if(order.getBillingAddress()!=null) {
			assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
			assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
		}
	}

}
