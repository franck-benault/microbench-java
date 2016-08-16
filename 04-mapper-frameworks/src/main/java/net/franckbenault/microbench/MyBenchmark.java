package net.franckbenault.microbench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class MyBenchmark {
	private Address getAddress(int i) {
		Address address = new Address();
		address.setCity("City"+i);
		address.setStreet("Street"+i);
		
		return address;
	}
	
	private Customer getCustomer(int i) {
		Customer customer = new Customer();
		customer.setName(getName(i));
		
		return customer;
	}
	
	private Name getName(int i) {
		Name name = new Name();
		name.setFirstName("firstName"+i);
		name.setLastName("lastName"+i);
		
		return name;
	}
	
	private Order getOrder(int i) {
		Order order = new Order();
		order.setBillingAddress(getAddress(i));
		order.setCustomer(getCustomer(i));
		
		return order;
	}

	private Order getOrderNull() {
		Order order = new Order();
		return order;
	}
	
	  @Benchmark
	  public void nothing() {

	  }
	  	  
	  @Benchmark
	  public void fillInput(Blackhole bh) {
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);		  
			  bh.consume(order);
		  }
		  order = getOrderNull();
		  
		  bh.consume(order);
	  }
	  
	  @Benchmark
	  public void fullMapWithModelMapper(Blackhole bh) {
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = MapperUtil.mapWithModelMapper(order);
		  
			  bh.consume(dto);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperUtil.mapWithModelMapper(order);
		  
		  bh.consume(dto2);
		  
	  }
	  
	  @Benchmark
	  public void fullMapWithModelMapperOptimized(Blackhole bh) {
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);		  
			  
			  OrderDTO dto = MapperUtil.mapWithModelMapperOptimized(order);
			  
			  bh.consume(dto);
		  }
		  order = getOrderNull();
		  OrderDTO dto = MapperUtil.mapWithModelMapperOptimized(order);
		  bh.consume(dto);
		  
	  }
	  
	  @Benchmark
	  public void fullMapWithDozer(Blackhole bh) {
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = MapperUtil.mapWithDozer(order);
		  
			  bh.consume(dto);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperUtil.mapWithDozer(order);
		  
		  bh.consume(dto2);
		  
	  }
	  
	  @Benchmark
	  public void fullMapWithDozerOptimized(Blackhole bh) {
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = MapperUtil.mapWithDozerOptimized(order);
		  
			  bh.consume(dto);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperUtil.mapWithDozerOptimized(order);
		  
		  bh.consume(dto2);
		  
	  }
	  
	  
	  
	  @Benchmark
	  public void fullMapManual(Blackhole bh) {
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = MapperUtil.mapManual(order);
		  
			  bh.consume(dto);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperUtil.mapManual(order);
		  
		  bh.consume(dto2);
	  }
	  
	  
}
