package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;


import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperUtil {
	
	private static ModelMapper modelMapper;

	public static  OrderDTO mapWithModelMapper(Order order) {

		ModelMapper modelMapper = new ModelMapper();
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}
	
	public static  OrderDTO mapWithModelMapperOptimized(Order order) {

		if(modelMapper==null) {
			modelMapper = new ModelMapper();
		}
		
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}
	
	public static OrderDTO mapWithDozer(Order order) {
		
		List<String> myMappingFiles = new ArrayList<>();
		myMappingFiles.add("dozerMapping.xml");
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		OrderDTO orderDTO =   
		    mapper.map(order, OrderDTO.class,"order");
		
		return orderDTO;
	}

	public static OrderDTO mapManual(Order order) {

		if (order == null) {
			return null;
		} else {

			OrderDTO orderDTO = new OrderDTO();
			if(order.getBillingAddress()!=null) {
				orderDTO.setBillingCity(order.getBillingAddress().getCity());
				orderDTO.setBillingStreet(order.getBillingAddress().getStreet());
			}
			if(order.getCustomer()!=null && order.getCustomer().getName()!=null) {
				orderDTO.setCustomerFirstName(order.getCustomer().getName().getFirstName());
				orderDTO.setCustomerLastName(order.getCustomer().getName().getLastName());
			}
			return orderDTO;
		}
	}
}
