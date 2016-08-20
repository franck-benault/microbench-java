package net.franckbenault.microbench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import fr.xebia.extras.selma.Selma;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.MapperWithHand;
import net.franckbenault.microbench.mapper.MapperWithMapStruct;
import net.franckbenault.microbench.mapper.MapperWithModelMapper;
import net.franckbenault.microbench.mapper.MapperWithModelMapperOptimized;
import net.franckbenault.microbench.mapper.MapperWithSelma;
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
		order.setBilling(getAddress(i));
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
		  MapperWithModelMapper mapper = new MapperWithModelMapper();
		  
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = mapper.asOrderDTO(order);
			  Order order2 = mapper.asOrder(dto);
			  
			  bh.consume(dto);
			  bh.consume(order2);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = mapper.asOrderDTO(order);
		  Order order2 = mapper.asOrder(dto2);
		  
		  bh.consume(dto2);
		  bh.consume(order2);
		  
	  }
	  
	  @Benchmark
	  public void fullMapWithModelMapperOptimized(Blackhole bh) {
		  MapperWithModelMapperOptimized mapper = new MapperWithModelMapperOptimized();
		  
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = mapper.asOrderDTO(order);
			  Order order2 = mapper.asOrder(dto);
			  
			  bh.consume(dto);
			  bh.consume(order2);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = mapper.asOrderDTO(order);
		  Order order2 = mapper.asOrder(dto2);
		  
		  bh.consume(dto2);
		  bh.consume(order2);
		  
	  }
	  
	  //@Benchmark
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
	  
	  //@Benchmark
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
	  public void fullMapWithHand(Blackhole bh) {
		  MapperWithHand mapper = new MapperWithHand();
		  
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = mapper.asOrderDTO(order);
			  Order order2 = mapper.asOrder(dto);
			  
			  bh.consume(dto);
			  bh.consume(order2);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = mapper.asOrderDTO(order);
		  Order order2 = mapper.asOrder(dto2);
		  
		  bh.consume(dto2);
		  bh.consume(order2);
	  }
	  
	  @Benchmark
	  public void fullMapWithMapStruct(Blackhole bh) {
	  
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = MapperWithMapStruct.INSTANCE.asOrderDTO(order);
			  Order order2 = MapperWithMapStruct.INSTANCE.asOrder(dto);
			  
			  bh.consume(dto);
			  bh.consume(order2);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = MapperWithMapStruct.INSTANCE.asOrderDTO(order);
		  Order order2 = MapperWithMapStruct.INSTANCE.asOrder(dto2);
		  
		  bh.consume(dto2);
		  bh.consume(order2);
	  }
	  
	  @Benchmark
	  public void fullMapWithSelma(Blackhole bh) {
		  MapperWithSelma mapper = Selma.builder(MapperWithSelma.class).build();
		  
		  Order order;
		  for(int i=0; i<10; i++) {
			  order = getOrder(i);
			  OrderDTO dto = mapper.asOrderDTO(order);
			  Order order2 = mapper.asOrder(dto);
			  
			  bh.consume(dto);
			  bh.consume(order2);
		  }
		  
		  order = getOrderNull();
		  OrderDTO dto2 = mapper.asOrderDTO(order);
		  Order order2 = mapper.asOrder(dto2);
		  
		  bh.consume(dto2);
		  bh.consume(order2);
	  }
}
