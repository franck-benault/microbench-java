package net.franckbenault.microbench.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import net.franckbenault.microbench.TestUtils;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithMapStructTest {


	
	@Test
	public void testAsOrderDTO() {
		Order order = TestUtils.getOrder();
		OrderDTO orderDTO = MapperWithMapStruct.INSTANCE.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderDTOEmpty() {
		Order order = new Order();

		OrderDTO orderDTO = MapperWithMapStruct.INSTANCE.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrder() {
		OrderDTO orderDTO = TestUtils.getOrderDTO();
		Order order = MapperWithMapStruct.INSTANCE.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderEmpty() {
		OrderDTO orderDTO = new OrderDTO();
		Order order = MapperWithMapStruct.INSTANCE.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}

}
