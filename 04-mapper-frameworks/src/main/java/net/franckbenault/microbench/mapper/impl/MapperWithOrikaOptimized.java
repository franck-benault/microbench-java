package net.franckbenault.microbench.mapper.impl;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Order;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


public class MapperWithOrikaOptimized implements AbstractMapper {
	
	private static MapperFactory mapperFactory;
	private static MapperFacade mapper;
	
	static {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		//BoundMapperFacade<Person,PersonDto> mapper = 
		//		mapperFactory.getMapperFacade(Person.class, PersonDto.class);
			
		mapperFactory.classMap(Order.class, OrderDTO.class)
	  	.field("billingAddress.street", "billingStreet")
	  	.field("billingAddress.city", "billingCity")
	  	.field("customer.name.firstName", "customerFirstName")
	  	.field("customer.name.lastName", "customerLastName")
	  	.register();
		
		mapper = mapperFactory.getMapperFacade();
	}
	
	public OrderDTO asOrderDTO(Order order) {
		
		
		return mapper.map(order, OrderDTO.class);
		
	}

	public Order asOrder(OrderDTO orderDto) {

		return mapper.map(orderDto, Order.class);
	
	}
}
