package net.franckbenault.microbench.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import net.franckbenault.microbench.TestUtils;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithHandTest {

	@Test
	public void testAsOrderDTO() {
		Order order = TestUtils.getOrder();
		MapperWithHand mapper = new MapperWithHand();
		OrderDTO orderDTO = mapper.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderDTOEmpty() {
		Order order = new Order();
		MapperWithHand mapper = new MapperWithHand();
		OrderDTO orderDTO = mapper.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrder() {
		OrderDTO orderDTO = TestUtils.getOrderDTO();
		MapperWithHand mapper = new MapperWithHand();
		Order order = mapper.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderEmpty() {
		OrderDTO orderDTO = new OrderDTO();
		MapperWithHand mapper = new MapperWithHand();
		Order order = mapper.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}

}
