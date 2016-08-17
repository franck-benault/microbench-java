package net.franckbenault.microbench.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import net.franckbenault.microbench.TestUtils;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithMapStructTest {

	@Test
	public void testMap() {
		Order order = TestUtils.getOrder();
		OrderDTO orderDTO = MapperWithMapStruct.INSTANCE.map(order);
		assertNotNull(orderDTO);
		TestUtils.checkMapping(order, orderDTO);
	}

}
