package net.franckbenault.microbench.mapper.impl;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Order;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


public class MapperWithOrikaOptimized2 implements AbstractMapper {
	
	private static MapperFactory mapperFactory;
	private static BoundMapperFacade<Order, OrderDTO> mapper;
	
	static {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(Order.class, OrderDTO.class)
	  	.field("billingAddress.street", "billingStreet")
	  	.field("billingAddress.city", "billingCity")
	  	.field("customer.name.firstName", "customerFirstName")
	  	.field("customer.name.lastName", "customerLastName")
	  	.register();
		
		mapper = 
				mapperFactory.getMapperFacade(Order.class, OrderDTO.class);			

		
	}
	
	public OrderDTO asOrderDTO(Order order) {
		
		
		return mapper.map(order);
		
	}

	public Order asOrder(OrderDTO orderDto) {

		return mapper.mapReverse(orderDto);
	
	}
}
