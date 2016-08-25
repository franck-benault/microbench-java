package net.franckbenault.microbench.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import net.franckbenault.microbench.TestUtils;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.impl.MapperWithJMapper;
import net.franckbenault.microbench.source.Order;

public class MapperWithJMapperTest {

	private AbstractMapper getMapper() {
		return new MapperWithJMapper();
	}
	
	@Test
	public void testAsOrderDTO() {
		Order order = TestUtils.getOrder();
		AbstractMapper mapper = getMapper();
		OrderDTO orderDTO = mapper.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderDTOEmpty() {
		Order order = new Order();
		order.fillOrder();
		AbstractMapper mapper = getMapper();
		OrderDTO orderDTO = mapper.asOrderDTO(order);
		
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrder() {
		OrderDTO orderDTO = TestUtils.getOrderDTO();
		AbstractMapper mapper = getMapper();
		Order order = mapper.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}
	
	@Test
	public void testAsOrderEmpty() {
		OrderDTO orderDTO = new OrderDTO();
		AbstractMapper mapper = getMapper();
		
		Order order = mapper.asOrder(orderDTO);
		
		assertNotNull(order);
		TestUtils.checkMapping(order, orderDTO);
	}

}
