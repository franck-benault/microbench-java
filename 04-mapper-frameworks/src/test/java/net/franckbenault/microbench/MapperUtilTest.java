package net.franckbenault.microbench;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class MapperUtilTest {
	
	private Address getAddress() {
		Address address = new Address();
		address.setCity("city");
		address.setStreet("street");
		
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
	public void testMapWithModelMapper() {
		
		Order order = getOrder();
		OrderDTO orderDTO =MapperUtil.mapWithModelMapper(order);
		checkMapping(order, orderDTO);
		
		order = getOrderNull();
		orderDTO =MapperUtil.mapWithModelMapper(order);
		checkMapping(order, orderDTO);		
	}
	
	@Test
	public void testMapWithModelMapperOptimized() {
		
		Order order = getOrder();
		OrderDTO orderDTO =MapperUtil.mapWithModelMapperOptimized(order);
		checkMapping(order, orderDTO);
		
		order = getOrderNull();
		orderDTO =MapperUtil.mapWithModelMapperOptimized(order);
		checkMapping(order, orderDTO);		
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
	
	@Test
	public void testMapWithDozer() {
		
		Order order = getOrder();
		OrderDTO orderDTO =MapperUtil.mapWithDozer(order);
		checkMapping(order, orderDTO);
		
		order = getOrderNull();
		orderDTO =MapperUtil.mapWithDozer(order);
		checkMapping(order, orderDTO);		
	}
	
	@Test
	public void testMapWithDozerOptimized() {
		
		Order order = getOrder();
		OrderDTO orderDTO =MapperUtil.mapWithDozerOptimized(order);
		checkMapping(order, orderDTO);
		
		order = getOrderNull();
		orderDTO =MapperUtil.mapWithDozerOptimized(order);
		checkMapping(order, orderDTO);		
	}

	@Test
	public void testMapManual() {
		Order order = getOrder();
		OrderDTO orderDTO =MapperUtil.mapManual(order);
		checkMapping(order, orderDTO);
		
		
		order = getOrderNull();
		orderDTO =MapperUtil.mapManual(order);
		checkMapping(order, orderDTO);	

	}
	
	private void checkMapping(Order order, OrderDTO orderDTO) {
		
		
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
