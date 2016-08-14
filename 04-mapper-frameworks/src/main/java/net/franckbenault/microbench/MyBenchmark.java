package net.franckbenault.microbench;



import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class MyBenchmark {
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
	
	  @Benchmark
	  public void empty() {

	  }
	  
	  @Benchmark
	  public void simpleMapWithModelMapper(Blackhole bh) {
		  Order order = getOrder();
		  OrderDTO dto = MapperUtil.mapWithModelMapper(order);
		  
		  bh.consume(dto);
		  
	  }
	  
	  @Benchmark
	  public void simpleMapManual(Blackhole bh) {
		  Order order = getOrder();
		  OrderDTO dto = MapperUtil.mapManual(order);
		  
		  bh.consume(dto);

	  }

	  @Benchmark
	  public void fullMapWithModelMapper(Blackhole bh) {
		  Order order = getOrder();
		  OrderDTO dto = MapperUtil.mapWithModelMapper(order);
		  
		  bh.consume(dto);
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperUtil.mapWithModelMapper(order);
		  
		  bh.consume(dto2);
		  
	  }
	  
	  @Benchmark
	  public void fullMapManual(Blackhole bh) {
		  Order order = getOrder();
		  OrderDTO dto = MapperUtil.mapManual(order);
		  
		  bh.consume(dto);
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperUtil.mapManual(order);
		  
		  bh.consume(dto2);
	  }
	  
	  
}
