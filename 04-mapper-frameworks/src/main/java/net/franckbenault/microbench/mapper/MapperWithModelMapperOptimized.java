package net.franckbenault.microbench.mapper;

import org.modelmapper.ModelMapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithModelMapperOptimized {
	
	private static final ModelMapper modelMapper = new ModelMapper();

    public OrderDTO asOrderDTO(Order order) {
		
		return modelMapper.map(order, OrderDTO.class);
    }
    
    public Order asOrder(OrderDTO orderDto) {
		
		return modelMapper.map(orderDto, Order.class);
    }
}
