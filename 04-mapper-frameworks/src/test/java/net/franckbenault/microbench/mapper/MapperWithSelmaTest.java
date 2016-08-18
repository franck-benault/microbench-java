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

}
