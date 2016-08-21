package net.franckbenault.microbench.mapper.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Order;

public class MapperWithModelMapper implements AbstractMapper {

    public OrderDTO asOrderDTO(Order order) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(order, OrderDTO.class);
    }
    
    public Order asOrder(OrderDTO orderDto) {
		ModelMapper modelMapper = new ModelMapper();
		
		PropertyMap<OrderDTO, Order> orderMap = new PropertyMap<OrderDTO, Order>() {
			  protected void configure() {
			    map().getBillingAddress().setStreet(source.getBillingStreet());
			    map().getBillingAddress().setCity(source.getBillingCity());
			  }
			};
		
			modelMapper.addMappings(orderMap);
		return modelMapper.map(orderDto, Order.class);
    }
}
