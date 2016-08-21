package net.franckbenault.microbench.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Order;

public class MapperWithDozer implements AbstractMapper {
	

    public OrderDTO asOrderDTO(Order order) {
		List<String> myMappingFiles = new ArrayList<>();
		myMappingFiles.add("dozerMapping.xml");
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return mapper.map(order, OrderDTO.class,"order");

	}
    
    public Order asOrder(OrderDTO orderDto) {
		List<String> myMappingFiles = new ArrayList<>();
		myMappingFiles.add("dozerMapping.xml");
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return mapper.map(orderDto, Order.class,"order");
		
	}    
}
