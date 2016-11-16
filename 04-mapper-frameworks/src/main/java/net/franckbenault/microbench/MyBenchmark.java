package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import net.franckbenault.microbench.source.Order;

public class MyBenchmark {
	
	
	@State(Scope.Benchmark)
	public static class BenchmarkState {


		private Order getOrderNull() {
			Order order = new Order();
			order.fillOrder();
			return order;
		}
		
		List<Order> list = new ArrayList<Order>(11);

		@Setup(Level.Trial)
		public void initList() {
			
			int size =10;
			list = IntStream.range(0,size)
					.mapToObj( Order::new)
					.collect(Collectors.toCollection(
							() -> new ArrayList<Order>(size+1)));

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
