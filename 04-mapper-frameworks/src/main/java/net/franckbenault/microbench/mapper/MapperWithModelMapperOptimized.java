package net.franckbenault.microbench.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperWithModelMapperOptimized {
	
	private static ModelMapper modelMapper;
	
	static {
		modelMapper = new ModelMapper();
		PropertyMap<OrderDTO, Order> orderMap = new PropertyMap<OrderDTO, Order>() {
			  protected void configure() {
			    map().getBillingAddress().setStreet(source.getBillingStreet());
			    map().getBillingAddress().setCity(source.getBillingCity());
			  }
			};
			modelMapper.addMappings(orderMap);
	}

    public OrderDTO asOrderDTO(Order order) {
		
		return modelMapper.map(order, OrderDTO.class);
    }
    
    public Order asOrder(OrderDTO orderDto) {
		
		return modelMapper.map(orderDto, Order.class);
    }
}
