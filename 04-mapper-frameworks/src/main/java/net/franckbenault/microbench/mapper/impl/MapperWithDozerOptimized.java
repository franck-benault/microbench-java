package net.franckbenault.microbench.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Order;

public class MapperWithDozerOptimized implements AbstractMapper {
	
	private static DozerBeanMapper mapper;
	
	static {
		List<String> myMappingFiles = new ArrayList<>();
		myMappingFiles.add("dozerMapping.xml");
		
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
	}

    public OrderDTO asOrderDTO(Order order) {

		return   
		    mapper.map(order, OrderDTO.class,"order");
		
	}
    
    public Order asOrder(OrderDTO orderDto) {
		return   
		    mapper.map(orderDto, Order.class,"order");

	}    
}
