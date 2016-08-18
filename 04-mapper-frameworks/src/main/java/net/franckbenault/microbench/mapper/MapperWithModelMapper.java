package net.franckbenault.microbench.mapper;

import org.modelmapper.ModelMapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithModelMapper {

    public OrderDTO asOrderDTO(Order order) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(order, OrderDTO.class);
    }
    
    public Order asOrder(OrderDTO orderDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(orderDto, Order.class);
    }
}
