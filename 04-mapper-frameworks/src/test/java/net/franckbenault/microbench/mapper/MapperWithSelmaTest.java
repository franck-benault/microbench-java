package net.franckbenault.microbench.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.xebia.extras.selma.Selma;
import net.franckbenault.microbench.TestUtils;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithSelmaTest {

	@Test
	public void testAsOrderDTO() {
		Order order = TestUtils.getOrder();
		MapperWithSelma mapper = Selma.builder(MapperWithSelma.class).build();
		OrderDTO orderDTO = mapper.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderDTOEmpty() {
		Order order = new Order();
		MapperWithSelma mapper = Selma.builder(MapperWithSelma.class).build();
		OrderDTO orderDTO = mapper.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrder() {
		OrderDTO orderDTO = TestUtils.getOrderDTO();
		MapperWithSelma mapper = Selma.builder(MapperWithSelma.class).build();
		Order order = mapper.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderEmpty() {
		OrderDTO orderDTO = new OrderDTO();
		MapperWithSelma mapper = Selma.builder(MapperWithSelma.class).build();
		Order order = mapper.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}

}
