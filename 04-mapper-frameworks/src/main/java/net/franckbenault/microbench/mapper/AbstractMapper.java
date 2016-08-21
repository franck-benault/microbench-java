package net.franckbenault.microbench.mapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public interface AbstractMapper {

    Order asOrder(OrderDTO orderDto);
    	
    OrderDTO asOrderDTO(Order order); 
    
}
