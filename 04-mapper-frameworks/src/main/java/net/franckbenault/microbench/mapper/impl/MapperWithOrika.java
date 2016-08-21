package net.franckbenault.microbench.mapper.impl;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Order;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


public class MapperWithOrika implements AbstractMapper {
	
	public OrderDTO asOrderDTO(Order order) {
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		
		
		mapperFactory.classMap(Order.class, OrderDTO.class)
	  	.field("billingAddress.street", "billingStreet")
	  	.field("billingAddress.city", "billingCity")
	  	.field("customer.name.firstName", "customerFirstName")
	  	.field("customer.name.lastName", "customerLastName")
	  	.register();
		
	
		MapperFacade mapper = mapperFactory.getMapperFacade();
		OrderDTO orderDto = mapper.map(order, OrderDTO.class);
		
		return orderDto;
	}

	public Order asOrder(OrderDTO orderDto) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(Order.class, OrderDTO.class)
	  	.field("billingAddress.street", "billingStreet")
	  	.field("billingAddress.city", "billingCity")
	  	.field("customer.name.firstName", "customerFirstName")
	  	.field("customer.name.lastName", "customerLastName")
	  	.register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Order order = mapper.map(orderDto, Order.class);
		
		return order;
	}
}
