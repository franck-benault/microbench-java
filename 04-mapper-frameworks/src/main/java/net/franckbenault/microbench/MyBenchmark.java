package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import fr.xebia.extras.selma.Selma;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.mapper.MapperWithMapStruct;
import net.franckbenault.microbench.mapper.impl.MapperWithModelMapper;
import net.franckbenault.microbench.mapper.impl.MapperWithModelMapperOptimized;
import net.franckbenault.microbench.mapper.MapperWithSelma;
import net.franckbenault.microbench.mapper.impl.MapperWithDozer;
import net.franckbenault.microbench.mapper.impl.MapperWithDozerOptimized;
import net.franckbenault.microbench.mapper.impl.MapperWithHand;
import net.franckbenault.microbench.mapper.impl.MapperWithJMapper;
import net.franckbenault.microbench.mapper.impl.MapperWithOrika;
import net.franckbenault.microbench.mapper.impl.MapperWithOrikaOptimized;
import net.franckbenault.microbench.mapper.impl.MapperWithOrikaOptimized2;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class MyBenchmark {
	
	
	@State(Scope.Benchmark)
	public static class BenchmarkState {

		private Address getAddress(int i) {
			Address address = new Address();
			address.setCity("City" + i);
			address.setStreet("Street" + i);

			return address;
		}

		private Customer getCustomer(int i) {
			Customer customer = new Customer();
			customer.setName(getName(i));

			return customer;
		}

		private Name getName(int i) {
			Name name = new Name();
			name.setFirstName("firstName" + i);
			name.setLastName("lastName" + i);

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
			order.fillOrder();
			return order;
		}
		
		List<Order> list = new ArrayList<Order>(11);

		@Setup(Level.Trial)
		public void initList() {

			for (int i = 0; i < 10; i++) {
				list.add(getOrder(i));
			}
			list.add(getOrderNull());
		}
	}

	@Benchmark
	public void nothing() {

	}

	@Benchmark
	public void costObjectCreation(BenchmarkState bs, Blackhole bh) {	
		for (Order order : bs.list) {
			bh.consume(order);
		}
	}

	@Benchmark
	public void fullMapWithModelMapper(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithModelMapper();
		
		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithModelMapperOptimized(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithModelMapperOptimized();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithDozer(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithDozer();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithDozerOptimized(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithDozerOptimized();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithHand(BenchmarkState bs, Blackhole bh) {
		MapperWithHand mapper = new MapperWithHand();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithMapStruct(BenchmarkState bs, Blackhole bh) {
		
		for (Order order : bs.list) {
			OrderDTO dto = MapperWithMapStruct.INSTANCE.asOrderDTO(order);
			Order order2 = MapperWithMapStruct.INSTANCE.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithSelma(BenchmarkState bs, Blackhole bh) {
		MapperWithSelma mapper = Selma.builder(MapperWithSelma.class).build();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithOrika(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithOrika();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithOrikaOptimized(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithOrikaOptimized();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithOrikaOptimized2(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithOrikaOptimized2();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

	@Benchmark
	public void fullMapWithJMapper(BenchmarkState bs, Blackhole bh) {
		AbstractMapper mapper = new MapperWithJMapper();

		for (Order order : bs.list) {
			OrderDTO dto = mapper.asOrderDTO(order);
			Order order2 = mapper.asOrder(dto);
			
			bh.consume(dto);
			bh.consume(order2);
		}
	}

}
